package com.ivangusev.tf;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Ivan Gusev (ivan.gusev@altarix.ru) on 19.03.14.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        final Intent intent;
        switch (view.getId()) {
            case R.id.find_magic_btn:
                final Cursor cursor = getContentResolver().query(Uri.parse("content://ru.altarix.chest/magic"), null, null, null, null);
                if (cursor != null) {
                    cursor.moveToFirst();
                    magic = cursor.getInt(0);
                    cursor.close();
                    findViewById(R.id.tell_btn).setEnabled(true);
                }
                break;
            case R.id.tell_btn:
                intent = new Intent("tell");
                intent.addCategory("creeperchest.creeper");
                intent.putExtra("phrase", "Notch " + magic);
                sendBroadcast(intent);
                findViewById(R.id.open_btn).setEnabled(true);
                break;
            case R.id.open_btn:
                intent = new Intent("open");
                intent.addCategory("creeperchest.chest");
                sendBroadcast(intent);
                break;
        }
    }

    private int magic;
}
