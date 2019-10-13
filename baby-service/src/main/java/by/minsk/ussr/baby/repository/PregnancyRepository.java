package by.minsk.ussr.baby.repository;

import by.minsk.ussr.baby.model.Pregnancy;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PregnancyRepository extends JpaRepository<Pregnancy, Integer> {
    Pregnancy findByUserProfileIdAndIsActiveTrue(int userProfileId);

    List<Pregnancy> findByUserProfileId(Integer userProfileId);
}
