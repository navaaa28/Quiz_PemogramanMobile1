package com.example.quiz;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class RegistrasiActivity extends AppCompatActivity {
    private EditText nikInput, namaInput, tempatLahirInput, tanggalLahirInput, alamatInput, emailInput, teleponInput;
    private RadioButton jenisKelaminLaki, jenisKelaminPerempuan;
    private Button submitButton;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nikInput = findViewById(R.id.nikInput);
        namaInput = findViewById(R.id.namaInput);
        tempatLahirInput = findViewById(R.id.tempatLahirInput);
        tanggalLahirInput = findViewById(R.id.tanggalLahirInput);
        alamatInput = findViewById(R.id.alamatInput);
        emailInput = findViewById(R.id.emailInput);
        teleponInput = findViewById(R.id.teleponInput);
        jenisKelaminLaki = findViewById(R.id.jenisKelaminLaki);
        jenisKelaminPerempuan = findViewById(R.id.jenisKelaminPerempuan);
        submitButton = findViewById(R.id.submitButton);

        // Listener untuk tombol submit
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ambil nilai dari semua input
                String nik = nikInput.getText().toString().trim();
                String nama = namaInput.getText().toString().trim();
                String tempatLahir = tempatLahirInput.getText().toString().trim();
                String tanggalLahir = tanggalLahirInput.getText().toString().trim();
                String alamat = alamatInput.getText().toString().trim();
                String email = emailInput.getText().toString().trim();
                String telepon = teleponInput.getText().toString().trim();
                String jenisKelamin = jenisKelaminLaki.isChecked() ? "Laki-laki" : "Perempuan";

                // Validasi input
                if (TextUtils.isEmpty(nik) || TextUtils.isEmpty(nama) || TextUtils.isEmpty(tempatLahir) ||
                        TextUtils.isEmpty(tanggalLahir) || TextUtils.isEmpty(alamat) || TextUtils.isEmpty(email) ||
                        TextUtils.isEmpty(telepon) || TextUtils.isEmpty(jenisKelamin)) {
                    // Jika ada input yang kosong, tampilkan pesan kesalahan
                    Toast.makeText(RegistrasiActivity.this, "Harap isi semua!.", Toast.LENGTH_SHORT).show();
                } else {
                    // Jika semua input sudah diisi, proses data
                    // Buat intent untuk berpindah ke DetailActivity
                    Intent intent = new Intent(RegistrasiActivity.this, DetailActivity.class);
                    intent.putExtra("NIK", nik);
                    intent.putExtra("NAMA", nama);
                    intent.putExtra("JENIS_KELAMIN", jenisKelamin);
                    intent.putExtra("TEMPAT_LAHIR", tempatLahir);
                    intent.putExtra("TANGGAL_LAHIR", tanggalLahir);
                    intent.putExtra("ALAMAT", alamat);
                    intent.putExtra("EMAIL", email);
                    intent.putExtra("TELEPON", telepon);
                    startActivity(intent);
                }
            }
        });



        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String date = dayOfMonth + "/" + (month + 1) + "/" + year;
                        tanggalLahirInput.setText(date);
                    }
                },
                year, month, dayOfMonth
        );
    }

    public void showDatePickerDialog(View view) {
        datePickerDialog.show();
    }
}
