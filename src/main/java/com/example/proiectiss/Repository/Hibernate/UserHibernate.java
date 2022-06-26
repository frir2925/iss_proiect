package com.example.proiectiss.Repository.Hibernate;/*
package com.example.proiectiss.Repository.Hibernate;
import com.example.proiectiss.Domain.User;
import com.example.proiectiss.Repository.JdbcUtils;
import com.example.proiectiss.Repository.RepoUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.Properties;

public class UserHibernate implements RepoUser {
    private JdbcUtils dbUtils;
    private SessionFactory sessionFactory;

    public UserHibernate(Properties props, SessionFactory sessionFactory){
        dbUtils = new JdbcUtils(props);
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User findOneByUsername(String username){
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            User user = session.createQuery("from User where username = :username", User.class)
                    .setParameter("username", username)
                    .setMaxResults(1).uniqueResult();
            transaction.commit();
            return user;
        } catch (RuntimeException e){
            if (transaction != null)
                transaction.rollback();
            return null;
        }

    }



    @Override
    public User findOne(Long id) {
        return null;
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public void save(User entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Long id, User entity) {

    }


}


 */