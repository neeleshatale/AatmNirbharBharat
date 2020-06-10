package com.neeleshatale.atmanirbharbharat.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.neeleshatale.atmanirbharbharat.R;
import com.neeleshatale.atmanirbharbharat.activities.MainActivity;
import com.neeleshatale.atmanirbharbharat.databinding.FragmentFeedBinding;
import com.neeleshatale.atmanirbharbharat.utilities.CommonFunctions;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends Fragment {

    private FragmentFeedBinding binding;
    private MainActivity mainActivity;
    private int showLoaderCnt = 0;

    public FeedFragment() {
        // Required empty public constructor
    }

    public static FeedFragment newInstance() {

        Bundle args = new Bundle();

        FeedFragment fragment = new FeedFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainActivity = (MainActivity) getActivity();
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_feed, container, false);
        mainActivity.setTitle(R.string.feed);
        startWebView(binding.webview);
        return binding.getRoot();
    }

    private void startWebView(WebView webView) {

        //Create new webview Client to show progress dialog
        //When opening a url or click on link

        webView.setWebViewClient(new WebViewClient() {

            //If you will not use this method url links are opeen in new brower not in webview
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            //Show loader on url load
            public void onLoadResource(WebView view, String url) {
                if (showLoaderCnt < 1) {
                    CommonFunctions.getInstance().loadProgressDialog(mainActivity);
                    showLoaderCnt++;
                }
            }

            public void onPageFinished(WebView view, String url) {
                CommonFunctions.getInstance().dismissProgressDialog();
            }

        });

        // Javascript inabled on webview
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.worldometers.info/coronavirus/");
    }

    // Open previous opened link from history on webview when back button pressed


}

