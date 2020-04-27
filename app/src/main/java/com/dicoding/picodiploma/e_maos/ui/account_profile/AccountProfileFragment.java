package com.dicoding.picodiploma.e_maos.ui.account_profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.dicoding.picodiploma.e_maos.R;
import com.dicoding.picodiploma.e_maos.changePassword;
import com.dicoding.picodiploma.e_maos.siginOrRegister;

public class AccountProfileFragment extends Fragment {
    private AccountProfileViewModel accountProfileViewModel;

    Intent logout;
    Intent changePass;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        accountProfileViewModel =
                ViewModelProviders.of(this).get(AccountProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_account_profile, container, false);

        logout = new Intent(getActivity(), siginOrRegister.class);
        changePass = new Intent(getActivity(), changePassword.class);

        final Button btnLogout = root.findViewById(R.id.button5);
        final Button btnchangePass = root.findViewById(R.id.button3);

        btnLogout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(logout);
            }
        });

        btnchangePass.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(changePass);
            }
        });
//        final TextView textView = root.findViewById(R.id.text_slideshow);
//        accountProfileViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}
