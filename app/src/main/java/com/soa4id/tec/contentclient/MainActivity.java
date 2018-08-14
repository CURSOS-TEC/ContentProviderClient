package com.soa4id.tec.contentclient;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;
import android.provider.UserDictionary;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentResolver resolver =  getContentResolver();
        try {

            Uri uri = Uri.parse("content://com.soa4id.tec.shareactionsender.SOAImageProvider");

            Cursor cursor = resolver.query(uri,
                    null,
                    null,
                    null,
                    null);



            Log.i("cursor", String.valueOf(cursor.getCount()));
            Toast toast = Toast.makeText(getApplicationContext(), String.valueOf(cursor.getCount()),Toast.LENGTH_SHORT);
            toast.show();
        }catch (Exception e){
            Log.i("soaerror", e.getMessage());
            Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(),Toast.LENGTH_SHORT);
            toast.show();
        }



    }
}
