package com.onebittech;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.json.JSONException;
import org.json.JSONArray;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class PackageInfoPlugin extends CordovaPlugin {
    private CordovaInterface cordova;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        this.cordova = cordova;
        super.initialize(cordova, webView);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.apache.cordova.api.Plugin#execute(java.lang.String,
     * org.json.JSONArray, java.lang.String)
     */
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getPackageVersion")) {
            callbackContext.success(this.getPackageVersion());
            return true;
        }
        callbackContext.error("unknown action");
        return false;
    }

    private String getPackageVersion() {
        PackageManager packageManager = cordova.getContext().getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(cordova.getContext().getPackageName(), 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "";
        }
    }
}
