package com.femialex.mapstructexample.repositories;

import com.femialex.mapstructexample.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
