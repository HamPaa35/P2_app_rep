package com.example.pjevs.projecttest1;

import android.content.Context;
import android.os.Environment;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class FileManager {
    static void writeToFile() throws IOException {
        /*InputStream is = this.getResources().openRawResource(R.raw.test);
        File file = new File(this.getFilesDir(), "test.csv");

        String filename = "myfile";
        String fileContents = "Hello world!";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        /*String csv = "test.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(csv));

        String [] country = "India#China#United States".split("#");

        writer.writeNext(country);

        writer.close();


        /*String baseDir = Environment.getExternalStorageDirectory().getAbsolutePath();
        String fileName = "AnalysisData.csv";
        String filePath = baseDir + File.separator + fileName;
        File f = new File(filePath );
        CSVWriter writer;
// File exist
        if(f.exists() && !f.isDirectory()){
            FileWriter mFileWriter = new FileWriter(filePath , true);
            writer = new CSVWriter(mFileWriter);
        }
        else {
            writer = new CSVWriter(new FileWriter(filePath));
        }
        String[] data = {"Ship Name","Scientist Name"};

        writer.writeNext(data);

        writer.close();*/
    }
}
