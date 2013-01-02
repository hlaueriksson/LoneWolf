package com.hoffenkloffen.lonewolf.book01;

import android.os.Bundle;
import android.util.Log;
import com.hoffenkloffen.lonewolf.BaseActivity;
import com.hoffenkloffen.lonewolf.core.abstractions.IItemManager;
import com.hoffenkloffen.lonewolf.core.abstractions.ISectionManager;
import roboguice.inject.ContentView;

@ContentView(R.layout.main)
public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();

        Log.d(TAG, "Done");
    }

    @Override
    public String getApplicationVersion() {
        return "0.0.1";
    }

    @Override
    public String getDatabaseVersion() {
        return "0.0.1";
    }

    protected void initItems(IItemManager manager) {
        Log.d(TAG, "initItems");

        ItemFactory factory = new ItemFactory();
        factory.init(manager);
    }

    protected void initSections(ISectionManager manager) {
        Log.d(TAG, "initSections");

        SectionFactory factory = new SectionFactory();
        factory.init(manager);
    }
}
