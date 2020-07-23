package com.caca.letsreview.Databases.Categories;

import androidx.appcompat.app.AppCompatActivity;

import com.caca.letsreview.Home.AllCategories;
import com.caca.letsreview.R;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Drama extends AppCompatActivity {

    /*  Nama : Ananda Salsabila
        Kelas: AKB-4/IF4
        NIM  : 10117133

        Progress : Menyelesaikan Drama 18 July 2020
     */
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drama);
        backBtn = findViewById(R.id.back_pressed);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drama.super.onBackPressed();
            }
        });
    }
}