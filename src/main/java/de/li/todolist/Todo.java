package de.li.todolist;

import de.li.login.Login;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@NamedQuery(name= Todo.findAll, query = "SELECT t FROM Todo t")
public class Todo implements Serializable {

    public static final String findAll = "Todo.findAll";
    @GeneratedValue
    @Id
    private Integer id;

    @NotNull
    @Size(min = 1, max = 100)
    private String beschreibung;

    @ManyToOne
    private Login login;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
