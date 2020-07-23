package com.caca.letsreview.Helper.HomeAdapter;

import android.graphics.drawable.Drawable;
import android.widget.RelativeLayout;

public class CategoriesHelperClass {

    Drawable gradient;
    String title;
    int image;

    public CategoriesHelperClass(Drawable gradient, String title, int image) {
        this.gradient = gradient;
        this.title = title;
        this.image = image;
    }

    public Drawable getGradient() {
        return gradient;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }
}
