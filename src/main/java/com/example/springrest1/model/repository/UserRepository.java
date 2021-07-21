package com.example.springrest1.model.repository;

import com.example.springrest1.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
