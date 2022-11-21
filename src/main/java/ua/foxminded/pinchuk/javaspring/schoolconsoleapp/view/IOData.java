package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.view;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Group;

import java.util.List;
import java.util.Map;

public interface IOData {
    void outputLine(String arg);

    void outputList(List<? extends Object> list);

    void outputMap(Map<Group, Integer> map);

    String getString();

    int getIntFromRange(int start, int end);

    int getInt();

    void close();
}
