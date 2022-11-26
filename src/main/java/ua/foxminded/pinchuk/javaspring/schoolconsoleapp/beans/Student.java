package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans;

import java.util.List;
import java.util.Objects;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private Group group;
    private List<Course> courses;

    public Student() {

    }

    public Student(String firstName, String lastName, Group group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
    }

    public Student(int id, Group group, String firstName, String lastName, List<Course> courses) {
        this.id = id;
        this.group = group;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
    }

    public Student(int id, Group group, String firstName, String lastName) {
        this.id = id;
        this.group = group;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(group, student.group) && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(courses, student.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, group, firstName, lastName, courses);
    }

    @Override
    public String toString() {
        return id + ". " + firstName + " " + lastName + ", group: " + group.getName() + "(#" + group.getId() + ")";
    }

    public static class Builder {
        private Student newStudent;

        public Builder() {
            newStudent = new Student();
        }

        public Student.Builder setId(int id) {
            newStudent.setId(id);
            return this;
        }

        public Student.Builder setFirstName(String firstName) {
            newStudent.setFirstName(firstName);
            return this;
        }

        public Student.Builder setLastName(String lastName) {
            newStudent.setLastName(lastName);
            return this;
        }

        public Student.Builder setGroup(Group group) {
            newStudent.setGroup(group);
            return this;
        }

        public Student.Builder setCourses(List<Course> courses) {
            newStudent.setCourses(courses);
            return this;
        }

        public Student build() {
            return newStudent;
        }
    }
}
