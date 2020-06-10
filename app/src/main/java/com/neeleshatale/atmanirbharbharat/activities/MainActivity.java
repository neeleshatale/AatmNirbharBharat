package com.neeleshatale.atmanirbharbharat.activities;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.neeleshatale.atmanirbharbharat.R;
import com.neeleshatale.atmanirbharbharat.databinding.ActivityMainBinding;
import com.neeleshatale.atmanirbharbharat.fragments.ChieneseAppFragment;
import com.neeleshatale.atmanirbharbharat.fragments.FeedFragment;
import com.neeleshatale.atmanirbharbharat.fragments.HomeFragment;
import com.neeleshatale.atmanirbharbharat.models.AppNameDTO;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.action_home:
                        openHomeAppScreen();
                        break;
                    case R.id.action_apps:
                        openAppsScreen();
                        break;
                    default:
                        openFeedAppScreen();
                        break;
                }
                return true;
            }
        });
        binding.bottomNavigationView.setSelectedItemId(R.id.action_home);
    }

    private List<String> getChieneseApps() {
        List<String> chieneseApps = new ArrayList<>();
        chieneseApps.add("com.zhiliaoapp.musically"); //TikTok
        chieneseApps.add("app.buzz.share"); //Helo
        chieneseApps.add("com.lenovo.anyshare.gps"); //Shareit
        chieneseApps.add("com.abcode.like"); //Like
        chieneseApps.add("com.kwai.video"); //Kwai
        chieneseApps.add("com.UCMobile.intl"); //UC Browser
        chieneseApps.add("com.uc.browser.en"); //UC Browser mini
        chieneseApps.add("sg.bigo.live"); //Bigo Live
        chieneseApps.add("com.ss.android.ugc.boom"); //Vigo Live
        chieneseApps.add("cn.xender"); //Xender
        chieneseApps.add("com.intsig.camscanner"); //Cam Scanner
        chieneseApps.add("com.tencent.ig"); //PUBG
        chieneseApps.add("com.hcg.cok.gp"); //Clash Of Kings
        chieneseApps.add("com.mobile.legends"); //Mobile Legends
        chieneseApps.add("com.zhiliaoapp.musically.go"); //tiktok lite
        chieneseApps.add("club.fromfactory"); //club.fromfactory
        chieneseApps.add("com.domobile.applockwatcher"); //AppLock
        chieneseApps.add("com.ss.android.ugc.boomlite"); //Vigo lite
        chieneseApps.add("com.ss.android.ugc.boom"); //Vigo video
        chieneseApps.add("com.chuck.videodownloader"); //All video downloader
        chieneseApps.add("com.uc.vmlite"); //Vmate status
        chieneseApps.add("com.youdao.hindict"); //Udictionary
        chieneseApps.add("com.videochat.livu"); //LivU
        chieneseApps.add("com.gotomate.livechat"); //LiveChat
        chieneseApps.add("com.asiainno.uplive"); //Uplive

        chieneseApps.add("us.zoom.videomeetings"); //Zoom
        chieneseApps.add("com.lbe.parallel.intl"); //Parallel Space
        chieneseApps.add("com.tencent.mm"); //We chat
        chieneseApps.add("com.uc.vmate"); //Vmate
        chieneseApps.add("com.flashkeyboardtheme"); //Flash Keyboard
        chieneseApps.add("com.zzkko"); //Shien
        chieneseApps.add("free.vpn.unblock.proxy.turbovpn"); //Turbo VPN
        chieneseApps.add("com.kakao.cheez"); //TKakao talk Cheez
        chieneseApps.add("com.eg.android.AlipayGphone"); //Alipay
        chieneseApps.add("com.weico.international"); //Weibo
        chieneseApps.add("com.newsdog"); //NewsDog
        chieneseApps.add("com.intsig.camscanner"); //CamScanner
        chieneseApps.add("com.yottagames.mafiawar"); //Mafia city
        chieneseApps.add("com.dc.hwsj"); //Game of sultans
        chieneseApps.add("com.funplus.kingofavalon"); //King of avalon
        chieneseApps.add("com.nono.android"); //Nano live
        return chieneseApps;
    }

    public List<AppNameDTO> getAlternativeApps() {
        List<AppNameDTO> alternativeApps = new ArrayList<>();


        AppNameDTO appRoposo = new AppNameDTO();
        appRoposo.setName("Roposo");
        appRoposo.setAlternativeApp(true);
        appRoposo.setPlayStoreURL("https://play.google.com/store/apps/details?id=com.roposo.android&hl=en");
        appRoposo.setPackageName("com.roposo.android");
        appRoposo.setAppIcon(getDrawable(R.drawable.roposo));

        AppNameDTO appShareChat = new AppNameDTO();
        appShareChat.setName("ShareChat");
        appShareChat.setAlternativeApp(true);
        appShareChat.setPlayStoreURL("https://play.google.com/store/apps/details?id=in.mohalla.sharechat&hl=en");
        appShareChat.setPackageName("in.mohalla.sharechat");
        appShareChat.setAppIcon(getDrawable(R.drawable.sharechat));

        AppNameDTO epicBrowser = new AppNameDTO();
        epicBrowser.setName("Epic Privacy Browser");
        epicBrowser.setAlternativeApp(true);
        epicBrowser.setPlayStoreURL("https://play.google.com/store/apps/details?id=com.epic.browser&hl=en");
        epicBrowser.setPackageName("com.epic.browser");
        epicBrowser.setAppIcon(getDrawable(R.drawable.epic_privacy_browser));

        AppNameDTO yoBrowser = new AppNameDTO();
        yoBrowser.setName("Yo Browser");
        yoBrowser.setAlternativeApp(true);
        yoBrowser.setPlayStoreURL("https://play.google.com/store/apps/details?id=com.browser.yo.indian&hl=en");
        yoBrowser.setPackageName("com.browser.yo.indian");
        yoBrowser.setAppIcon(getDrawable(R.drawable.yo_browser));

        AppNameDTO jioSwitch = new AppNameDTO();
        jioSwitch.setName("JioSwitch");
        jioSwitch.setAlternativeApp(true);
        jioSwitch.setPlayStoreURL("https://play.google.com/store/apps/details?id=com.reliance.jio.jioswitch&hl=en");
        jioSwitch.setPackageName("com.reliance.jio.jioswitch");
        jioSwitch.setAppIcon(getDrawable(R.drawable.jiobrowser));

        AppNameDTO indainAirForce = new AppNameDTO();
        indainAirForce.setName("Indian Air Force");
        indainAirForce.setAlternativeApp(true);
        indainAirForce.setPlayStoreURL("https://play.google.com/store/apps/details?id=com.threye.iaf.aca&hl=en");
        indainAirForce.setPackageName("com.threye.iaf.aca");
        indainAirForce.setAppIcon(getDrawable(R.drawable.indian_air_force));

        AppNameDTO ajio = new AppNameDTO();
        ajio.setName("AJIO");
        ajio.setAlternativeApp(true);
        ajio.setPlayStoreURL("https://play.google.com/store/apps/details?id=com.ril.ajio&hl=en");
        ajio.setPackageName("com.ril.ajio");
        ajio.setAppIcon(getDrawable(R.drawable.ajio));

        AppNameDTO bewkoof = new AppNameDTO();
        bewkoof.setName("Bewakoof");
        bewkoof.setAlternativeApp(true);
        bewkoof.setPlayStoreURL("https://play.google.com/store/apps/details?id=com.bewakoof.bewakoof&hl=en");
        bewkoof.setPackageName("com.bewakoof.bewakoof");
        bewkoof.setAppIcon(getDrawable(R.drawable.bewkoof));

        AppNameDTO myntra = new AppNameDTO();
        myntra.setName("Myntra");
        myntra.setAlternativeApp(true);
        myntra.setPlayStoreURL("https://play.google.com/store/apps/details?id=com.myntra.android&hl=en");
        myntra.setPackageName("com.myntra.android");
        myntra.setAppIcon(getDrawable(R.drawable.myntra));

        AppNameDTO flipkart = new AppNameDTO();
        flipkart.setName("Flipkart");
        flipkart.setAlternativeApp(true);
        flipkart.setPlayStoreURL("https://play.google.com/store/apps/details?id=com.flipkart.android&hl=en");
        flipkart.setPackageName("com.flipkart.android");
        flipkart.setAppIcon(getDrawable(R.drawable.flipkart));

        AppNameDTO limeRoad = new AppNameDTO();
        limeRoad.setName("LimeRoad");
        limeRoad.setAlternativeApp(true);
        limeRoad.setPlayStoreURL("https://play.google.com/store/apps/details?id=com.shopping.limeroad&hl=en");
        limeRoad.setPackageName("com.shopping.limeroad");
        limeRoad.setAppIcon(getDrawable(R.drawable.limeroad));

        AppNameDTO jioBrowser = new AppNameDTO();
        jioBrowser.setName("JioBrowser");
        jioBrowser.setAlternativeApp(true);
        jioBrowser.setPlayStoreURL("https://play.google.com/store/apps/details?id=com.jio.web&hl=en");
        jioBrowser.setPackageName("com.jio.web");
        jioBrowser.setAppIcon(getDrawable(R.drawable.jiobrowser));

        AppNameDTO adobeScan = new AppNameDTO();
        adobeScan.setName("Adobe Scan");
        adobeScan.setAlternativeApp(true);
        adobeScan.setPlayStoreURL("https://play.google.com/store/apps/details?id=com.adobe.scan.android&hl=en");
        adobeScan.setPackageName("com.adobe.scan.android");
        adobeScan.setAppIcon(getDrawable(R.drawable.adobe_scan));

        AppNameDTO indainSelfiCamera = new AppNameDTO();
        indainSelfiCamera.setName("Indian Selfie Camera");
        indainSelfiCamera.setAlternativeApp(true);
        indainSelfiCamera.setPlayStoreURL("https://play.google.com/store/apps/details?id=com.appbreakers.selfiecamera&hl=en");
        indainSelfiCamera.setPackageName("com.appbreakers.selfiecamera");
        indainSelfiCamera.setAppIcon(getDrawable(R.drawable.indain_selfie_camera));

        AppNameDTO paytm = new AppNameDTO();
        paytm.setName("Paytm");
        paytm.setAlternativeApp(true);
        paytm.setPlayStoreURL("https://play.google.com/store/apps/details?id=net.one97.paytm&hl=en");
        paytm.setPackageName("net.one97.paytm");
        paytm.setAppIcon(getDrawable(R.drawable.paytm));

        AppNameDTO skype = new AppNameDTO();
        skype.setName("Skype");
        skype.setAlternativeApp(true);
        skype.setPlayStoreURL("https://play.google.com/store/apps/details?id=com.skype.raider&hl=en");
        skype.setPackageName("com.skype.raider");
        skype.setAppIcon(getDrawable(R.drawable.skype));

        alternativeApps.add(appRoposo);
        alternativeApps.add(appShareChat);
        alternativeApps.add(epicBrowser);
        alternativeApps.add(yoBrowser);
        alternativeApps.add(jioSwitch);
        alternativeApps.add(indainAirForce);
        alternativeApps.add(ajio);
        alternativeApps.add(bewkoof);
        alternativeApps.add(myntra);
        alternativeApps.add(flipkart);
        alternativeApps.add(limeRoad);
        alternativeApps.add(jioBrowser);
        alternativeApps.add(adobeScan);
        alternativeApps.add(indainSelfiCamera);
        alternativeApps.add(paytm);
        alternativeApps.add(skype);

        return alternativeApps;

    }

    public List<AppNameDTO> getChienesAppInstalledOnDevice() {
        List<AppNameDTO> apps = new ArrayList<>();

        PackageManager packageManager = getPackageManager();
        List<PackageInfo> packageList = packageManager
                .getInstalledPackages(PackageManager.GET_PERMISSIONS);


        /*To filter out System apps*/
        for (PackageInfo packageInfo : packageList) {
            boolean b = isSystemPackage(packageInfo);
            if (!b) {
                AppNameDTO appNameDTO = new AppNameDTO();

                Drawable appIcon = packageManager
                        .getApplicationIcon(packageInfo.applicationInfo);
                String appName = packageManager.getApplicationLabel(
                        packageInfo.applicationInfo).toString();
                String versionName = "1.0";
                versionName = packageInfo.versionName;

//                appIcon.setBounds(0, 0, 40, 40);
                appNameDTO.setName(appName);
                appNameDTO.setAppIcon(appIcon);
                appNameDTO.setVersionName(versionName);
                appNameDTO.setPackageName(packageInfo.packageName);
                for (String str : getChieneseApps()) {
                    if (str.equals(appNameDTO.getPackageName())) {
                        apps.add(appNameDTO);
                    }
                }
            }
        }
        return apps;
    }

    /**
     * Return whether the given PackgeInfo represents a system package or not.
     * User-installed packages (Market or otherwise) should not be denoted as
     * system packages.
     *
     * @param pkgInfo
     * @return boolean
     */
    private boolean isSystemPackage(PackageInfo pkgInfo) {
        return (pkgInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0;
    }

    public void openHomeAppScreen() {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.main_activity_container);
        if (currentFragment instanceof HomeFragment) {
            return;
        }
        getSupportFragmentManager().executePendingTransactions();
        getSupportFragmentManager().beginTransaction()
//                .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                .replace(R.id.main_activity_container, HomeFragment.newInstance())
//                .addToBackStack(ChieneseAppFragment.fragmentName)
                .commitAllowingStateLoss();
    }

    public void openAppsScreen() {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.main_activity_container);
        if (currentFragment instanceof ChieneseAppFragment) {
            return;
        }
        getSupportFragmentManager().executePendingTransactions();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_activity_container, ChieneseAppFragment.newInstance())
                .commitAllowingStateLoss();
    }

    public void openFeedAppScreen() {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.main_activity_container);
        if (currentFragment instanceof FeedFragment) {
            return;
        }
        getSupportFragmentManager().executePendingTransactions();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_activity_container, FeedFragment.newInstance())
                .commitAllowingStateLoss();
    }

    public void setTitle(int title) {
        binding.tvTitle.setText(title);
    }

    public void openScreen(Fragment fragment) {
        getSupportFragmentManager().executePendingTransactions();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_activity_container, fragment)
                .commitAllowingStateLoss();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.main_activity_container);
        if (currentFragment instanceof ChieneseAppFragment) {
            ((ChieneseAppFragment) currentFragment).onActivityResult(requestCode, resultCode, data);
        }
    }
}