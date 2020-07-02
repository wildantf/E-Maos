package com.dicoding.picodiploma.e_maos.ui.account_profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.dicoding.picodiploma.e_maos.DatabaseHelper;
import com.dicoding.picodiploma.e_maos.LoginActivity;
import com.dicoding.picodiploma.e_maos.R;
import com.dicoding.picodiploma.e_maos.ChangePassword;

public class AccountProfileFragment extends Fragment {

    DatabaseHelper db;
    TextView logout,btnchangePass;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_account_profile, container, false);

        final Intent changePass = new Intent(getActivity(), ChangePassword.class);

        logout = root.findViewById(R.id.textView_logout);
        btnchangePass = root.findViewById(R.id.textView_changePassword);

        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Boolean updtSession = db.upgradeSession("kosong",1);
                if(updtSession==true){
                    Toast.makeText(getActivity().getApplicationContext(), "berhasil keluar", Toast.LENGTH_SHORT).show();
                    Intent loginIntent= new Intent(getActivity(), LoginActivity.class);
                    startActivity(loginIntent);
                }
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
