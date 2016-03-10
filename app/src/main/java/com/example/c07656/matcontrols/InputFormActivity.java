package com.example.c07656.matcontrols;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class InputFormActivity extends Activity {

    ArrayAdapter adapter;
    private int TAKE_CAMERA = 1;
    private int TAKE_GALLERY = 2;
    EditText editPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputform);
        Log.d("MatInputFormActivity", "Init InputForm Activity!!");

        editPath = (EditText)findViewById(R.id.editImgList);

        Spinner spinner01 = (Spinner) findViewById(R.id.listPunchGroup);
        Spinner spinner02 = (Spinner) findViewById(R.id.listDiscipline);
        Spinner spinner03 = (Spinner) findViewById(R.id.listPriority);

        adapter = ArrayAdapter.createFromResource(this, R.array.punchgrouplist, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner01.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this, R.array.discipinelist, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner02.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this, R.array.prioritylist, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner03.setAdapter(adapter);


        Button btnSaveCamera = (Button) findViewById(R.id.btnSaveCamera);
        btnSaveCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, TAKE_CAMERA);
            }
        });

        Button btnSaveGallery = (Button) findViewById(R.id.btnSaveGallery);
        btnSaveGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK);
                i.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
                i.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, TAKE_GALLERY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == TAKE_CAMERA){
                Uri currImageURI = data.getData();
                editPath.setText("CAMERA : " + getRealPathFromURI(currImageURI));
            }else if(requestCode == TAKE_GALLERY){
                Uri currImageURI = data.getData();
                editPath.setText("GALLERY : " + getRealPathFromURI(currImageURI));
            }
        }
    }

    public String getRealPathFromURI(Uri contentUri){
        String [] proj={MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery( contentUri, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);

    }
}
