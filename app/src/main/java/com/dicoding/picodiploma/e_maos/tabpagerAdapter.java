package com.dicoding.picodiploma.e_maos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class tabpagerAdapter extends FragmentStatePagerAdapter {

    String[] tabarray= new String[]{"Buku Offline","E-Book"};
    Integer tabnumber=2;
    public tabpagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabarray[position];
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                OfflineBook offlineBook = new OfflineBook();
                return offlineBook;
            case 1:
                Ebook ebook =new Ebook();
                return ebook;
        }

        return null;
    }

    @Override
    public int getCount() {
        return tabnumber;
    }
}
