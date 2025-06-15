package com.s22010243.chathuranga;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DataBase_Helper_Activity extends AppCompatActivity {
    DataBaseHelper MyDB;
    EditText snumber,Password;
    Button save;


    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_data_base_helper);
        MyDB=new DataBaseHelper(this);
        snumber=findViewById(R.id.editTextSnumber);
        Password=findViewById(R.id.editTextPassword);
        save=findViewById(R.id.btnSave);
        addData();


    }

    public void addData(){
        save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isinsert=MyDB.insertData(snumber.getText().toString(),Password.getText().toString());
                        if(isinsert==true)
                            Toast.makeText(DataBase_Helper_Activity.this, "DataInsert", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(DataBase_Helper_Activity.this, "Data notInsert", Toast.LENGTH_SHORT).show();

                    }
                }
        );

    }
}
