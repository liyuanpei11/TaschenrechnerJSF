package de.li.todonew;

import de.li.todolist.Todo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.List;

@Named("todoCDI")
@ApplicationScoped
public class TodoCDIBean {
    private int todoId;
    private String todoBeschreibung;

    private List<Todo> todoList;


    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public String getTodoBeschreibung() {
        return todoBeschreibung;
    }

    public void setTodoBeschreibung(String todoBeschreibung) {
        this.todoBeschreibung = todoBeschreibung;
    }

    public List<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }
}
