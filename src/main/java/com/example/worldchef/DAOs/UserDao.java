package com.example.worldchef.DAOs;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.worldchef.Models.User;

import java.util.List;

@Dao
public interface UserDao {

    //Grab the user by username
    @Query("SELECT * FROM USER WHERE username = :username")
    User getUserByUsername(String username);

    @Insert (onConflict = OnConflictStrategy.ABORT)
    public void insertUser (User user);

    //Grab list of all the users
    @Query("SELECT * FROM USER")
    List<User> getAllUsers();

    //Search if username exists already
    @Query("SELECT username FROM USER")
    List<String> getUsernames();



}
