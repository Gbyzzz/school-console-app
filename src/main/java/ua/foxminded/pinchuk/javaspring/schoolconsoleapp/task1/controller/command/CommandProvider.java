package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.controller.command;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<Integer, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(1, new FindGroupsByNumberOfStudents());
        repository.put(2, new FindStudentsByCourse());
        repository.put(3, new AddStudent());
        repository.put(4, new DeleteStudent());
        repository.put(5, new AddStudentToCourse());
        repository.put(6, new RemoveStudentFromCourse());
    }

    public Command getCommand(int select) {
        return repository.get(select);
    }
}
