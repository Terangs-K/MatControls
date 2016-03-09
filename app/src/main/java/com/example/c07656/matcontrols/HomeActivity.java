package com.example.c07656.matcontrols;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d("MatHomeActivity", "Init Home Activity!!");

        Button btnPunchNew = (Button) findViewById(R.id.btnPunchNew);
        btnPunchNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, NewPunchActivity.class);
                HomeActivity.this.startActivity(i);
            }
        });
    }
}
