package com.hoffenkloffen.lonewolf;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.hoffenkloffen.lonewolf.controllers.GameContext;
import com.hoffenkloffen.lonewolf.controllers.events.DebugEventHandler;
import com.hoffenkloffen.lonewolf.controllers.events.SectionEventHandler;
import com.hoffenkloffen.lonewolf.controllers.interfaces.JavascriptInterface;
import com.hoffenkloffen.lonewolf.controllers.interfaces.SectionJavascriptInterface;
import com.hoffenkloffen.lonewolf.controllers.section.Section;

import java.util.ArrayList;
import java.util.List;

public class SectionActivity extends BaseBrowserActivity implements SectionEventHandler, DebugEventHandler {

    private static final String TAG = SectionActivity.class.getSimpleName();

    // Controllers
    protected GameContext context;

    // DEBUG: GestureDetection
    protected GestureDetector gestureDetector;
    protected View.OnTouchListener gestureListener;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browser);

        browser = (WebView) findViewById(R.id.browser);

        init();
        turnTo("1"); // TODO: display

        Log.d(TAG, "Done");
    }

    @Override
    protected void init() {
        super.init();

        // DEBUG: GestureDetection
        initGestureDetection();

        context = GameContext.getInstance();
        context.getSectionManager().setResourceHandler(new DebugSectionResourceHandler(this));
        context.getSectionManager().setRenderer(this);
        context.getRandomNumberManager().setResourceHandler(new DebugSectionResourceHandler(this));
        context.getRandomNumberManager().setRenderer(this);
        context.getCombatManager().setResourceHandler(new DebugSectionResourceHandler(this));
        context.getCombatManager().setRenderer(this);
    }

    protected Iterable<JavascriptInterface> getJavascriptInterfaces()
    {
        List<JavascriptInterface> result = new ArrayList<JavascriptInterface>();
        result.add(new SectionJavascriptInterface(this));

        return result;
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

    //<editor-fold desc="SectionEventHandler">

    @Override
    public void turnTo(final String section) {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Turn to section: " + section);

                context.getSectionManager().enter(section);
            }
        });
    }

    @Override
    public void roll() {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Roll a random number");

                context.getRandomNumberManager().roll();
            }
        });
    }

    @Override
    public void roll(final String index) {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Roll a random number: " + index);

                context.getRandomNumberManager().roll(index);
            }
        });
    }

    @Override
    public void fight() {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Fight enemy");

                context.getCombatManager().fight();
            }
        });
    }

    @Override
    public void fight(final String index) {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Fight enemy: " + index);

                context.getCombatManager().fight(index);
            }
        });
    }

    @Override
    public void display() {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Display action chart");

                startActivity(new Intent(getBaseContext(), ActionChartActivity.class));
            }
        });
    }

    //</editor-fold>

    //<editor-fold desc="DebugEventHandler">

    @Override
    public void goToPrevious() {
        Log.d(TAG, "goToPrevious");

        Section section = context.getSectionManager().getCurrent();
        int number = Integer.parseInt(section.getNumber());

        if(number > 1) context.getSectionManager().enter(Integer.toString(--number));
    }

    @Override
    public void goToNext() {
        Log.d(TAG, "goToNext");

        Section section = context.getSectionManager().getCurrent();
        int number = Integer.parseInt(section.getNumber());

        if(number < 350) context.getSectionManager().enter(Integer.toString(++number));
    }

    @Override
    public void goTo(String section) { // TODO
    }

    //</editor-fold>
}
