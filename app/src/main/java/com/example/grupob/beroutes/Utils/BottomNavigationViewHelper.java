package com.example.grupob.beroutes.Utils;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.example.grupob.beroutes.Add.AddActivity;
import com.example.grupob.beroutes.Fav.FavActivity;
import com.example.grupob.beroutes.R;
import com.example.grupob.beroutes.Search.SearchActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavigationViewHelper {
    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx) {
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        //bottomNavigationViewEx.enableItemShiftingMode(false);
        //bottomNavigationViewEx.enableShiftingMode(false);
        //bottomNavigationViewEx.setTextVisibility(false);
    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_fav:
                        Intent intent1 = new Intent(context, FavActivity.class);
                        context.startActivity(intent1);
                        break;

                    case R.id.ic_add:
                        Intent intent2 = new Intent(context, AddActivity.class);
                        context.startActivity(intent2);
                        break;

                    case R.id.ic_search:
                        Intent intent3 = new Intent(context, SearchActivity.class);
                        context.startActivity(intent3);
                        break;
                }
                return false;
            }
        });
    }

    }