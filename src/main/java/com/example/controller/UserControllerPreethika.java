package com.example.controller;

import com.example.entity.UserEntityPreethika;
import com.example.service.UserServicePreethika;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/user/test")
@RestController
@Slf4j
public class UserControllerPreethika {

    @Autowired
    private UserServicePreethika userServicePreethika;

    @PostMapping("/createuser")
    public ResponseEntity<?> addUserPreethika(@RequestBody UserEntityPreethika user)
    {
        try
        {
            UserEntityPreethika savedUser = userServicePreethika.addUserPreethika(user);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e)
        {
            return ResponseEntity.badRequest().body("Failed to add user :"+e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntityPreethika> getUserByIdPreethika(@PathVariable int id)
    {
        try
        {
            UserEntityPreethika user = userServicePreethika.getUserByIdPreethika(id);
            return ResponseEntity.ok(user);
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

}
