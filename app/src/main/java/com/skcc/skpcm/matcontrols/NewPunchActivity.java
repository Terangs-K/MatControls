package com.skcc.skpcm.matcontrols;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class NewPunchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpunch);
        Log.d("MatNewPunchActivity", "Init NewPunch Activity!!");

        Button btnBarcode = (Button) findViewById(R.id.btnBarcode);
        btnBarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(NewPunchActivity.this, "Barcode Function Call", Toast.LENGTH_SHORT).show();
                new IntentIntegrator(NewPunchActivity.this).initiateScan();
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

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Log.d("NewPunchActivity", "Cancelled scan");
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Log.d("NewPunchActivity", "Scanned");
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
            }
        } else {
            Log.d("NewPunchActivity", "Weird");
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
