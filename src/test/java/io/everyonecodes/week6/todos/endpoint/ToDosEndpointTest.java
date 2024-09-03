package io.everyonecodes.week6.todos.endpoint;

import io.everyonecodes.week6.todos.logic.ToDoManager;
import io.everyonecodes.week6.todos.persistence.domain.ToDo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ToDosEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    ToDoManager toDoManager;

    String url = "/todos";

    @Test
    void getAll() {
        testRestTemplate.getForObject(url, ToDo[].class);

        verify(toDoManager).findAll();
    }

    @Test
    void getOne() {
        String id = "id";

        testRestTemplate.getForObject(url + "/" + id, ToDo[].class);

        verify(toDoManager).findOne(id);
    }

    @Test
    void post() {
        ToDo toDo = new ToDo("test");

        testRestTemplate.postForObject(url, toDo, ToDo[].class);

        verify(toDoManager).save(toDo);
    }

    @Test
    void put() {
        String id = "id";

        testRestTemplate.put(url + "/" + id + "/done", null);

        verify(toDoManager).markAsDone(id);
    }

    @Test
    void deleteOne() {
        String id = "id";

        testRestTemplate.delete(url + "/" + id);

        verify(toDoManager).delete(id);
    }
}