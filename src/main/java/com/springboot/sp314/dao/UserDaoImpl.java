package com.springboot.sp314.dao;

import com.springboot.sp314.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> getall() {
        return entityManager.createQuery("from User", User.class)
                .getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public void deleteUser(long id) {
        entityManager.remove(getUser(id));
    }

    @Override
    public void updateUser(User us, long id) {
        User user = getUser(id);
        user.setName(us.getName());
        user.setLastname(us.getLastname());
        user.setAge(us.getAge());
        user.setEmail(us.getEmail());
        user.setRole(us.getRole());
        user.setGender(us.getGender());
        entityManager.persist(user);
    }
}
