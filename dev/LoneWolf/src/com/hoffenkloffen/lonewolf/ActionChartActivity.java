package com.hoffenkloffen.lonewolf;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import com.hoffenkloffen.lonewolf.controllers.GameContext;
import com.hoffenkloffen.lonewolf.controllers.events.ActionChartEventHandler;
import com.hoffenkloffen.lonewolf.controllers.interfaces.ActionChartJavascriptInterface;
import com.hoffenkloffen.lonewolf.controllers.interfaces.JavascriptInterface;

import java.util.ArrayList;
import java.util.List;

public class ActionChartActivity extends BaseBrowserActivity implements ActionChartEventHandler {

    private static final String TAG = ActionChartActivity.class.getSimpleName();

    // Controllers
    private GameContext context;

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

        context = GameContext.getInstance();
        context.getActionChartManager().setResourceHandler(new DebugActionChartResourceHandler(this));
        context.getActionChartManager().setRenderer(this);
    }

    protected Iterable<JavascriptInterface> getJavascriptInterfaces() {
        List<JavascriptInterface> result = new ArrayList<JavascriptInterface>();
        result.add(new ActionChartJavascriptInterface(this));

        return result;
    }

    private void display() {

        Log.d(TAG, "Display");

        context.getActionChartManager().display();
    }

    //<editor-fold desc="ActionChartEventHandler">

    @Override
    public void take(final String name) {

        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Take item: " + name);

                context.getActionChartManager().take(name);
                display();
            }
        });
    }

    @Override
    public void discard(final String name) {

        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Discard item: " + name);

                context.getActionChartManager().discard(name);
                display();
            }
        });
    }

    @Override
    public void use(String name) {
    }

    //</editor-fold>
}
