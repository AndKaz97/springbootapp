package de.teclead.springbootapp.repository;

import de.teclead.springbootapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByFirstNameIgnoreCase(String firstName);
    User findById(UUID id);
}
