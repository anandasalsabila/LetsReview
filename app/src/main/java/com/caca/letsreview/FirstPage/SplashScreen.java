package com.caca.letsreview.FirstPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.caca.letsreview.Admin.LoginDashboard;
import com.caca.letsreview.R;

public class SplashScreen extends AppCompatActivity {

    /*  Nama : Ananda Salsabila
        Kelas: AKB-4/IF4
        NIM  : 10117133

        Progress : Menyelesaikan Splash Screen 10 July 2020
     */


    private static int SPLASH_SCREEN = 2000;

    ImageView logo_app;
    TextView power;

    Animation bottomAnim,sideAnim;

    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        logo_app = findViewById(R.id.imageView);
        power = findViewById(R.id.textView);

        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        logo_app.setAnimation(bottomAnim);
        power.setAnimation(sideAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                onBoardingScreen = getSharedPreferences("onBoardingScreen",MODE_PRIVATE);
                boolean isFirstTime = onBoardingScreen.getBoolean("FirstTime",true);

                if(isFirstTime){

                    SharedPreferences.Editor editor = onBoardingScreen.edit();
                    editor.putBoolean("FirstTime",false);
                    editor.commit();

                    Intent intent = new Intent(getApplicationContext(), Walkthrough.class);
                    startActivity(intent);
                    finish();

                }
                else{
                    Intent intent = new Intent(getApplicationContext(), LoginDashboard.class);
                    startActivity(intent);
                    finish();

                }

            }
        },SPLASH_SCREEN);
    }
}