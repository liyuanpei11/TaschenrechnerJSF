package de.li.register;

import de.li.Pages;
import de.li.login.Login;
import de.li.login.LoginSessionBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("register")
@ApplicationScoped
public class registerCDIBean {

    @Inject
    private LoginSessionBean lBean;
    private String username;
    private String password1;
    private String password2;
    private String status;

    public String doRegister() {
        if (password1.equals(password2)) {
            if(lBean.getLogin(username) == null) {
                lBean.addLogin(new Login(username, password1));
            } else {
                status = "Dieser Username ist bereits vergeben!";
                return Pages.REGISTER.getPage();
            }
        } else {
            status = "Die Passwörter sind nicht identisch!";
            return Pages.REGISTER.getPage();
        }
        return Pages.LOGIN.getPage();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
