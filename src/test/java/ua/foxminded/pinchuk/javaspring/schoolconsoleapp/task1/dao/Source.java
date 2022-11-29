package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao;

import org.junit.jupiter.params.provider.Arguments;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.beans.Course;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.beans.Group;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.beans.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Source {
    public static Group group = new Group(1, "First");
    public static List<Student> students = new ArrayList<Student>() {{
        add(new Student(1, group, "John", "Smith"));
        add(new Student(2, group, "Jeremy", "Brown"));
    }};
    public static List<Student> studentsFromCourse = new ArrayList<Student>() {{
        add(new Student(1, group, "John", "Smith"));
        add(new Student(3, group, "Sam", "Green"));
    }};

    public static Stream<Arguments> provideCourses() {
        return Stream.of(
                Arguments.of(new ArrayList<Course>() {{
                                 add(new Course.Builder()
                                         .setId(1)
                                         .setName("Math")
                                         .setDescription("Math lessons")
                                         .build());
                                 add(new Course.Builder()
                                         .setId(2)
                                         .setName("Physics")
                                         .setDescription("Physics lessons")
                                         .build());
                             }}
                        , 1),
                Arguments.of(new ArrayList<Course>() {{
                                 add(new Course.Builder()
                                         .setId(2)
                                         .setName("Physics")
                                         .setDescription("Physics lessons")
                                         .build());
                             }}
                        , 2)
        );
    }

    public static Stream<Arguments> provideStudents() {

        return Stream.of(
                Arguments.of(students));
    }

    public static Stream<Arguments> provideStudentsFromCourse() {

        return Stream.of(
                Arguments.of(studentsFromCourse));
    }
}
