package de.li.todolist;

import de.li.Pages;
import de.li.login.LoginCDI;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("todo")
@SessionScoped
public class TodoCDI implements Serializable {

    private static final long serialVersionUID = 1L;
    private int currentTodoId;
    private String currentTodoBeschreibung;

    @SuppressWarnings("CdiUnproxyableBeanTypesInspection")
    @Inject
    private TodoBean tBean;
    @Inject
    private LoginCDI loginCDI;
    private List<Todo> todoList;



    public List<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }

    public String doEdit(int id) {
        System.out.println("Hello");
        currentTodoId = id;
        currentTodoBeschreibung = tBean.getTodo(id).getBeschreibung();
        return Pages.EDITTODO.getPage();
    }

    public int getCurrentTodoId() {
        return currentTodoId;
    }

    public void setCurrentTodoId(int currentTodoId) {
        this.currentTodoId = currentTodoId;
    }

    public String doDelete(int id) {
        tBean.deleteTodo(id);
        return updateDataTable();
    }

    public String updateDataTable() {
        setTodoList(tBean.getTodoList(loginCDI.getLogin()));
        return Pages.USERPAGE.getPage();
    }

    public String getCurrentTodoBeschreibung() {
        return currentTodoBeschreibung;
    }

    public void setCurrentTodoBeschreibung(String currentTodoBeschreibung) {
        this.currentTodoBeschreibung = currentTodoBeschreibung;
    }

    public String updateTodo() {
        tBean.updateTodo(currentTodoId, currentTodoBeschreibung);
        return updateDataTable();
    }

    public String addTodo() {
        tBean.addTodo(loginCDI.getLogin(), currentTodoBeschreibung);
        currentTodoBeschreibung = "";
        return updateDataTable();
    }
}
