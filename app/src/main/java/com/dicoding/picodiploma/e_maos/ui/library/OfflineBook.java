package com.dicoding.picodiploma.e_maos.ui.library;


import com.google.firebase.firestore.Exclude;

public class OfflineBook {
    private String documentId;
    private String judul;
    private String penulis;
    private String rating;
    private String perpustakaan;


    public OfflineBook(){
//        public
    }
    @Exclude
    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public OfflineBook(String judul, String penulis, String rating, String perpustakaan){
        this.judul = judul;
        this.penulis = penulis;
        this.rating = rating;
        this.perpustakaan = perpustakaan;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public String getRating() {
        return rating;
    }

    public String getPerpustakaan() {
        return perpustakaan;
    }
}
