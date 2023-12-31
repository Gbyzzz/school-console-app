package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.view.impl;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Group;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.view.IOData;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class IODataImpl implements IOData {

    private static final Scanner IN = new Scanner(System.in);

    @Override
    public void outputLine(String arg) {
        System.out.println(arg);
    }

    @Override
    public void newLine(){
        System.out.println(System.getProperty("line.separator"));
    }

    @Override
    public void outputList(List list) {
        for (Object obj : list) {
            outputLine(obj.toString());
        }
    }

    @Override
    public void outputMapOfGroups(Map<Group, Integer> map) {
        for (Map.Entry<Group, Integer> entry : map.entrySet()) {
            outputLine(entry.getKey().toString() + " - " + entry.getValue().toString() + " students");
        }
    }


    @Override
    public String getString() {
        String res = "";
        while (IN.hasNext()) {
            res = IN.nextLine();
            break;
        }
        return res;
    }

    @Override
    public int getIntFromRange(int start, int end) {
        int res = 0;
        while (IN.hasNextInt()) {
            res = Integer.parseInt(IN.nextLine());
            if (res <= end && res >= start) {
                break;
            } else {
                IN.next();

            }
        }
        return res;
    }

    @Override
    public int getInt() {
        int res = 0;
        if (IN.hasNextInt()) {
            res = Integer.parseInt(IN.nextLine());
        }
        return res;
    }

    @Override
    public void close() {
        IN.close();
    }

}
