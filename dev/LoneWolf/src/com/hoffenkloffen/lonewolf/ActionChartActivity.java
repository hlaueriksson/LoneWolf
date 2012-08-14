package com.hoffenkloffen.lonewolf;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import com.google.inject.Inject;
import com.hoffenkloffen.lonewolf.context.DebugActionChartResourceHandler;
import com.hoffenkloffen.lonewolf.core.abstractions.IActionChartManager;
import com.hoffenkloffen.lonewolf.core.events.ActionChartEventHandler;
import com.hoffenkloffen.lonewolf.core.interfaces.ActionChartJavascriptInterface;
import com.hoffenkloffen.lonewolf.core.interfaces.JavascriptInterface;

import java.util.ArrayList;
import java.util.List;

public class ActionChartActivity extends BaseBrowserActivity implements ActionChartEventHandler {

    private static final String TAG = ActionChartActivity.class.getSimpleName();

    @Inject IActionChartManager actionChartManager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browser);

        browser = (WebView) findViewById(R.id.browser);

        init();
        display();

        Log.d(TAG, "Done");
    }

    @Override
    protected void init() {
        super.init();

        actionChartManager
                .set(new DebugActionChartResourceHandler(this))
                .set(this);
    }

    protected Iterable<JavascriptInterface> getJavascriptInterfaces() {
        List<JavascriptInterface> result = new ArrayList<JavascriptInterface>();
        result.add(new ActionChartJavascriptInterface(this));

        return result;
    }

    private void display() {

        Log.d(TAG, "Display");

        actionChartManager.display();
    }

    //<editor-fold desc="ActionChartEventHandler">

    @Override
    public void take(final String name) {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Take item: " + name);

                actionChartManager.take(name);
                display();
            }
        });
    }

    @Override
    public void discard(final String name) {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Discard item: " + name);

                actionChartManager.discard(name);
                display();
            }
        });
    }

    @Override
    public void use(final String name) {

        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Use item: " + name);

                actionChartManager.use(name);
                display();
            }
        });
    }

    //</editor-fold>
}
