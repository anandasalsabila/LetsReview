package com.caca.letsreview.Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.caca.letsreview.Admin.LoginDashboard;
import com.caca.letsreview.Admin.Profile;
import com.caca.letsreview.Databases.Categories.Action;
import com.caca.letsreview.Databases.Categories.Drama;
import com.caca.letsreview.Databases.Categories.Fiction;
import com.caca.letsreview.Databases.Categories.Horror;
import com.caca.letsreview.Databases.Categories.Musical;
import com.caca.letsreview.Databases.Categories.Thriller;
import com.caca.letsreview.Helper.HomeAdapter.CategoriesAdapter;
import com.caca.letsreview.Helper.HomeAdapter.CategoriesHelperClass;
import com.caca.letsreview.Helper.HomeAdapter.FeaturedAdapter;
import com.caca.letsreview.Helper.HomeAdapter.FeaturedHelperClass;
import com.caca.letsreview.Helper.HomeAdapter.MostViewedAdapter;
import com.caca.letsreview.Helper.HomeAdapter.MostViewedHelperClass;
import com.caca.letsreview.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    /*  Nama : Ananda Salsabila
        Kelas: AKB-4/IF4
        NIM  : 10117133

        Progress : Menyelesaikan User Dashboard 14 July 2020
     */

    static final float END_SCALE = 0.7f;

    RecyclerView featuredRecycler, mostViewedRecycler, categoriesRecycler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4;
    ImageView menuIcon;
    LinearLayout contentView;

    TextView viewAllMost, viewAllCategories;

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        featuredRecycler = findViewById(R.id.featured_recycler);
        categoriesRecycler = findViewById(R.id.categories_recycler);
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);

        viewAllCategories = findViewById(R.id.viewAllCategories);
        viewAllMost = findViewById(R.id.viewAllMost);


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);



        navigationDrawer();

        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();

        viewAllCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboard.this, AllCategories.class);
                startActivity(intent);
            }
        });

        viewAllMost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboard.this, MostViewed.class);
                startActivity(intent);
            }
        });
    }

    private void navigationDrawer() {

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();

    }

    private void animateNavigationDrawer() {

        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();


    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch ( item.getItemId()){

            case R.id.nav_all_categories:
                startActivity(new Intent(getApplicationContext(),AllCategories.class));
                break;

            case R.id.nav_drama:
                startActivity(new Intent(getApplicationContext(), Drama.class));
                break;
            case R.id.nav_action:
                startActivity(new Intent(getApplicationContext(), Action.class));
                break;
            case R.id.nav_fiction:
                startActivity(new Intent(getApplicationContext(), Fiction.class));
                break;
            case R.id.nav_horror:
                startActivity(new Intent(getApplicationContext(), Horror.class));
                break;
            case R.id.nav_musical:
                startActivity(new Intent(getApplicationContext(), Musical.class));
                break;
            case R.id.nav_thriller:
                startActivity(new Intent(getApplicationContext(), Thriller.class));
                break;


            case R.id.nav_logout:
                startActivity(new Intent(getApplicationContext(), LoginDashboard.class));
                break;

            case R.id.nav_profile:
                startActivity(new Intent(getApplicationContext(), Profile.class));
                break;

            case R.id.nav_home:
                startActivity(new Intent(getApplicationContext(), UserDashboard.class));
                break;

            case R.id.nav_most_viewed:
                startActivity(new Intent(getApplicationContext(), MostViewed.class));
                break;
        }

        return true;
    }

    private void categoriesRecycler() {

        //All Gradients
        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});


        ArrayList<CategoriesHelperClass> categoriesHelperClasses = new ArrayList<>();
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient1, "Drama", R.drawable.actris));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient2, "Romance", R.drawable.ic_romance));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient3, "Action", R.drawable.ic_action));


        categoriesRecycler.setHasFixedSize(true);
        adapter = new CategoriesAdapter(categoriesHelperClasses);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoriesRecycler.setAdapter(adapter);

    }

    private void mostViewedRecycler() {

        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.showman, "The Greatest Showman", "Hugh Jackman kini kembali hadir dalam film musikal yang mengangkat…"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.avangers, "Avangers:End Game", "Setelah sebelumnya para Avengers menelan kekalahan dari Thanos dan…"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.ff8, "The Fast and Furious 8", "Melanjutkan seri yang ketujuhnya yang mengharukan, film ini dimulai…"));

        adapter = new MostViewedAdapter(mostViewedLocations);
        mostViewedRecycler.setAdapter(adapter);

    }


    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.showman, "The Greatest Showman", "Hugh Jackman kini kembali hadir dalam film musikal yang mengangkat…"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.avangers, "Avangers:End Game", "Setelah sebelumnya para Avengers menelan kekalahan dari Thanos dan…"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.ff8, "The Fast and Furious 8", "Melanjutkan seri yang ketujuhnya yang mengharukan, film ini dimulai…"));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);

    }





}
