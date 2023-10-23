package com.example.moneytracker.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.moneytracker.R;
import com.example.moneytracker.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        FragmentManager childFragmentManager = getChildFragmentManager();

        // Replace the BalanceFragment
        BalanceFragment topFragment = new BalanceFragment();
        replaceFragment(childFragmentManager, R.id.topFragmentContainer, topFragment);

        // Replace the HistoryFragment
        HistoryFragment bottomFragment = new HistoryFragment();
        replaceFragment(childFragmentManager, R.id.bottomFragmentContainer, bottomFragment);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void replaceFragment(FragmentManager fragmentManager, int containerId, Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(containerId, fragment);
        transaction.commit();
    }
}