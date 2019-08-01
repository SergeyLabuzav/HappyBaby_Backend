package by.minsk.ussr.auth.repository;

import by.minsk.ussr.auth.model.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findOneByName(String name);
}
