package com.example.c07656.matcontrols;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends Activity {

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
