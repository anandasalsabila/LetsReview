package com.caca.letsreview.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.caca.letsreview.Databases.Categories.Action;
import com.caca.letsreview.Databases.Categories.Drama;
import com.caca.letsreview.Databases.Categories.Fiction;
import com.caca.letsreview.Databases.Categories.Horror;
import com.caca.letsreview.Databases.Categories.Musical;
import com.caca.letsreview.Databases.Categories.Thriller;
import com.caca.letsreview.R;

public class AllCategories extends AppCompatActivity {

    /*  Nama : Ananda Salsabila
        Kelas: AKB-4/IF4
        NIM  : 10117133

        Progress : Menyelesaikan All Categories 15 July 2020
     */

    ImageView backBtn;

    Button drama, comedy, fiction, horror, musical, romance, war, thriller, action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_categories);

        backBtn = findViewById(R.id.back_pressed);

        drama = findViewById(R.id.drama);
        fiction = findViewById(R.id.fiction);
        horror = findViewById(R.id.horror);
        musical = findViewById(R.id.musical);
        thriller = findViewById(R.id.thriller);
        action = findViewById(R.id.action);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AllCategories.super.onBackPressed();
            }
        });

        drama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllCategories.this, Drama.class);
                startActivity(intent);
            }
        });

        horror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllCategories.this, Horror.class);
                startActivity(intent);
            }
        });

        fiction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllCategories.this, Fiction.class);
                startActivity(intent);
            }
        });

        musical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllCategories.this, Musical.class);
                startActivity(intent);
            }
        });

        thriller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllCategories.this, Thriller.class);
                startActivity(intent);
            }
        });

        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllCategories.this, Action.class);
                startActivity(intent);
            }
        });
    }
}