package de.li.login;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class LoginSessionBean {

    @PersistenceContext
    private EntityManager em;

    public List<Login> getAllLogins() {
        TypedQuery<Login> query = em.createNamedQuery(Login.findAll, Login.class);
        return query.getResultList();
    }

    public Login getLogin(String username) {
        return em.find(Login.class, username);
    }

    public void addLogin(Login newLogin) {
        em.persist(newLogin);
    }

    public void deleteLogin(Login toDeleteLogin) {
        Login exisitLogin = getLogin(toDeleteLogin.getUsername());
        em.remove(exisitLogin);
    }

    public boolean checkLogin(String username, String pwd) {
        try {
            Login currentLogin = getLogin(username);
            if (currentLogin != null)
                return pwd.equals(currentLogin.getPassword());
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
