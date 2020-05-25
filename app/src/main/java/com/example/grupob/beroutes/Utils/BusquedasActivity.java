package com.example.grupob.beroutes.Utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.grupob.beroutes.DetailsRouteActivity;
import com.example.grupob.beroutes.DetailsRouteActivity1;
import com.example.grupob.beroutes.DetailsRouteActivity2;
import com.example.grupob.beroutes.FavoritesActivity;
import com.example.grupob.beroutes.Profile.ProfileActivity;
import com.example.grupob.beroutes.R;
import com.example.grupob.beroutes.RoutesCreation.RoutesCreation;
import com.example.grupob.beroutes.Search.SearchActivity;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

public class BusquedasActivity extends AppCompatActivity {

    private static final int NUM_GRID_COLUMNS = 2;
    ImageView ivProfile;
    BottomNavigationItemView bnivFavorites, bnivSearch, bnivCreate;
    GridView routesGrid;
    ArrayList routes = new ArrayList<>();
    private Context mContext = BusquedasActivity.this;
    private String TAG = "";
    private Button btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);


        Intent intent = getIntent();
        String extraEmail = intent.getStringExtra("email");
        Log.d(TAG, "onCreate: te has logueado a la RoutesList / Home como : " + extraEmail);


        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_favorites, R.id.navigation_search, R.id.navigation_create)
                .build();


        setupToolbar();


        //Spinner
        Spinner dynamicSpinner = (Spinner) findViewById(R.id.dynamic_spinner);

        String[] items = new String[] { "Naturaleza", "Urbano", "Familia", "Amigos", "Románticas", "Mochileros" };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, items);

        dynamicSpinner.setAdapter(adapter);

        dynamicSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        //Fin Spinner

        //buscar
        btnBuscar = (Button) findViewById(R.id.btnBuscar);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BusquedasActivity.this, DetailsRouteActivity2.class));
            }
        });

        setupNavBarInf();

        /*tempGridSetup();
        initImageLoader();*/

        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        //NavigationUI.setupWithNavController(navView, navController);
    }


    private void setupToolbar() {

        ivProfile = findViewById(R.id.profile);
        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BusquedasActivity.this, ProfileActivity.class));
            }
        });
    }

    private void setupNavBarInf() {
        bnivFavorites = findViewById(R.id.navigation_favorites);
        bnivFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BusquedasActivity.this, FavoritesActivity.class));
            }
        });

        bnivSearch = findViewById(R.id.navigation_search);
        bnivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BusquedasActivity.this, BusquedasActivity.class));
            }
        });

        bnivCreate = findViewById(R.id.navigation_create);
        bnivCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BusquedasActivity.this, RoutesCreation.class));
            }
        });
    }


}
