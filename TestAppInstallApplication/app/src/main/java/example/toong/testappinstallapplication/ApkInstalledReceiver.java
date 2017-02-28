package example.toong.testappinstallapplication;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by phanvanlinh on 15/02/2017.
 * phanvanlinh.94vn@gmail.com
 */

public class ApkInstalledReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "new app", Toast.LENGTH_SHORT).show();
        List<PackageInfo> apps = context.getPackageManager().getInstalledPackages(0);
        int appSize = apps.size();

        long maxInstallTime = apps.get(0).firstInstallTime;

        for (int i = 0; i < appSize; i++){
            long firstInstallTime = apps.get(i).firstInstallTime;
            if(firstInstallTime > maxInstallTime){
                maxInstallTime = firstInstallTime;
            }
        }

        ArrayList<AppInfo> res = new ArrayList<>();
        for (int i = 0; i < apps.size(); i++) {
//            if(apps.get(i).firstInstallTime == maxInstallTime){
                PackageInfo p = apps.get(i);

                AppInfo newInfo = new AppInfo();
                newInfo.appname = p.applicationInfo.loadLabel(context.getPackageManager()).toString();
                newInfo.pname = p.packageName;
                newInfo.versionName = p.versionName;
                newInfo.versionCode = p.versionCode;
                newInfo.firstInstallTime = p.firstInstallTime;
                newInfo.icon = p.applicationInfo.loadIcon(context.getPackageManager());
                res.add(newInfo);
//                break;
//            }
        }

        Log.i("Linh", "max install time" + maxInstallTime);
        for(int i = 0; i < res.size(); i++){
            AppInfo newInfo = res.get(i);
            Log.i("Linh","==============");
            Log.i("Linh","appname = "+newInfo.appname);
            Log.i("Linh","pname = "+newInfo.pname);
            Log.i("Linh","first install = "+newInfo.firstInstallTime);
        }

        Intent i = new Intent(context, AlertDialogActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        context.startActivity(i);
//        showAlertDialog(context);
    }

    private void showAlertDialog(Context context){
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("Alert message to be shown");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    class AppInfo{
        String appname = "";
        String pname = "";
        String versionName = "";
        int versionCode = 0;
        long firstInstallTime = 0;
        Drawable icon;
    }
}


