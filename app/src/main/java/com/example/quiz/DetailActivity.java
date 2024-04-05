package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    private TextView nikTextView, namaTextView, jenisKelaminTextView, tempatLahirTextView, tanggalLahirTextView, alamatTextView, emailTextView, teleponTextView, Salam;
    private Button shareButton;
    private void initUI() {
        nikTextView = findViewById(R.id.nikTextView);
        namaTextView = findViewById(R.id.namaTextView);
        jenisKelaminTextView = findViewById(R.id.jenisKelaminTextView);
        tempatLahirTextView = findViewById(R.id.tempatLahirTextView);
        tanggalLahirTextView = findViewById(R.id.tanggalLahirTextView);
        alamatTextView = findViewById(R.id.alamatTextView);
        emailTextView = findViewById(R.id.emailTextView);
        teleponTextView = findViewById(R.id.teleponTextView);
        Salam = findViewById(R.id.Salam);
        shareButton = findViewById(R.id.shareButton);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initUI();

        Intent intent = getIntent();
        if (intent != null) {
            String nik = intent.getStringExtra("NIK");
            String nama = intent.getStringExtra("NAMA");
            String jenisKelamin = intent.getStringExtra("JENIS_KELAMIN");
            String tempatLahir = intent.getStringExtra("TEMPAT_LAHIR");
            String tanggalLahir = intent.getStringExtra("TANGGAL_LAHIR");
            String alamat = intent.getStringExtra("ALAMAT");
            String email = intent.getStringExtra("EMAIL");
            String telepon = intent.getStringExtra("TELEPON");



            nikTextView.setText("NIK: " + nik);
            namaTextView.setText("Nama: " + nama);
            jenisKelaminTextView.setText("Jenis Kelamin: " + jenisKelamin);
            tempatLahirTextView.setText("Tempat Lahir: " + tempatLahir);
            tanggalLahirTextView.setText("Tanggal Lahir: " + tanggalLahir);
            alamatTextView.setText("Alamat: " + alamat);
            emailTextView.setText("Email: " + email);
            teleponTextView.setText("Telepon: " + telepon);
            Salam.setText("Halo Bro" +  nama + ", Diatas adalah data-data yang kamu sudah isi tadi :)");
        }
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareData();
            }

            private void ShareData() {
                String data = Salam.getText().toString() + "\n" +
                        nikTextView.getText().toString() + "\n" +
                        namaTextView.getText().toString() + "\n" +
                        jenisKelaminTextView.getText().toString() + "\n" +
                        tempatLahirTextView.getText().toString() + "\n" +
                        tanggalLahirTextView.getText().toString() + "\n" +
                        alamatTextView.getText().toString() + "\n" +
                        emailTextView.getText().toString() + "\n" +
                        teleponTextView.getText().toString();

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Detail Data Penduduk");
                shareIntent.putExtra(Intent.EXTRA_TEXT, data);

                startActivity(Intent.createChooser(shareIntent, "Bagikan melalui"));
            }
         });
    }
}
