package by.minsk.ussr.auth.repository;

import by.minsk.ussr.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String name);
    Optional<User> findOneByEmailIgnoreCase(String email);
}
