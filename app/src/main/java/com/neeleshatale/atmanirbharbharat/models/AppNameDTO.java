package com.neeleshatale.atmanirbharbharat.models;

import android.graphics.drawable.Drawable;

public class AppNameDTO {
    private String name;
    private String packageName;
    private Drawable appIcon;
    private String versionName;
    private Boolean isAlternativeApp = false;
    private String playStoreURL = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Drawable getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(Drawable appIcon) {
        this.appIcon = appIcon;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public Boolean getAlternativeApp() {
        return isAlternativeApp;
    }

    public void setAlternativeApp(Boolean alternativeApp) {
        isAlternativeApp = alternativeApp;
    }

    public String getPlayStoreURL() {
        return playStoreURL;
    }

    public void setPlayStoreURL(String playStoreURL) {
        this.playStoreURL = playStoreURL;
    }
}
