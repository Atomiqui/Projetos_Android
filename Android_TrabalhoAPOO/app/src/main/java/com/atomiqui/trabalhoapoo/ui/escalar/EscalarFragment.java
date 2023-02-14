package com.atomiqui.trabalhoapoo.ui.escalar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.atomiqui.trabalhoapoo.databinding.FragmentEscalarBinding;

public class EscalarFragment extends Fragment {

    private FragmentEscalarBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        EscalarViewModel escalarViewModel =
                new ViewModelProvider(this).get(EscalarViewModel.class);

        binding = FragmentEscalarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textGallery;
        //escalarViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}