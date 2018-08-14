package com.soa4id.tec.contentclient;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.BaseColumns;
import android.provider.UserDictionary;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = findViewById(R.id.main_activity_image_view);
        ContentResolver resolver =  getContentResolver();
        try {

            Uri uri = Uri.parse("content://com.soa4id.tec.shareactionsender.SOAImageProvider");

            Cursor cursor = resolver.query(uri,
                    null,
                    null,
                    null,
                    null);


            cursor.moveToFirst();

            try{
                int id = cursor.getInt(0);
                byte[] imageData = cursor.getBlob(1);
                //Log.i("column-count",String.valueOf(cursor.getColumnCount()));
                //Log.i("column-name",cursor.getColumnNames()[1]);
                if(imageData == null){
                    Log.i("image-data", "null");
                }
                else {
                    Bitmap image = BitmapFactory.decodeByteArray(imageData,0,imageData.length);
                    mImageView.setImageBitmap(image);
                }
            }catch (Exception e){
                Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(),Toast.LENGTH_SHORT);
                toast.show();
            }

            Log.i("cursor", String.valueOf(cursor.getCount()));
            Toast toast = Toast.makeText(getApplicationContext(), String.valueOf(cursor.getCount()),Toast.LENGTH_SHORT);
            toast.show();
        }catch (Exception e){
            Log.i("soaerror", e.getMessage());
            Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(),Toast.LENGTH_LONG);
            toast.show();
        }



    }
}
