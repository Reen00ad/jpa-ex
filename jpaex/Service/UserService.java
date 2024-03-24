package com.example.jpaex.Service;

import com.example.jpaex.Model.User;
import com.example.jpaex.Repositry.UserRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepositry userRepositry;


    public List<User> getUser(){
        return userRepositry.findAll();
    }

    public void addUser(User user){
        userRepositry.save(user);
    }

    public Boolean updateUser(Integer id,User user) {
        User u = userRepositry.getById(id);
        if (u == null) {
            return false;
        }

        u.setUsername(user.getUsername());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setRole(user.getRole());
        u.setBalance(user.getBalance());

        userRepositry.save(u);

        return true;
    }

    public Boolean deleteUser(Integer id){
        User u=userRepositry.getById(id);
        if(u==null){
            return false;
        }
        userRepositry.delete(u);


        return true;
    }


}
