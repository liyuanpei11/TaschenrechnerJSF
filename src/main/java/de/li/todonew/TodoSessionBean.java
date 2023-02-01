package de.li.todonew;

import de.li.login.Login;
import de.li.todolist.Todo;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;

@SuppressWarnings("CdiUnproxyableBeanTypesInspection")
@SessionScoped
public class TodoSessionBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private TodoEntityBean teBean;

    private int todoId;
    private String todoBeschreibung;

    public void addTodo(Login currentUser, String beschreibung) {
        Todo neueTodo = new Todo();
        neueTodo.setBeschreibung(beschreibung);
        neueTodo.setLogin(currentUser);
        teBean.addTodo(neueTodo);
    }

    public void deleteTodo(int id) {
        teBean.deleteTodo(teBean.getTodo(id));
    }

    public void updateTodo(int id, String beschreibung) {
        Todo updateTodo = teBean.getTodo(id);
        updateTodo.setBeschreibung(beschreibung);
        teBean.updateTodo(updateTodo);
    }

    public Todo getTodo(int id) {
        return teBean.getTodo(id);
    }

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
}
