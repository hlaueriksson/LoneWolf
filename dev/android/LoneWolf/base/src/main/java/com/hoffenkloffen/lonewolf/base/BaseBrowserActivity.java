package com.hoffenkloffen.lonewolf.base;

import android.util.Log;
import android.webkit.*;
import android.widget.Toast;
import com.hoffenkloffen.lonewolf.base.abstractions.BrowserRenderer;
import com.hoffenkloffen.lonewolf.base.core.interfaces.JavascriptInterface;
import roboguice.activity.RoboActivity;

public abstract class BaseBrowserActivity extends RoboActivity implements BrowserRenderer {

    private static final String TAG = BaseBrowserActivity.class.getSimpleName();

    // Views
    protected WebView browser;

    protected String javascript;

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

        browser.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {

                if(javascript == null) return;
                if(javascript.isEmpty()) return;

                Log.d(TAG, javascript);

                // Inject JavaScript into the page which just finished loading.
                browser.loadUrl("javascript:" + javascript);
            }
        });

        for (JavascriptInterface javascriptInterface : getJavascriptInterfaces()) {
            browser.addJavascriptInterface(javascriptInterface, javascriptInterface.getInterfaceName());
        }
    }

    protected abstract Iterable<JavascriptInterface> getJavascriptInterfaces();

    //<editor-fold desc="BrowserRenderer">

    @Override
    public void load(String url) {
        Log.d(TAG, url);

        browser.loadUrl(url);
    }

    @Override
    public void inject(String javascript) {
        this.javascript = javascript;
    }

    //</editor-fold>
}
