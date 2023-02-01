package de.li.login;

import de.li.todolist.Todo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQuery(name= Login.findAll, query = "SELECT l FROM Login l")
public class Login implements Serializable {

    public static final String findAll = "Login.findAll";
    @Id
    private String username;
    private String password;
    @OneToMany(mappedBy = "login", fetch = FetchType.EAGER)
    private List<Todo> todoList;
    private static final long serialVersionUID = 1L;

    public Login(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public Login() {
    }

    public List<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
