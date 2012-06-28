package com.hoffenkloffen.lonewolf;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Base64;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.*;
import android.widget.Toast;
import com.hoffenkloffen.lonewolf.controllers.*;
import com.hoffenkloffen.lonewolf.controllers.events.AggregatedEventHandler;
import com.hoffenkloffen.lonewolf.controllers.events.DebugEventHandler;
import com.hoffenkloffen.lonewolf.controllers.interfaces.*;
import com.hoffenkloffen.lonewolf.controllers.section.Section;
import com.hoffenkloffen.lonewolf.controllers.section.SectionManager;
import com.hoffenkloffen.lonewolf.models.Illustration;
import com.hoffenkloffen.lonewolf.views.SectionRenderer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseActivity extends Activity implements ConfigurationManager, VersionManager, SectionResourceManager, SectionRenderer, AggregatedEventHandler, DebugEventHandler {

    private static final String TAG = BaseActivity.class.getSimpleName();

    // Views
    protected WebView browser;

    // Controllers
    protected SectionManager manager;

    // DEBUG: GestureDetection
    protected GestureDetector gestureDetector;
    protected View.OnTouchListener gestureListener;

    protected void init() {
        WebSettings settings = browser.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setAppCacheEnabled(false);

        browser.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Log.e(TAG, errorCode + ": " + description + " (" + failingUrl + ")");
                Toast.makeText(getApplicationContext(), description, Toast.LENGTH_SHORT).show();
            }
        });

        browser.setWebChromeClient(new WebChromeClient() {
            public boolean onConsoleMessage(ConsoleMessage cm) {
                Log.d(TAG, cm.message() + " -- From line " + cm.lineNumber() + " of " + cm.sourceId());
                return true;
            }
        });

        for (JavascriptInterface javascriptInterface : getJavascriptInterfaces()) {
            browser.addJavascriptInterface(javascriptInterface, javascriptInterface.getInterfaceName());
        }

        /*
        browser.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                // Inject JavaScript into the page which just finished loading.
                browser.loadUrl(js.toString());
            }
        });*/

        if(isDebugMode()) Log.d(TAG, "Configuration: Debug");
        else Log.d(TAG, "Configuration: Release");

        manager = new SectionManager(this, this);
        initSections(manager);

        // DEBUG: GestureDetection
        initGestureDetection();

        //Log.d(TAG, manager.toString());
    }

    protected Iterable<JavascriptInterface> getJavascriptInterfaces()
    {
        List<JavascriptInterface> result = new ArrayList<JavascriptInterface>();
        result.add(new ActionChartJavascriptInterface(this));
        result.add(new ChoiceJavascriptInterface(this));
        result.add(new CombatJavascriptInterface(this));
        result.add(new RandomNumberJavascriptInterface(this));

        return result;
    }

    protected abstract void initSections(SectionManager manager);

    public boolean isDebugMode() {
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getApplication().getPackageName(), PackageManager.GET_CONFIGURATIONS);
            int flags = packageInfo.applicationInfo.flags;
            return (flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception ex) {
            Log.e(TAG, "isDebugMode failed.", ex);
        }

        return false;
    }

    public boolean isReleaseMode() {
        return !isDebugMode();
    }

    //<editor-fold desc="GestureDetection">

    // DEBUG: GestureDetection

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    protected void initGestureDetection()
    {
        // Gesture detection
        gestureDetector = new GestureDetector(new MainGestureDetector(this));
        gestureListener = new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        };
    }

    //</editor-fold>

    //<editor-fold desc="VersionManager">

    public String getLibraryVersion()
    {
        return "0.0.1";
    }

    public abstract String getApplicationVersion();

    public abstract String getDatabaseVersion();

    //</editor-fold>

    //<editor-fold desc="SectionResourceManager">

    @Override
    public String getHtmlTemplate() {
        return readFileToString(R.raw.html_section_template);
    }

    public abstract String getHtmlTitle();

    @Override
    public String getHtmlStyle() {
        return readFileToString(R.raw.css_section);
    }

    @Override
    public String getHtmlScript() {
        return readFileToString(R.raw.js_section);
    }

    @Override
    public String getHtmlContent(String section) {
        String filename = "sect" + padSection(section);

        return readFileToString(getResId(filename, "raw"));
    }

    @Override
    public String getBase64Image(Illustration illustration) {
        byte[] bytes = readFileToBytes(getResId(illustration.getResourceName(), "raw"));

        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

    //</editor-fold>

    //<editor-fold desc="SectionRenderer">

    @Override
    public void loadData(String data, String mimeType, String encoding) {
        Log.d(TAG, data);

        browser.loadData(data, mimeType, encoding);
    }

    //</editor-fold>

    //<editor-fold desc="Events">

    // ChoiceEventHandler

    @Override
    public void turnTo(final String section) {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Turn to section: " + section);

                manager.enter(section);
            }
        });
    }

    // RandomNumberEventHandler

    @Override
    public void roll() {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Roll a random number");

                manager.roll();
            }
        });
    }

    @Override
    public void roll(final String index) {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Roll a random number: " + index);

                manager.roll(index);
            }
        });
    }

    // CombatEventHandler

    @Override
    public void fight() {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Fight enemy");

                manager.fight();
            }
        });
    }

    @Override
    public void fight(final String index) {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Fight enemy: " + index);

                manager.fight(index);
            }
        });
    }

    // ActionChartEventHandler

    @Override
    public void display() {
        // TODO: implement
    }

    //</editor-fold>

    //<editor-fold desc="DebugEventHandler">

    @Override
    public void goToPrevious() {
        Log.d(TAG, "goToPrevious");

        Section section = manager.getCurrent();
        int number = Integer.parseInt(section.getNumber());

        if(number > 1) manager.enter(Integer.toString(--number));
    }

    @Override
    public void goToNext() {
        Log.d(TAG, "goToNext");

        Section section = manager.getCurrent();
        int number = Integer.parseInt(section.getNumber());

        if(number < 350) manager.enter(Integer.toString(++number));
    }

    @Override
    public void goTo(String section) { // TODO
    }

    //</editor-fold>

    //<editor-fold desc="Resources">

    private String readFileToString(int resId) {
        StringBuffer result = new StringBuffer();

        InputStream stream = getResources().openRawResource(resId);
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String line;

        try {
            if (stream != null) {
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
            }
            stream.close();
        } catch (IOException ex) {
            Log.e(TAG, "Read file failed.", ex);
        }

        return result.toString();
    }

    private byte[] readFileToBytes(int resId) {
        ByteArrayOutputStream result = new ByteArrayOutputStream();

        InputStream stream = getResources().openRawResource(resId);
        int i;

        try {
            i = stream.read();
            while (i != -1)
            {
                result.write(i);
                i = stream.read();
            }
            stream.close();
        } catch (IOException ex) {
            Log.e(TAG, "Read file failed.", ex);
        }

        return result.toByteArray();
    }

    private String padSection(String section)
    {
        return String.format("%3s", section).replace(' ', '0');
    }

    private int getResId(String filename, String type) {

        return getApplicationContext().getResources().getIdentifier(filename, type, getPackage());
    }

    protected String getPackage() {
        return getApplication().getPackageName();
    }

    //</editor-fold>
}
