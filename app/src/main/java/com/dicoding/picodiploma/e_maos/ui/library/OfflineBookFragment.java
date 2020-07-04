package com.dicoding.picodiploma.e_maos.ui.library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dicoding.picodiploma.e_maos.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class OfflineBookFragment extends Fragment implements View.OnClickListener {

    private View root;
    private TextView textView_judul, textView_penulis, textView_perpustakaan, textViewData;
    private RatingBar ratingBar_rating;

    private EditText editTextTitle;
    private EditText editTextDescription;

    private Button btn_coba;


    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public OfflineBookFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_offline_book, container, false);

        textView_judul = root.findViewById(R.id.textView_judulBuku);
        textView_penulis = root.findViewById(R.id.textView_penulisBuku);
        ratingBar_rating = root.findViewById(R.id.ratingBar_ratingBuku);
        textView_perpustakaan = root.findViewById(R.id.textView_perpustakaan);

        btn_coba = root.findViewById(R.id.btn_coba);

        btn_coba.setOnClickListener(this);


        db.collection("Book")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
                            OfflineBook offlineBook = documentSnapshot.toObject(OfflineBook.class);
                            offlineBook.setDocumentId(documentSnapshot.getId());

                            String judul= offlineBook.getJudul();
                            String penulis= offlineBook.getPenulis();
                            String rating= offlineBook.getRating();
                            String perpus= offlineBook.getPerpustakaan();

                            textView_judul.setText(judul);
                            textView_penulis.setText(penulis);
                            ratingBar_rating.setNumStars(Integer.parseInt(rating));
                            textView_perpustakaan.setText(perpus);
                        }
                    }
                });
        return root;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Add your menu entries here
        super.onCreateOptionsMenu(menu, inflater);
        getActivity().getMenuInflater().inflate(R.menu.library_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_coba:
                CollectionReference book = db.collection("BukuOffline");

                Map<String, Object> data1 = new HashMap<>();
                data1.put("judul", "Mahir Bahasa Python");
                data1.put("penulis", "Herman Dzumavo");
                data1.put("rating", 5);
                data1.put("information", "Buku ini berisikan pemaparan materi tentang bahasa Python mulai dari dasar hingga mahir");
                data1.put("perpustakaan", Arrays.asList("Perpustakaan Kota Bangkalan", "Perpustakaan Desa"));
//                cities.document("SF").set(data1);
                data1.put("image", "bahasapython.jpg");
                book.document().set(data1);

                Map<String, Object> data2 = new HashMap<>();
                data2.put("judul", "Data Science For Beginner");
                data2.put("penulis", "Alber Einstein");
                data2.put("rating", 4);
                data2.put("information", "Buku ini berisikan pemaparan materi tentang data scince dalam program");
                data2.put("perpustakaan", Arrays.asList("Perpustakaan Tambak Sari", "Perustakaan Gedungan"));
                data2.put("image", "datascience.jpg");
                book.document().set(data2);

                Map<String, Object> data3 = new HashMap<>();
                data3.put("judul", "Mahir Menggunakan Microsoft Word");
                data3.put("penulis", "Hendra Gunawan");
                data3.put("rating", 5);
                data3.put("information", "Buku ini berisikan pemaparan materi tentang pengenalan microsoft word");
                data3.put("perpustakaan", Arrays.asList("Perpustakaan Balai Kota"));
                data3.put("image", "mword.jpg");
                book.document().set(data3);

                Map<String, Object> data4 = new HashMap<>();
                data4.put("judul", "Belajar Membuat Aplikasi Android");
                data4.put("penulis", "Agung Hapsah");
                data4.put("rating", 3);
                data4.put("information", "Buku ini berisikan pemaparan materi tentang dasar dasar pembuatan aplikasi android");
                data4.put("perpustakaan", Arrays.asList("Perpustakaan Desa"));
                data4.put("image", "androiddev.jpg");
                book.document().set(data4);

                Map<String, Object> data5 = new HashMap<>();
                data5.put("judul", "Mahir Microsoft Excel");
                data5.put("penulis", "Agung Gumelear");
                data5.put("rating", 3);
                data5.put("information", "Buku ini berisikan pemaparan materi tentang dasar dasar menggunakan microsoft excel");
                data5.put("perpustakaan", Arrays.asList("Perpustakaan Banda", "Perpustakaan Desa Serambi"));
                data5.put("image", "mexcle.jpg");
                book.document().set(data5);

                break;
            default:
                break;
        }
    }
}
