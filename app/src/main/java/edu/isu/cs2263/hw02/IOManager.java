package edu.isu.cs2263.hw02;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//This class reads a list of students (each with a course list) from Json using Gson.
//This class also contains a method to read the data into the UI
public class IOManager {

    //reference for reading JSON files to java: https://attacomsian.com/blog/gson-read-json-file
    public static List<Student> readData(String jsonFile) {
        try {
            //create Gson instance
            Gson gson = new Gson();

            //create a reader
            Reader reader = Files.newBufferedReader(Paths.get(jsonFile));

            //set type for student list
            Type studentListType = new TypeToken<ArrayList<Student>>(){}.getType();

            //convert JSON string to List of students
            List<Student> studentList = gson.fromJson(reader, studentListType);

            //close reader
            reader.close();

            return studentList;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    //Create a class IOManger as shown below which will read in a list of Students
    // (where each student contains a list of Courses) from JSON using Gson
    public static void writeData(String jsonFile, List<Student> data) throws IOException {
        //create Gson instance
        Gson gson = new Gson();
        //create json string to hold data
        String jsonString = gson.toJson(data);

        try {
            //create the jsonFile
            File file = new File(jsonFile);
            file.createNewFile();

            //write the json string into the json file
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(jsonString);

            //close the file
            fileWriter.flush();
            fileWriter.close();

        } catch(IOException e){
            e.printStackTrace();
        }
    }
}


