package adapter;

import edu.isu.cs2263.hw02.Course;
import edu.isu.cs2263.hw02.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {

    Student student;
    Course course;

    @BeforeEach
    void setUp(){
        course = new Course(2263, "CS", "Advanced OO Programming");
        student = new Student("Natalia", "Castaneda",course);
    }

    @Test
    @DisplayName("First and last name should appear")
    void testToString(){
        assertEquals("Natalia Castaneda", student.toString());
    }
}
