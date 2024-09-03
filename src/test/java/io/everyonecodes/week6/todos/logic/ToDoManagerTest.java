package io.everyonecodes.week6.todos.logic;

import io.everyonecodes.week6.todos.persistence.domain.ToDo;
import io.everyonecodes.week6.todos.persistence.repository.ToDoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class ToDoManagerTest {

    @Autowired
    ToDoManager toDoManager;

    @MockBean
    ToDoRepository toDoRepository;

    @Test
    void findAll() {
        toDoManager.findAll();

        verify(toDoRepository).findAll();
    }

    @Test
    void findOne() {
        String id = "id";

        toDoManager.findOne(id);

        verify(toDoRepository).findById(id);
    }

    @Test
    void save() {
        ToDo toDo = new ToDo("test");

        toDoManager.save(toDo);

        verify(toDoRepository).save(toDo);
    }

    @Test
    void markAsDoneDoesNotFindEntry() {
        String id = "id";
        Optional<ToDo> oExpected = Optional.empty();
        when(toDoRepository.findById(id))
                .thenReturn(oExpected);

        Optional<ToDo> oResult = toDoManager.markAsDone(id);

        assertEquals(oExpected, oResult);
        verify(toDoRepository).findById(id);
    }

    @Test
    void markAsDoneFindsEntry() {
        String id = "id";
        Optional<ToDo> oExpected = Optional.of(new ToDo("test"));
        when(toDoRepository.findById(id))
                .thenReturn(oExpected);

        Optional<ToDo> oResult = toDoManager.markAsDone(id);

        oExpected.get().setDone(true);
        assertEquals(oExpected, oResult);
        verify(toDoRepository).findById(id);
        verify(toDoRepository).save(oExpected.get());
    }

    @Test
    void deleteOne() {
        String id = "id";

        toDoManager.delete(id);

        verify(toDoRepository).deleteById(id);
    }
}