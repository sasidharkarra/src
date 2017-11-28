package com.app.sample.controllers;

import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.sample.manager.UsersManager;
import com.app.sample.models.Users;

@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    UsersManager usersManager;

    @ApiOperation(value = "Add users info", response = ResponseEntity.class)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Users> addUser(@RequestBody Users user) {
        return new ResponseEntity<>(usersManager.saveUsers(user),
                HttpStatus.CREATED);
    }

    @ApiOperation(value = "fetch all users from Database", response = ResponseEntity.class)
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Users>> getAllUsers() {
        return new ResponseEntity<>(usersManager.getAllUserDetails(),
                HttpStatus.OK);
    }

    @ApiOperation(value = "update users info", response = ResponseEntity.class)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Users> updateUser(@RequestBody Users user, @PathVariable Long id) {
        return new ResponseEntity<>(usersManager.updateUser(id,user),
                HttpStatus.CREATED);
    }

    @ApiOperation(value = "Delete user based on id")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Long> deleteUser(@PathVariable Long id) {
        Long deletedId = usersManager.deleteUser(id);
        return new ResponseEntity<>(deletedId,HttpStatus.OK);
    }
}
