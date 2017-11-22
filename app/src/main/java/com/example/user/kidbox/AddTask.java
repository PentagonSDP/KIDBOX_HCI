package com.example.user.kidbox;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

/**
 * Created by emma on 10/19/17.
 */

public class  AddTask  extends AppCompatActivity {
    private static int RESULT_LOAD_IMG = 1;
    String imgDecodableString;
    private CheckBox isChecked1, isChecked2;
    String task = "" , img_path = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task);

        final EditText et1 = (EditText) findViewById(R.id.task);
        final EditText et2 = (EditText) findViewById(R.id.point);
        isChecked1 = ((CheckBox) findViewById(R.id.checkBox1));
        isChecked2 = ((CheckBox) findViewById(R.id.checkBox2));
        ImageView selectedImg =(ImageView)findViewById(R.id.imgView) ;
        Button submit = (Button) findViewById(R.id.sub);

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                task = et1.getText().toString();//task
                String point = et2.getText().toString();//point

                //task,point,isdone,image,
                String str = task + "," + point + "," + "0" + "," + img_path ;
                Log.e("input", str);
                //Toast.makeText(getApplicationContext(), "abc:: " + str, Toast.LENGTH_LONG).show();
                writeToFile(str, getApplicationContext());
                //refresh same page
                startActivity(new Intent(getApplicationContext(), AddTask.class));
            }
        });

        ImageButton img_btn = (ImageButton)findViewById(R.id.back);
        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Image = new Intent(getApplicationContext() , ToDoActivity.class);
                Image.putExtra("flag", "1");//EXTRA_MESSAGE
                startActivity(Image);
            }
        });
    }

    private void writeToFile(String data,Context context) {
        OutputStreamWriter outputStreamWriter = null;
        try {
            if( isChecked1.isChecked() ){
                Log.e("Checked", "isChecked1 ");
                FileInputStream fileIn = openFileInput("daily1.txt");
                fileIn.close();
                outputStreamWriter= new OutputStreamWriter(openFileOutput("daily1.txt", MODE_APPEND));
                Log.e("mode", "append ");
            }
            else{
                Log.e("Not Checked", "isChecked1 ");
            }

            if( isChecked2.isChecked() ){
                Log.e("Checked", "isChecked2 ");
                FileInputStream fileIn = openFileInput("bonus.txt");
                fileIn.close();
                outputStreamWriter= new OutputStreamWriter(openFileOutput("bonus.txt", MODE_APPEND));
                Log.e("mode", "append ");
            }
            else{
                Log.e("Not Checked", "isChecked2 ");
            }

        }catch( FileNotFoundException e1){
            Log.e("ADD task::", "exception: " + e1.toString());
            try{
                if( isChecked1.isChecked() ){
                    outputStreamWriter= new OutputStreamWriter(openFileOutput("daily1.txt", MODE_PRIVATE));
                    Log.e("mode", "create");
                }
                if( isChecked2.isChecked() ){
                    outputStreamWriter= new OutputStreamWriter(openFileOutput("bonus.txt", MODE_PRIVATE));
                    Log.e("mode", "create");
                }
            }catch (IOException e) {
                Log.e("ADD task::", "exception2: " + e.toString());
            }

        }catch (IOException e) {
            Log.e("ADD task::", "exception: " + e.toString());
        }
        try{
            if( outputStreamWriter != null ){
                outputStreamWriter.append(data + "\n");
                outputStreamWriter.close();
            }
            else{
                Log.e("ADD task", "File not found: ");
            }
        }catch (IOException e){
            Log.e("ADD task::", "out: " + e.toString());
        }

    }

/*------------Image choosing er part ekhane--------*/
    public void loadImagefromGallery(View view) {
        // Create intent to Open Image applications like Gallery, Google Photos
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        // Start the Intent
        startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK && null != data) {
                // Get the Image from data

                Uri selectedImage = data.getData();
                //Toast.makeText(this, data.getData().toString(), Toast.LENGTH_LONG).show();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};

                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();
                ImageView imgView = (ImageView) findViewById(R.id.imgView);
                // Set the Image in ImageView after decoding the String
                imgView.setImageBitmap(BitmapFactory.decodeFile(imgDecodableString));

                File sourceFile = new File(imgDecodableString);
                String arr[] = imgDecodableString.split("/");
                String destfile = arr[arr.length-1];
                byte[] byteArr = convertFileToByteArray(sourceFile);
                OutputStream out;
                String root = Environment.getExternalStorageDirectory().getAbsolutePath()+"/";
                File createDir = new File(root+"kidbox"+File.separator);
                if(!createDir.exists()) {
                    createDir.mkdir();
                }
                img_path = root + "kidbox" + File.separator +destfile;
                //Toast.makeText(this, img_path, Toast.LENGTH_LONG).show();
                File file = new File(root + "kidbox" + File.separator +destfile);
                file.createNewFile();
                out = new FileOutputStream(file);

                out.write(byteArr);
                out.close();
            } else {
                Toast.makeText(this, "You haven't picked Image", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
        }
    }

    public static byte[] convertFileToByteArray(File f) {
        byte[] byteArray = null;
        try {
            InputStream inputStream = new FileInputStream(f);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024*8];
            int bytesRead =0;

            while ((bytesRead = inputStream.read(b)) != -1) {
                bos.write(b, 0, bytesRead);
            }
            byteArray = bos.toByteArray();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return byteArray;
    }
}



                /*ArrayList<String> addArray = new ArrayList<String>();
                if (getInput!=null && getInput.length()>0) {
                    addArray.add(getInput);
                    Intent j = new Intent(getApplicationContext(), ToDoActivity.class);
                    //Intent k = new Intent(getApplicationContext(), TabActivity_1.class);
                    String str = "1";
                    String str1 = "1";
                    j.putExtra("flag", str);
                    j.putExtra("addtaskFlag", str1);
                    j.putExtra("mylist",addArray);
                    startActivity(j);
                    //startActivity(k);
                }


                File sourceFile = new File(imgDecodableString);
                OutputStream out;
                String root = Environment.getExternalStorageDirectory().getAbsolutePath()+"/";
                File createDir = new File(root+"Folder Name"+File.separator);
                if(!createDir.exists()) {
                    createDir.mkdir();
                }
                File file = new File(root + "Folder Name" + File.separator +"Name of File");
                file.createNewFile();
                out = new FileOutputStream(file);

                out.write(data);
                out.close();
                */


    /*private void copyFile(File sourceFile, File destFile) throws IOException {
        if (!sourceFile.exists()) {
            return;
        }
        FileChannel source = null;
        FileChannel destination = null;
        source = new FileInputStream(sourceFile).getChannel();
        destination = new FileOutputStream(destFile).getChannel();
        if (destination != null && source != null) {
            destination.transferFrom(source, 0, source.size());
        }
        if (source != null) {
            source.close();
        }
        if (destination != null) {
            destination.close();
        }
    }*/