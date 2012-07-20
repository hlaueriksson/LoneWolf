package com.hoffenkloffen.lonewolf;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;
import com.hoffenkloffen.lonewolf.controllers.GameContext;

public class LogActivity extends Activity {

    private static final String TAG = LogActivity.class.getSimpleName();

    // Controllers
    private GameContext context;

    // View
    private TextView log;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log);

        log = (TextView) findViewById(R.id.log);

        init();
        display();

        Log.d(TAG, "Done");
    }

    private void init() {
        context = GameContext.getInstance();
    }

    private void display() {
        Log.d(TAG, "Display");

        log.append(Html.fromHtml(context.getLogger().getText().toString()));
    }
}