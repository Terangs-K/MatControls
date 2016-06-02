package com.skcc.skpcm.matcontrols;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.aviary.android.feather.library.Constants;
import com.aviary.android.feather.sdk.FeatherActivity;

import java.util.ArrayList;

import me.nereo.multi_image_selector.MultiImageSelectorActivity;

public class InputFormActivity extends Activity {

    ArrayAdapter adapter;
    ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9, img10;

    private int TAKE_AVIARY = 1;
    private int TAKE_CAMERA = 2;
    private int TAKE_GALLERY = 3;
    private int AVIARY_INDEX = 0;
    private ArrayList<String> mSelectPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputform);
        Log.d("MatInputFormActivity", "Init InputForm Activity!!");

        mSelectPath = new ArrayList<String>(10);

        Spinner spinner01 = (Spinner) findViewById(R.id.listPunchGroup);
        Spinner spinner02 = (Spinner) findViewById(R.id.listDiscipline);
        Spinner spinner03 = (Spinner) findViewById(R.id.listPriority);

        img1 = (ImageView) findViewById(R.id.gridImage01);
        img2 = (ImageView) findViewById(R.id.gridImage02);
        img3 = (ImageView) findViewById(R.id.gridImage03);
        img4 = (ImageView) findViewById(R.id.gridImage04);
        img5 = (ImageView) findViewById(R.id.gridImage05);
        img6 = (ImageView) findViewById(R.id.gridImage06);
        img7 = (ImageView) findViewById(R.id.gridImage07);
        img8 = (ImageView) findViewById(R.id.gridImage08);
        img9 = (ImageView) findViewById(R.id.gridImage09);
        img10 = (ImageView) findViewById(R.id.gridImage10);

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

                Intent i = new Intent(InputFormActivity.this, MultiImageSelectorActivity.class);
                i.putExtra(MultiImageSelectorActivity.EXTRA_SHOW_CAMERA, false);
                i.putExtra(MultiImageSelectorActivity.EXTRA_SELECT_COUNT, 10);
                i.putExtra(MultiImageSelectorActivity.EXTRA_SELECT_MODE, MultiImageSelectorActivity.MODE_MULTI);

                if(mSelectPath != null && mSelectPath.size()>0) {
                    i.putExtra(MultiImageSelectorActivity.EXTRA_DEFAULT_SELECTED_LIST, mSelectPath);
                }

                startActivityForResult(i, TAKE_GALLERY);
            }
        });

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AVIARY_INDEX = 0;
                Intent newIntent = new Intent(InputFormActivity.this, FeatherActivity.class );
                newIntent.setData( Uri.parse((mSelectPath.get(0))));
                newIntent.putExtra( Constants.EXTRA_IN_API_KEY_SECRET, "5ab01a3e-43ff-449a-a0b7-6e0b30335fe2" );
                startActivityForResult( newIntent, TAKE_AVIARY );
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == TAKE_AVIARY) {
                // output image path
                Uri mImageUri = data.getData();
                Bundle extra = data.getExtras();
                if( null != extra ) {
                    // image has been changed by the user?
                    boolean changed = extra.getBoolean( Constants.EXTRA_OUT_BITMAP_CHANGED );
                }

                try {
                    switch(AVIARY_INDEX) {
                        case 0:
                            img1.setImageURI(mImageUri);
                            mSelectPath.set(0, mImageUri.toString());
                            break;
                    }
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }else if(requestCode == TAKE_CAMERA){
                Uri currImageURI = data.getData();
                mSelectPath.add(0, getRealPathFromURI(currImageURI));
                img1.setImageURI(currImageURI);
            } else if (requestCode == TAKE_GALLERY){

                mSelectPath = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 10; i++) {

                    try {
                        if (i >= mSelectPath.size()) {
                            switch (i) {
                                case 0:
                                    img1.setImageDrawable(getResources().getDrawable(R.drawable.asv));
                                    break;
                                case 1:
                                    img2.setVisibility(View.GONE);
                                    break;
                                case 2:
                                    img3.setVisibility(View.GONE);
                                    break;
                                case 3:
                                    img4.setVisibility(View.GONE);
                                    break;
                                case 4:
                                    img5.setVisibility(View.GONE);
                                    break;
                                case 5:
                                    img6.setVisibility(View.GONE);
                                    break;
                                case 6:
                                    img7.setVisibility(View.GONE);
                                    break;
                                case 7:
                                    img8.setVisibility(View.GONE);
                                    break;
                                case 8:
                                    img9.setVisibility(View.GONE);
                                    break;
                                case 9:
                                    img10.setVisibility(View.GONE);
                                    break;
                            }
                        } else {
                            switch (i) {
                                case 0:
                                    img1.setImageBitmap(loadFilePathtoBitmap(mSelectPath.get(i)));
                                    break;
                                case 1:
                                    img2.setVisibility(View.VISIBLE);
                                    img2.setImageBitmap(loadFilePathtoBitmap(mSelectPath.get(i)));
                                    break;
                                case 2:
                                    img3.setVisibility(View.VISIBLE);
                                    img3.setImageBitmap(loadFilePathtoBitmap(mSelectPath.get(i)));
                                    break;
                                case 3:
                                    img4.setVisibility(View.VISIBLE);
                                    img4.setImageBitmap(loadFilePathtoBitmap(mSelectPath.get(i)));
                                    break;
                                case 4:
                                    img5.setVisibility(View.VISIBLE);
                                    img5.setImageBitmap(loadFilePathtoBitmap(mSelectPath.get(i)));
                                    break;
                                case 5:
                                    img6.setVisibility(View.VISIBLE);
                                    img6.setImageBitmap(loadFilePathtoBitmap(mSelectPath.get(i)));
                                    break;
                                case 6:
                                    img7.setVisibility(View.VISIBLE);
                                    img7.setImageBitmap(loadFilePathtoBitmap(mSelectPath.get(i)));
                                    break;
                                case 7:
                                    img8.setVisibility(View.VISIBLE);
                                    img8.setImageBitmap(loadFilePathtoBitmap(mSelectPath.get(i)));
                                    break;
                                case 8:
                                    img9.setVisibility(View.VISIBLE);
                                    img9.setImageBitmap(loadFilePathtoBitmap(mSelectPath.get(i)));
                                    break;
                                case 9:
                                    img10.setVisibility(View.VISIBLE);
                                    img10.setImageBitmap(loadFilePathtoBitmap(mSelectPath.get(i)));
                                    break;
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public String getRealPathFromURI(Uri contentUri){
        String [] proj={MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query( contentUri, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();

        return cursor.getString(column_index);
    }

    public static Bitmap loadFilePathtoBitmap(String filePath) throws Exception, OutOfMemoryError {
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inSampleSize = 6;
        Bitmap retunrBit = BitmapFactory.decodeFile(filePath, opt);

        return retunrBit;
    }
}
