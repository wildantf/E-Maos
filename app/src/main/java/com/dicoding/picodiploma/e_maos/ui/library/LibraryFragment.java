package com.dicoding.picodiploma.e_maos.ui.library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.dicoding.picodiploma.e_maos.R;
import com.google.android.material.tabs.TabLayout;

public class LibraryFragment extends Fragment {
    String[] tabarray= new String[]{"Buku Offline","E-Book"};
    Integer tabnumber=2;
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 2;

    private LibraryViewModel libraryViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        libraryViewModel =
                ViewModelProviders.of(this).get(LibraryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_library, container, false);

        tabLayout = (TabLayout) root.findViewById(R.id.tabs);
        viewPager = (ViewPager) root.findViewById(R.id.viewpager);

        viewPager.setAdapter(new tabpagerAdapter(getChildFragmentManager()));

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        return root;
    }
    class tabpagerAdapter extends FragmentStatePagerAdapter {
        public tabpagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabarray[position];
        }

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
}
