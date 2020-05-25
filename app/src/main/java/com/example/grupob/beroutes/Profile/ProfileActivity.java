
package com.example.grupob.beroutes.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.GridView;
import android.media.Image;
import android.widget.TextView;

import com.example.grupob.beroutes.Account.AccountSettingActivity;
import com.example.grupob.beroutes.Home.HomeActivity;
import com.example.grupob.beroutes.R;
import com.example.grupob.beroutes.RoutesListActivity;
import com.example.grupob.beroutes.Utils.GridImageAdapter;
import com.example.grupob.beroutes.Utils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";
    private Context mContext = ProfileActivity.this;
    private static final int NUM_GRID_COLUMNS = 3;
    private ProgressBar mProgressBar;
    private ImageView profilePhoto;
    private TextView editPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: started.");
        mProgressBar = (ProgressBar) findViewById(R.id.profileProgressBar);
        mProgressBar.setVisibility(View.GONE);


        editPhoto = findViewById(R.id.textEditProfile);
        editPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, AccountSettingActivity.class));
            }
        });
        setupToolbar();
        setupActivityWidgets();
        initImageLoader();
        setProfileImage();


        tempGridSetup();
    }

    private void tempGridSetup(){
        ArrayList<String> imgURLs = new ArrayList<>();
        imgURLs.add("https://q-cf.bstatic.com/images/hotel/max1024x768/232/232729973.jpg");
        imgURLs.add("https://ep01.epimg.net/elviajero/imagenes/2017/10/03/videos/1507052878_337128_1507052970_noticia_normal_recorte1.jpg");
        imgURLs.add("https://www.eliberico.com/wp-content/uploads/2018/01/nueva-york.jpg");
       imgURLs.add("https://i.redd.it/pwduhknig00z.jpg");
        imgURLs.add("https://i.redd.it/clusqsm4oxzy.jpg");
        imgURLs.add("https://i.redd.it/svqvn7xs420z.jpg");
        imgURLs.add("https://i.redd.it/pwduhknig00z.jpg");
        imgURLs.add("https://i.redd.it/89cjkojkl10z.jpg");
        imgURLs.add("https://i.redd.it/aw7pv8jq4zzy.jpg");

        setupImageGrid(imgURLs);
    }

    /**
     * Encargado de que todas las imagenes sean proporcionales e iguales
     * @param imgURLs
     */
    private void setupImageGrid(ArrayList<String> imgURLs){
        GridView gridView = (GridView) findViewById(R.id.gridView);
        int gridWidth = getResources().getDisplayMetrics().widthPixels;
        int imageWidth = gridWidth/NUM_GRID_COLUMNS;
        gridView.setColumnWidth(imageWidth);

        GridImageAdapter adapter = new GridImageAdapter(mContext, R.layout.layout_grid_imageview, "", imgURLs);
        gridView.setAdapter(adapter);
    }

    /**
     * MOVER a la pagina de inicio junto ocn el initImageLoader()
     */
    private void initImageLoader(){
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(mContext);
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }

    /**
     visualizarse la foto de perfil en la pantalla de perfil
     */
    private void setProfileImage(){
        Log.d(TAG, "setProfileImage: setting image.");
        //introducir la URL correspondiente a la foto de perfil
        String imgURL = "";
        UniversalImageLoader.setImage(imgURL, profilePhoto, mProgressBar, "");
    }

    private void setupActivityWidgets(){
        mProgressBar = (ProgressBar) findViewById(R.id.profileProgressBar);
        mProgressBar.setVisibility(View.GONE);
        profilePhoto = (ImageView) findViewById(R.id.profile_photo);
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
               Log.d(TAG, "onClick: navigating to Home. ");
               Intent intent = new Intent(mContext, RoutesListActivity.class);
               startActivity(intent);
           }
       });

    }

    }





