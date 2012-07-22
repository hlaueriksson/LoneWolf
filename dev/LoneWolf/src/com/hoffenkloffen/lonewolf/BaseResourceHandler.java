package com.hoffenkloffen.lonewolf;

import android.content.Context;
import android.util.Log;

import java.io.*;

public abstract class BaseResourceHandler {

    private static final String TAG = BaseResourceHandler.class.getSimpleName();

    protected Context context;

    public BaseResourceHandler(Context context) {
        this.context = context;
    }

    protected String readFileToString(int resId) {
        StringBuilder result = new StringBuilder();

        InputStream stream = context.getResources().openRawResource(resId);
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

    protected byte[] readFileToBytes(int resId) {
        ByteArrayOutputStream result = new ByteArrayOutputStream();

        InputStream stream = context.getResources().openRawResource(resId);
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

    protected int getResId(String filename, String type) {
        return context.getApplicationContext().getResources().getIdentifier(filename, type, getPackage());
    }

    protected String getPackage() {
        return context.getPackageName();
    }
}
