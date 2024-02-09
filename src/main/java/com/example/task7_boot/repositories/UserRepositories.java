package com.example.task7_boot.repositories;

import com.example.task7_boot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends JpaRepository<User,Integer> {
}