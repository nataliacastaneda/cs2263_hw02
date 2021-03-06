/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package edu.isu.cs2263.hw02;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import static edu.isu.cs2263.hw02.IOManager.writeData;
import static edu.isu.cs2263.hw02.IOManager.readData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//This program creates a java application that displays the students and their respective courses when
//the load data button is pressed. Ideally, it would allow for the selection of one student in the list, and show
//all of courses taken by that one student. Selecting a different student would give a different set of courses.
public class App extends Application {
    //singleton implementation of App class: this singleton method does not
    // allow run to work, so it has been omitted from the code
  /*  private static App singleton;
    protected App(){
        super();
    }

    public static App instance(){
        if(singleton == null)
            singleton = new App();
        return  singleton;
    } */

    public static void main(String[] args) throws IOException {
        //Data to be read into program
        //Course Data
        Course course1 = new Course(1181, "CS", "Intro to Programming");
        Course course2 = new Course(2263, "CS", "Advanced OO Programming");
        Course course3 = new Course(4423, "CS", "Software Evolution");
        //Student Data
        Student student1 = new Student("Isaac", "Griffith", course1);
        Student student2 = new Student("Bob", "Sampson", course2);
        Student student3 = new Student("Sarah", "James", course3);
        //List to hold students
        List<Student> students = new ArrayList<Student>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        //converting data to a json file
        writeData("StudentData.json", students);
        // readData("StudentData.json");

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Course View");

        //create labels for lists
        Label label1 = new Label("Students->");
        Label label2 = new Label("Courses->");
        //create lists
        ListView studentList = new ListView();
        ListView courseList = new ListView();
        //create button
        Button button = new Button("Load Data");
        button.setWrapText(true);

//        Button button2 = new Button("View Course by Student");
 //       button.setWrapText(true);

        //set up layout of UI
        HBox hbox = new HBox(label1, studentList, label2, courseList, button);
        //create and set the scene
        Scene scene = new Scene(hbox, 100, 100);
        stage.setScene(scene);
        //stage the UI
        stage.show();

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event2) {
                List<Student> readList = readData("StudentData.json");
                //iterate across items in list
                Iterator iterator = readList.iterator();
                while(iterator.hasNext()){
                    //for each student in the list, load the data when the button is pressed
                    Student stud = (Student) iterator.next();
                    studentList.getItems().add(stud.getFirstName() +" "+stud.getLastName());
                    courseList.getItems().add(stud.getStudentCourse().toString());
                }
            }
        });
    }
}
