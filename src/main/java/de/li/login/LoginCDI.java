package de.li.login;

import de.li.Pages;
import de.li.todolist.TodoBean;
import de.li.todolist.TodoCDI;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("login")
@SessionScoped
public class LoginCDI implements Serializable {

    @SuppressWarnings("CdiUnproxyableBeanTypesInspection")
    @Inject
    private LoginSessionBean lBean;

    @SuppressWarnings("CdiUnproxyableBeanTypesInspection")
    @Inject
    TodoBean tBean;
    @Inject
    private TodoCDI tCDI;
    private String username;
    private String password;
    private boolean result;
    private String status;
    private static final long serialVersionUID = 1L;

    public String doLogin() {
        if (lBean.getLogin(username) == null) {
          status = "User existiert nicht";
            return Pages.LOGIN.getPage();
        } else if (lBean.checkLogin(username, password)) {
            tCDI.setTodoList(tBean.getTodoList(lBean.getLogin(username)));
            return Pages.USERPAGE.getPage();
        } else {
            status = "Falsche Login-Daten";
            return Pages.LOGIN.getPage();
        }
    }

    public Login getLogin() {
        return lBean.getLogin(username);
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

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
