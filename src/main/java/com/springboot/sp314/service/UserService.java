package com.springboot.sp314.service;


import com.springboot.sp314.model.User;

import java.util.List;

public interface UserService {

    public List<User> getAll();
    public void addUser(User user);
    public User getUser(int id);
    public void deleteUser(int id);
    public void updateUser(User user,int id);


}
