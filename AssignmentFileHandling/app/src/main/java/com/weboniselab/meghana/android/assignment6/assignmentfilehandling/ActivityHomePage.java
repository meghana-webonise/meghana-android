package com.weboniselab.meghana.android.assignment6.assignmentfilehandling;

import android.app.Activity;
import android.content.Intent;
import android.os.Environment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ActivityHomePage extends Activity implements View.OnClickListener{

    EditText etWriteFieldData;
    Button btnInsert,btnRead,btnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_home_page);
        initialise();
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.btnInsert:
                insertDataIntoFile();
                break;
            case R.id.btnRead:
                readDataFromFile();
                break;
            case R.id.btnDelete:
                deleteFile();
                break;
        }
    }

    public void insertDataIntoFile(){
        try {
            File file=new File(Environment.getExternalStorageDirectory()+File.separator+ Constants.FILENAME);
            file.createNewFile();
            FileOutputStream fos=new FileOutputStream(file);
            OutputStreamWriter osw=new OutputStreamWriter(fos);
            osw.append(etWriteFieldData.getText());
            osw.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void readDataFromFile(){
        try{
            File file=new File(Environment.getExternalStorageDirectory()+File.separator+ Constants.FILENAME);
            FileInputStream fis=new FileInputStream(file);
            BufferedReader br=new BufferedReader(new InputStreamReader(fis));
            String strData=null;
            String txtData="";
            while ((strData=br.readLine())!=null){
                txtData+=strData;
            }
            Intent intent=new Intent(ActivityHomePage.this,ActivityViewData.class);
            intent.putExtra(getResources().getString(R.string.readDataFromFileText),txtData);
            startActivity(intent);

        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public void deleteFile(){
        File file=new File(Environment.getExternalStorageDirectory()+File.separator+ Constants.FILENAME);
        boolean status=file.delete();
        if(status)
            Toast.makeText(ActivityHomePage.this,getResources().getString(R.string.deleteFileToastDelete), Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(ActivityHomePage.this,getResources().getString(R.string.deleteFileToastNotDeleted), Toast.LENGTH_SHORT).show();

    }

    public void initialise(){
        etWriteFieldData=(EditText) findViewById(R.id.etWriteFileData);
        btnInsert=(Button) findViewById(R.id.btnInsert);
        btnRead=(Button) findViewById(R.id.btnRead);
        btnDelete=(Button) findViewById(R.id.btnDelete);
        btnInsert.setOnClickListener(this);
        btnRead.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

}
