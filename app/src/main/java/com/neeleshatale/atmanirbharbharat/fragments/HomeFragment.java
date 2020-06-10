package com.neeleshatale.atmanirbharbharat.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.neeleshatale.atmanirbharbharat.R;
import com.neeleshatale.atmanirbharbharat.activities.MainActivity;
import com.neeleshatale.atmanirbharbharat.databinding.FragmentHomeBinding;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnTouchListener {

    private FragmentHomeBinding binding;
    private MainActivity mainActivity;
    private int animationDuration = 5000;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        mainActivity = (MainActivity) getActivity();

        assert mainActivity != null;
        mainActivity.setTitle(R.string.home);

        binding.circleView.setOnTouchListener(this);
        setValuesToProgressBar();
        return binding.getRoot();
    }

    private void setValuesToProgressBar() {
        binding.tvProgressStatus.setText(R.string.scanning);
        final int chieneseAppCnt = mainActivity.getChienesAppInstalledOnDevice().size();
        int maxChieneseAppCount = chieneseAppCnt;
        if (chieneseAppCnt >= 10) {
            maxChieneseAppCount = 10;
        }
        int value = (100 - maxChieneseAppCount * 10);
        binding.circleView.setValueAnimated(value, animationDuration);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String msg = "";
                if (chieneseAppCnt > 0) {
                    binding.tvProgressStatus.setVisibility(View.VISIBLE);
                    binding.llCongratulation.setVisibility(View.GONE);
                    if (chieneseAppCnt == 1)
                        msg = "You have " + chieneseAppCnt + " Chinese app installed on your Mobile... \n let's Uninstall it.";
                    else
                        msg = "You have " + chieneseAppCnt + " Chinese apps installed on your Mobile... \n let's Uninstall them.";
                    binding.tvProgressStatus.setText(msg);
                } else {
                    binding.tvProgressStatus.setVisibility(View.GONE);
                    binding.llCongratulation.setVisibility(View.VISIBLE);
                }
            }
        }, animationDuration);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }
}
