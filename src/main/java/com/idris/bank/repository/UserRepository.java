package com.idris.bank.repository;

import com.idris.bank.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public interface UserRepository extends JpaRepository<Users, Long>{

    Optional<Users> findByEmail(String email);
}
