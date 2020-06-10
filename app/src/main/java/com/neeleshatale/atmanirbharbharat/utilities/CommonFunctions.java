package com.neeleshatale.atmanirbharbharat.utilities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.neeleshatale.atmanirbharbharat.R;

import fr.castorflex.android.circularprogressbar.CircularProgressDrawable;

public class CommonFunctions {

    private static CommonFunctions instance = null;
    private ProgressDialog mProgressBar;

    private CommonFunctions() {
    }

    public static CommonFunctions getInstance() {
        if (instance == null) {
            instance = new CommonFunctions();
        }
        return instance;
    }

    /*
     * method used to check network.
     */
    public boolean isOffline(Context context) {
        try {
            if (context != null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = null;
                if (connectivityManager != null) {
                    networkInfo = connectivityManager.getActiveNetworkInfo();
                }
                return (networkInfo == null || !networkInfo.isConnected());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /*
     * method used to hide SoftKeyBoard.
     */
    public void hideSoftKeyBoard(Activity activity) {
        try {
            if (activity == null) {
                return;
            }
            hideSoftKeyBoard(activity, activity.getCurrentFocus());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * method used to hide SoftKeyBoard.
     */
    public void hideSoftKeyBoard(Activity activity, View view) {
        try {
            if (activity == null) {
                return;
            }
            activity.getWindow().setSoftInputMode(
                    WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
            );
            if (view != null) {
                InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * method used to show loader.
     */
    public void loadProgressDialog(Context context) {
        try {
            if (mProgressBar != null && mProgressBar.isShowing()) {
                dismissProgressDialog();
            }
            mProgressBar = new ProgressDialog(context, R.style.CustomProgressBarStyle);
            mProgressBar.setIndeterminateDrawable(new CircularProgressDrawable
                    .Builder(context)
                    .colors(context.getResources().getIntArray(R.array.progress_bar_color))
                    .sweepSpeed(1f)
                    .style(CircularProgressDrawable.STYLE_ROUNDED)
                    .build());
            mProgressBar.show();
            mProgressBar.setCancelable(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * method used to dismiss loader.
     */
    public void dismissProgressDialog() {
        try {
            if (mProgressBar != null) {
                mProgressBar.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
