package io.everyonecodes.week6.todos.persistence.repository;


import io.everyonecodes.week6.todos.persistence.domain.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToDoRepository extends MongoRepository<ToDo, String> {
}
