package com.hoffenkloffen.lonewolf;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.*;
import android.widget.Toast;
import com.hoffenkloffen.lonewolf.controllers.ActionChartResourceHandler;
import com.hoffenkloffen.lonewolf.controllers.ConfigurationManager;
import com.hoffenkloffen.lonewolf.controllers.VersionManager;
import com.hoffenkloffen.lonewolf.controllers.events.ActionChartEventHandler;
import com.hoffenkloffen.lonewolf.controllers.events.DebugEventHandler;
import com.hoffenkloffen.lonewolf.controllers.events.SectionEventHandler;
import com.hoffenkloffen.lonewolf.controllers.interfaces.ActionChartJavascriptInterface;
import com.hoffenkloffen.lonewolf.controllers.interfaces.JavascriptInterface;
import com.hoffenkloffen.lonewolf.controllers.interfaces.SectionJavascriptInterface;
import com.hoffenkloffen.lonewolf.controllers.section.Section;
import com.hoffenkloffen.lonewolf.controllers.section.SectionManager;
import com.hoffenkloffen.lonewolf.views.SectionRenderer;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseActivity extends Activity implements ConfigurationManager, VersionManager, SectionRenderer, SectionEventHandler, ActionChartEventHandler, DebugEventHandler {

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

        manager = new SectionManager(new DebugSectionResourceHandler(this), this);
        initSections(manager);

        // DEBUG: GestureDetection
        initGestureDetection();

        //Log.d(TAG, manager.toString());
    }

    protected Iterable<JavascriptInterface> getJavascriptInterfaces()
    {
        List<JavascriptInterface> result = new ArrayList<JavascriptInterface>();
        result.add(new SectionJavascriptInterface(this));
        result.add(new ActionChartJavascriptInterface(this));

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

    //<editor-fold desc="SectionRenderer">

    @Override
    public void loadData(String data, String mimeType, String encoding) {
        Log.d(TAG, data);

        browser.loadData(data, mimeType, encoding);
    }

    //</editor-fold>

    //<editor-fold desc="SectionEventHandler">

    @Override
    public void turnTo(final String section) {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Turn to section: " + section);

                manager.enter(section);
            }
        });
    }

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

    @Override
    public void display() {

        final ActionChartResourceHandler resourceHandler = new DebugActionChartResourceHandler(this);

        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Display action chart");

                manager.displayActionChart(resourceHandler);
            }
        });
    }

    //</editor-fold>

    //<editor-fold desc="ActionChartEventHandler">

    @Override
    public void take(final String name) {

        final ActionChartResourceHandler resourceHandler = new DebugActionChartResourceHandler(this);

        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Take item: " + name);

                manager.take(name);
                manager.displayActionChart(resourceHandler);
            }
        });
    }

    @Override
    public void discard(final String name) {

        final ActionChartResourceHandler resourceHandler = new DebugActionChartResourceHandler(this);

        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Discard item: " + name);

                manager.discard(name);
                manager.displayActionChart(resourceHandler);
            }
        });
    }

    //</editor-fold>

    @Override
    public void use(String name) {
    }

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
}
