package by.minsk.ussr.baby.repository;

import by.minsk.ussr.baby.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByUserProfileId(Integer userProfileId);
}
