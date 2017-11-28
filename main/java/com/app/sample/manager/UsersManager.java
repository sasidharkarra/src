package com.app.sample.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.sample.models.Users;
import com.app.sample.rsa.postgres.UsersRepository;

@Component
public class UsersManager {

	@Autowired
    private UsersRepository usersRepository;


    public List<Users> getAllUserDetails(){
        return usersRepository.findAll();
    }

    public Users saveUsers(Users users){
        users.setStatus("Active");
        return usersRepository.save(users);
    }

    public Users updateUser(Long id, Users user) {
        Users users = usersRepository.findOne(id);
        users.setStatus("InActive");
        users.setBirthDate(user.getBirthDate());
        users.setPinCode(user.getPinCode());
        users = usersRepository.save(users);
        return users;
    }

    public Long deleteUser(Long id) {
        Users users = usersRepository.findOne(id);
        users.setStatus("InActive");
        users = usersRepository.save(users);
        return users.getId();
    }

}
