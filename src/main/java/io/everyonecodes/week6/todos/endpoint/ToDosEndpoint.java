package io.everyonecodes.week6.todos.endpoint;

import io.everyonecodes.week6.todos.logic.ToDoManager;
import io.everyonecodes.week6.todos.persistence.domain.ToDo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDosEndpoint {

    private final ToDoManager toDoManager;

    public ToDosEndpoint(ToDoManager toDoManager) {
        this.toDoManager = toDoManager;
    }

    @GetMapping
    List<ToDo> getAll() {
        return toDoManager.findAll();
    }

    @GetMapping("/{id}")
    ToDo getOne(@PathVariable String id) {
        return toDoManager.findOne(id)
                .orElse(null);
    }

    @PostMapping
    ToDo post(@RequestBody ToDo toDo) {
        return toDoManager.save(toDo);
    }

    @PutMapping("/{id}/done")
    ToDo put(@PathVariable String id) {
        return toDoManager.markAsDone(id)
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable String id) {
        toDoManager.delete(id);
    }

}
