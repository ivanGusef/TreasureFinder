package com.ivangusev.tf;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

/**
 * Created by Ivan Gusev (ivan.gusev@altarix.ru) on 19.03.14.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String destPackage = getString(R.string.dest_app);
        List<PackageInfo> list = getPackageManager().getInstalledPackages(PackageManager.GET_RECEIVERS);
        int i = 0;
        for (PackageInfo packageInfo : list) {
            if (packageInfo.packageName.contains("altarix.creeperchest")) {
                Log.e("GGW", "Receivers: " + String.valueOf(i));
            }
            i++;
        }

        i = 0;
        list = getPackageManager().getInstalledPackages(PackageManager.GET_PROVIDERS);
        for (PackageInfo packageInfo : list) {
            if (packageInfo.packageName.contains("altarix.creeperchest")) {
                Log.e("GGW", "Providers: " + String.valueOf(i));
            }
            i++;
        }

    }
}
