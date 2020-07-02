package com.dicoding.picodiploma.e_maos.ui.library;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.dicoding.picodiploma.e_maos.MainActivity;
import com.dicoding.picodiploma.e_maos.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Objects;

public class LibraryFragment extends Fragment {
    private static final String TAG = "MainActivity";
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

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        tabLayout = (TabLayout) root.findViewById(R.id.tabs);
        viewPager = (ViewPager) root.findViewById(R.id.viewpager);

        viewPager.setAdapter(new tabpagerAdapter(getChildFragmentManager()));

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });


        db.collection("Book")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
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
