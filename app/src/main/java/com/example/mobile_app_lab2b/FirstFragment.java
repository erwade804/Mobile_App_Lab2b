package com.example.mobile_app_lab2b;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.mobile_app_lab2b.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = binding.Far.getText().toString();
                boolean convertToFer;
                boolean convertToCel;
                double fer;
                Log.i("log", temp);
                try {
                    fer = Double.parseDouble(temp);
                    fer -= 32;
                    fer *= (5.0 / 9.0);
                    binding.cel.setText("" + fer);
                }catch(Exception e){
                    temp = binding.cel.getText().toString();
                    double cel;
                    cel = Double.parseDouble(temp);
                    cel /= (5.0 / 9.0);
                    cel += 32;
                    binding.Far.setText("" + cel);
                }

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}