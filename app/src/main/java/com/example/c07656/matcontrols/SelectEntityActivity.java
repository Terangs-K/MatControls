package com.example.c07656.matcontrols;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SelectEntityActivity extends Activity {

    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectentity);
        Log.d("MatSelectEntityActivity", "Init SelectEntity Activity!!");

        Spinner spinner01 = (Spinner) findViewById(R.id.listUnit);
        Spinner spinner02 = (Spinner) findViewById(R.id.listSystem);
        Spinner spinner03 = (Spinner) findViewById(R.id.listSubSystem);
        Spinner spinner04 = (Spinner) findViewById(R.id.listItemGroup);
        Spinner spinner05 = (Spinner) findViewById(R.id.listItem);

        adapter = ArrayAdapter.createFromResource(this, R.array.unitlist, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner01.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this, R.array.systemlist, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner02.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this, R.array.subsystemlist, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner03.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this, R.array.itemgrouplist, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner04.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this, R.array.itemlist, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner05.setAdapter(adapter);

        Button btnSaveEntity = (Button) findViewById(R.id.btnSaveEntity);
        btnSaveEntity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectEntityActivity.this, InputFormActivity.class);
                SelectEntityActivity.this.startActivity(i);
            }
        });
    }
}
