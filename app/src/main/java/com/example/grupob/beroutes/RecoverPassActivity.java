package com.example.grupob.beroutes;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RecoverPassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_pass);

        Button recoverPassButton;
        TextView loginButton;

        recoverPassButton = findViewById(R.id.recoverPass_button);
        loginButton = findViewById(R.id.recoverPass_returnToLogin);

        recoverPassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),RecoverPassActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),LoginActivity.class);
                startActivityForResult(intent, 0);
            }
        });



    }
}
