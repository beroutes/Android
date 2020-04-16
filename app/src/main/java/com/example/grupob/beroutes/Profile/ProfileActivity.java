
package com.example.grupob.beroutes.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.grupob.beroutes.Account.AccountSettingActivity;
import com.example.grupob.beroutes.Home.HomeActivity;
import com.example.grupob.beroutes.R;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";
    private Context mContext = ProfileActivity.this;

    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: started.");
        mProgressBar = (ProgressBar) findViewById(R.id.profileProgressBar);
        mProgressBar.setVisibility(View.GONE);


        setupToolbar();
    }


    //Encargado de gestionar el profile toolbar
    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.profileToolBar);
        setSupportActionBar(toolbar);

       ImageView profileMenu = (ImageView) findViewById(R.id.profileMenu);
       profileMenu.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Log.d(TAG, "onClick: navigating to account settings. ");
               Intent intent = new Intent(mContext, AccountSettingActivity.class);
               startActivity(intent);
           }
       });

       ImageView profileName = (ImageView) findViewById(R.id.profileName);
       profileName.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Log.d(TAG, "onClick: navigating to account settings. ");
               Intent intent = new Intent(mContext, HomeActivity.class);
               startActivity(intent);
           }
       });

    }

    }





