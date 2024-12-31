package com.example.AtomicaServer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.AtomicaServer.models.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

}
