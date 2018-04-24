
import android.os.Environment;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    static void writeToFile() throws IOException {
        String baseDir = Environment.getExternalStorageDirectory().getAbsolutePath();
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
        String[] data = {"Ship Name","Scientist Name", "..."};

        writer.writeNext(data);

        writer.close();
    }
}
