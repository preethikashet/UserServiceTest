package com.example.dao;

import com.example.entity.UserEntityPreethika;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAOPreethika extends JpaRepository<UserEntityPreethika,Integer> {
}
