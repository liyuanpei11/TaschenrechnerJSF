package de.li.todolist;

import de.li.login.Login;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@LocalBean
public class TodoBean {

    @PersistenceContext
    private EntityManager em;

    public void addTodo(Login currentUser, String beschreibung) {
        Todo neueTodo = new Todo();
        neueTodo.setBeschreibung(beschreibung);
        neueTodo.setLogin(currentUser);
        em.persist(neueTodo);
    }

    public void deleteTodo(int id) {
            em.remove(em.find(Todo.class, id));
    }

    public List<Todo> getTodoList(Login currentLogin){
        return currentLogin.getTodoList();
    }

    public void updateTodo(int id, String neueBeschreibung) {
        Todo oldTodo = em.find(Todo.class, id);
        oldTodo.setBeschreibung(neueBeschreibung);
        em.merge(oldTodo);
    }

    public Todo getTodo(int id) {
        return em.find(Todo.class, id);
    }
}
