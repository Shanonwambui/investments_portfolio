package com.example.portfolio5.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.portfolio5.entities.User;

import java.util.UUID;

@Repository

public interface UserRepository extends JpaRepository<User, UUID>{

}
