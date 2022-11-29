package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.beans;

import java.util.Objects;

public class Group {
    private int id;
    private String name;

    public Group() {
    }

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id == group.id && Objects.equals(name, group.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return id + ". " + name;
    }

    public static class Builder {
        Group newGroup;

        public Builder() {
            newGroup = new Group();
        }

        public Group.Builder setId(int id) {
            newGroup.setId(id);
            return this;
        }

        public Group.Builder setName(String name) {
            newGroup.setName(name);
            return this;
        }

        public Group build() {
            return newGroup;
        }
    }
}
