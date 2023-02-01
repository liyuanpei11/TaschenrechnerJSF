package de.li.todonew;

import de.li.todolist.Todo;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class TodoEntityBean {

    @PersistenceContext
    private EntityManager em;

    public void addTodo(Todo neueTodo) {
        em.persist(neueTodo);
    }

    public void deleteTodo(Todo loeschenTodo) {
        em.remove(loeschenTodo);
    }

    public void updateTodo(Todo aktualisierteTodo) {
        em.merge(aktualisierteTodo);
    }

    public Todo getTodo(int id) {
        return em.find(Todo.class, id);
    }
}
