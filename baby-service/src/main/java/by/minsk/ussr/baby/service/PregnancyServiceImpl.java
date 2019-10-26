package by.minsk.ussr.baby.service;

import by.minsk.ussr.baby.model.Pregnancy;
import by.minsk.ussr.baby.repository.PregnancyRepository;
import by.minsk.ussr.baby.service.context.UserContext;
import java.time.LocalDate;
import java.util.Collection;
import org.springframework.stereotype.Service;

@Service
public class PregnancyServiceImpl implements PregnancyService {

    private final PregnancyRepository pregnancyRepository;
    private final UserContext userContext;

    public PregnancyServiceImpl(PregnancyRepository pregnancyRepository, UserContext userContext) {
        this.pregnancyRepository = pregnancyRepository;
        this.userContext = userContext;
    }

    @Override
    public Pregnancy findActive() {
        return pregnancyRepository.findByUserProfileIdAndIsActiveTrue(userContext.userProfileId());
    }

    @Override
    public Collection<Pregnancy> findAll() {
        return pregnancyRepository.findByUserProfileId(userContext.userProfileId());
    }

    @Override
    public Pregnancy createNewPregnancy(int period) {
        Pregnancy pregnancy = new Pregnancy();
        pregnancy.setActive(true);
        pregnancy.setPregnancyDay(LocalDate.now().minusDays(period));
        pregnancy.setUserProfileId(userContext.userProfileId());

        return pregnancyRepository.save(pregnancy);
    }
}
