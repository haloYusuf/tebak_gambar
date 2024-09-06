package com.example.tebakgambar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.tebakgambar.model.Gambar;
import com.google.android.material.textfield.TextInputEditText;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_GAMBAR = "extra_gambar";
    private Gambar gambar;
    private TextInputEditText et_tebak;
    private ImageView iv_foto;
    private Button btn_cek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (Build.VERSION.SDK_INT >= 33) {
            gambar = getIntent().getParcelableExtra(EXTRA_GAMBAR, Gambar.class);
        } else {
            gambar = getIntent().getParcelableExtra(EXTRA_GAMBAR);
        }

        iv_foto = findViewById(R.id.iv_gambarDetail);
        btn_cek = findViewById(R.id.btn_cek);
        et_tebak = findViewById(R.id.et_inputJawaban);

        Glide.with(this.getApplicationContext()).load(gambar.getImageUrl()).into(iv_foto);

        btn_cek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = et_tebak.getText().toString();
                Log.e("data", data);
                if (gambar.getName().equals(data)){
                    Toast.makeText(view.getContext(), "Anda Benar", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(view.getContext(), "Anda Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}