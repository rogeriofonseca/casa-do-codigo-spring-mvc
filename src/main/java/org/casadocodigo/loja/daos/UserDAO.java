package org.casadocodigo.loja.daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.casadocodigo.loja.models.SystemUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO implements UserDetailsService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Tentando logar com "+username);
        String jpql = "select u from SystemUser u where u.login = :login";
        List<SystemUser> users = em.createQuery(jpql, SystemUser.class)
                .setParameter("login", username).getResultList();

        if (users.isEmpty()) {
            throw new UsernameNotFoundException("O usuario " + username + "não existe");
        }
        return users.get(0);
    }
}
