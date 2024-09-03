package io.everyonecodes.week6.todos.persistence.domain;

import java.util.Objects;

public class ToDo {

    private String id;
    private String title;
    private boolean done;

    ToDo() {
    }

    public ToDo(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ToDo)) return false;
        ToDo toDo = (ToDo) o;
        return isDone() == toDo.isDone() &&
                Objects.equals(getId(), toDo.getId()) &&
                Objects.equals(getTitle(), toDo.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), isDone());
    }
}
