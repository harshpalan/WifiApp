package com.example.wifi_analysis;

import android.graphics.Color;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class database extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.rgb(248, 249, 249));
        String line = null;
        textView = (TextView) findViewById(R.id.dataView);
        try {

            File dir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "1_wifianalysis");

            FileInputStream fileInputStream = new FileInputStream (new File(dir,"Wifi_Log.txt"));

            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader br = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();

            while ( (line = br.readLine()) != null )
            {
                stringBuilder.append(line + System.getProperty("line.separator"));
            }
            fileInputStream.close();
            line = stringBuilder.toString();
            textView.setText(line);

            br.close();
            Toast.makeText(this, "Displaying Log File !", Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            Toast.makeText(this, "File Not Found Error", Toast.LENGTH_SHORT).show();
        }catch(IOException e) {
            Toast.makeText(this, "IO Error", Toast.LENGTH_SHORT).show();
        }


    }
}

