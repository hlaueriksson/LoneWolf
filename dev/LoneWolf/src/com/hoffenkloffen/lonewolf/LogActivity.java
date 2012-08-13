package com.hoffenkloffen.lonewolf;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;
import com.google.inject.Inject;
import com.hoffenkloffen.lonewolf.abstractions.Logger;
import roboguice.activity.RoboActivity;

public class LogActivity extends RoboActivity {

    private static final String TAG = LogActivity.class.getSimpleName();

    @Inject Logger logger;

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
        log.setMovementMethod(new ScrollingMovementMethod());
    }

    private void display() {
        Log.d(TAG, "Display");

        // Html.fromHtml()
        log.append(logger.getText());
    }
}