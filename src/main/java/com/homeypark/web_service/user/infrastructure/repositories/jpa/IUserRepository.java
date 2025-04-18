package com.homeypark.web_service.user.infrastructure.repositories.jpa;

import com.homeypark.web_service.user.domain.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    List<User> findByEmailAndPassword(String email, String password);
}
