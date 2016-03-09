package com.example.c07656.matcontrols;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewPunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpunch);
        Log.d("MatNewPunchActivity", "Init NewPunch Activity!!");

        Button btnBarcode = (Button) findViewById(R.id.btnBarcode);
        btnBarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NewPunchActivity.this, "Barcode Function Call", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnSelctEntity = (Button) findViewById(R.id.btnSelectEntity);
        btnSelctEntity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NewPunchActivity.this, SelectEntityActivity.class);
                NewPunchActivity.this.startActivity(i);
            }
        });
    }
}
