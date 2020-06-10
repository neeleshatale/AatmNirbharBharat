package com.neeleshatale.atmanirbharbharat.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.neeleshatale.atmanirbharbharat.R;
import com.neeleshatale.atmanirbharbharat.activities.MainActivity;
import com.neeleshatale.atmanirbharbharat.adapter.ChieneseAppListAdapter;
import com.neeleshatale.atmanirbharbharat.databinding.FragmentChieneseAppBinding;
import com.neeleshatale.atmanirbharbharat.interfaces.ClickCallback;
import com.neeleshatale.atmanirbharbharat.models.AppNameDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChieneseAppFragment extends Fragment implements View.OnClickListener, ClickCallback {

    public static String fragmentName = "ChieneseAppFragment";
    private MainActivity mainActivity;
    private ChieneseAppListAdapter adapter;
    private FragmentChieneseAppBinding binding;
    private List<AppNameDTO> appNameDTOS = new ArrayList<>();

    public ChieneseAppFragment() {
        // Required empty public constructor
    }

    public static ChieneseAppFragment newInstance() {
        Bundle args = new Bundle();
        ChieneseAppFragment fragment = new ChieneseAppFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainActivity = (MainActivity) getActivity();
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chienese_app, container, false);
        initAdapter();

        // Default show chiense apps
        mainActivity.setTitle(R.string.chienese_apps);
        scanChieneseApps();

        binding.btnScanApps.setOnClickListener(this);
        binding.btnAlternativeApps.setOnClickListener(this);
        return binding.getRoot();
    }

    private void initAdapter() {
        if (adapter == null) {
            adapter = new ChieneseAppListAdapter(mainActivity, appNameDTOS);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(mainActivity, LinearLayoutManager.VERTICAL, false);
        binding.rvApplist.setLayoutManager(layoutManager);
        binding.rvApplist.setAdapter(adapter);

        adapter.setClickCallback(this);
    }

    private void refreshAdapter() {
        adapter.refreshAdapter(appNameDTOS);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_scan_apps:
                mainActivity.setTitle(R.string.chienese_apps);
                scanChieneseApps();
                break;
            case R.id.btn_alternative_apps:
                mainActivity.setTitle(R.string.alternative_apps);
                listOutAlternativeApps();
                break;
        }
    }

    private void scanChieneseApps() {
        appNameDTOS.clear();
        appNameDTOS = mainActivity.getChienesAppInstalledOnDevice();
        refreshAdapter();
    }

    private void listOutAlternativeApps() {
        appNameDTOS.clear();
        appNameDTOS = mainActivity.getAlternativeApps();
        refreshAdapter();
    }

    private void unInstallApp(AppNameDTO app) {
        Intent intent = new Intent(Intent.ACTION_DELETE, Uri.parse("package:" + app.getPackageName()));
        mainActivity.startActivityForResult(intent, 1000);
    }

    @Override
    public void onClickCallback(AppNameDTO app) {
        if (app.getAlternativeApp())
            installApp(app);
        else
            unInstallApp(app);
    }

    private void installApp(AppNameDTO app) {
        Intent intent = mainActivity.getPackageManager().getLaunchIntentForPackage(app.getPackageName());
        if(intent == null) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(app.getPlayStoreURL()));
        }
        mainActivity.startActivityForResult(intent, 1001);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            scanChieneseApps();
        } else if (requestCode == 1001) {
            listOutAlternativeApps();
        }
    }
}
