package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans;

import java.util.List;
import java.util.Objects;

public class Course {
    private int id;
    private String name;
    private String description;
    private List<Student> students;

    public Course() {
    }

    public Course(int id, String name, String description, List<Student> students) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id && Objects.equals(name, course.name) && Objects.equals(description, course.description) && Objects.equals(students, course.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, students);
    }

    @Override
    public String toString() {
        return id + ". " + name + ": " + description;
    }

    public static class Builder {
        private Course newCourse;

        public Builder() {
            newCourse = new Course();
        }

        public Course.Builder setId(int id) {
            newCourse.setId(id);
            return this;
        }

        public Course.Builder setName(String name) {
            newCourse.setName(name);
            return this;
        }

        public Course.Builder setDescription(String description) {
            newCourse.setDescription(description);
            return this;
        }

        public Course.Builder setStudents(List<Student> students) {
            newCourse.setStudents(students);
            return this;
        }

        public Course build() {
            return newCourse;
        }


    }
}
