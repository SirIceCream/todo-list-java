package io.everyonecodes.week6.todos.logic;

import io.everyonecodes.week6.todos.persistence.domain.ToDo;
import io.everyonecodes.week6.todos.persistence.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoManager {

    private final ToDoRepository toDoRepository;

    public ToDoManager(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    public Optional<ToDo> findOne(String id) {
        return toDoRepository.findById(id);
    }

    public ToDo save(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public Optional<ToDo> markAsDone(String id) {
        Optional<ToDo> oToDo = toDoRepository.findById(id);
        if (oToDo.isEmpty()) {
            return Optional.empty();
        }
        ToDo toDo = oToDo.get();
        toDo.setDone(true);
        toDoRepository.save(toDo);
        return Optional.of(toDo);
    }

    public void delete(String id) {
        toDoRepository.deleteById(id);
    }
}
