package com.neeleshatale.atmanirbharbharat.adapter;

import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.neeleshatale.atmanirbharbharat.R;
import com.neeleshatale.atmanirbharbharat.activities.MainActivity;
import com.neeleshatale.atmanirbharbharat.databinding.AppNameListItemBinding;
import com.neeleshatale.atmanirbharbharat.interfaces.ClickCallback;
import com.neeleshatale.atmanirbharbharat.models.AppNameDTO;

import java.util.ArrayList;
import java.util.List;

public class ChieneseAppListAdapter extends RecyclerView.Adapter<ChieneseAppListAdapter.CustomViewHolder> {

    private List<AppNameDTO> appNames = new ArrayList<>();
    private MainActivity mainActivity;
    private ClickCallback clickCallback;

    public ChieneseAppListAdapter(MainActivity mainActivity, List<AppNameDTO> appNames) {
        this.mainActivity = mainActivity;
        this.appNames = appNames;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AppNameListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.app_name_list_item, parent, false);
        return new CustomViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        if (holder instanceof CustomViewHolder) {
            final AppNameDTO appNameDTO = appNames.get(position);
            final AppNameListItemBinding binding = ((CustomViewHolder) holder).getBinding();
            if (appNameDTO.getAlternativeApp()) {
                binding.btnInstall.setVisibility(View.VISIBLE);
                binding.btnUninstall.setVisibility(View.GONE);
            } else {
                binding.btnUninstall.setVisibility(View.VISIBLE);
                binding.btnInstall.setVisibility(View.GONE);
            }
            binding.ivAppIcon.setImageDrawable(appNameDTO.getAppIcon());
            binding.tvAppName.setText(appNameDTO.getName());
            if (appNameDTO.getAlternativeApp()) {
                if (appInstalledOrNot(appNameDTO.getPackageName())) {
                    binding.tvAppVersionName.setText(R.string.installed);
                    binding.btnInstall.setText(R.string.open);
                } else {
                    binding.tvAppVersionName.setText(R.string.not_installed);
                    binding.btnInstall.setText(R.string.install);
                }
            } else
                binding.tvAppVersionName.setText("Version: " + appNameDTO.getVersionName());

            binding.btnUninstall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (clickCallback != null) {
                        clickCallback.onClickCallback(appNameDTO);
                    }
                }
            });
            binding.btnInstall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (clickCallback != null) {
                        clickCallback.onClickCallback(appNameDTO);
                    }
                }
            });
        }
    }

    private boolean appInstalledOrNot(String uri) {
        PackageManager pm = mainActivity.getPackageManager();
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public int getItemCount() {
        return appNames.size();
    }

    public void setClickCallback(ClickCallback clickCallback) {
        this.clickCallback = clickCallback;
    }

    public void refreshAdapter(List<AppNameDTO> appNameDTOS) {
        appNames.clear();
        appNames = appNameDTOS;
        notifyDataSetChanged();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        private final AppNameListItemBinding binding;

        CustomViewHolder(AppNameListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        AppNameListItemBinding getBinding() {
            return binding;
        }
    }
}
