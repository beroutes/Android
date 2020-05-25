package com.example.grupob.beroutes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.grupob.beroutes.Fav.FavActivity;
import com.example.grupob.beroutes.Profile.ProfileActivity;
import com.example.grupob.beroutes.RoutesCreation.RoutesCreation;
import com.example.grupob.beroutes.Search.SearchActivity;
import com.example.grupob.beroutes.Utils.BusquedasActivity;
import com.example.grupob.beroutes.Utils.GridImageAdapter;
import com.example.grupob.beroutes.Utils.UniversalImageLoader;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class FavoritesActivity extends AppCompatActivity {

    private static final int NUM_GRID_COLUMNS = 3;
    ImageView ivProfile;
    BottomNavigationItemView bnivFavorites, bnivSearch, bnivCreate;
    GridView routesGrid;
    ArrayList routes = new ArrayList<>();
    private Context mContext = FavoritesActivity.this;
    private String TAG = "";
    LinearLayout linearLayout2, linearLayout3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);


        Intent intent = getIntent();
        String extraEmail = intent.getStringExtra("email");
        Log.d(TAG, "onCreate: te has logueado a la RoutesList / Home como : " + extraEmail);

        linearLayout2 = (LinearLayout) findViewById(R.id.item2);
        linearLayout3 = (LinearLayout) findViewById(R.id.item3);

        linearLayout2.setVisibility(View.INVISIBLE);
        linearLayout3.setVisibility(View.INVISIBLE);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_favorites, R.id.navigation_search, R.id.navigation_create)
                .build();

        //Toolbar
        setupToolbar();

        //NavBar Inferior
        setupNavBarInf();

        /*tempGridSetup();
        initImageLoader();*/

        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        //NavigationUI.setupWithNavController(navView, navController);
    }

    public void cargarDetalles(View view) {
        startActivity(new Intent(FavoritesActivity.this, DetailsRouteActivity.class));
    }

    public void cargarDetalles1(View view) {
        startActivity(new Intent(FavoritesActivity.this, DetailsRouteActivity1.class));
    }

    public void cargarDetalles2(View view) {
        startActivity(new Intent(FavoritesActivity.this, DetailsRouteActivity2.class));
    }

    private void setupToolbar() {

        ivProfile = findViewById(R.id.profile);
        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FavoritesActivity.this, ProfileActivity.class));
            }
        });
    }

    private void setupNavBarInf() {
        bnivFavorites = findViewById(R.id.navigation_favorites);
        bnivFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FavoritesActivity.this, FavoritesActivity.class));
            }
        });

        bnivSearch = findViewById(R.id.navigation_search);
        bnivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FavoritesActivity.this, BusquedasActivity.class));
            }
        });

        bnivCreate = findViewById(R.id.navigation_create);
        bnivCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FavoritesActivity.this, RoutesCreation.class));
            }
        });
    }

    private void setupImageGrid(ArrayList<String> imgURLs) {
        GridView gridView = findViewById(R.id.gridView);
        int gridWidth = getResources().getDisplayMetrics().widthPixels;
        int imageWidth = gridWidth / NUM_GRID_COLUMNS;
        gridView.setColumnWidth(imageWidth);

        GridImageAdapter adapter = new GridImageAdapter(mContext, R.layout.layout_grid_imageview, "", imgURLs);
        gridView.setAdapter(adapter);
    }

    private void tempGridSetup() {
        ArrayList<String> imgURLs = new ArrayList<>();
        imgURLs.add("https://i.redd.it/clusqsm4oxzy.jpg");
        imgURLs.add("https://i.redd.it/9bf67ygj710z.jpg");
        imgURLs.add("https://i.redd.it/59kjlxxf720z.jpg");
        imgURLs.add("https://i.redd.it/pwduhknig00z.jpg");
        imgURLs.add("https://i.redd.it/clusqsm4oxzy.jpg");
        imgURLs.add("https://i.redd.it/svqvn7xs420z.jpg");
        imgURLs.add("https://i.redd.it/pwduhknig00z.jpg");
        imgURLs.add("https://i.redd.it/89cjkojkl10z.jpg");
        imgURLs.add("https://i.redd.it/aw7pv8jq4zzy.jpg");

        setupImageGrid(imgURLs);
    }

    private void initImageLoader() {
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(mContext);
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }
}
