package by.minsk.ussr.baby.service;

import by.minsk.ussr.baby.error.EntityNotFoundException;
import by.minsk.ussr.baby.model.Pregnancy;
import by.minsk.ussr.baby.repository.PregnancyRepository;
import by.minsk.ussr.baby.service.context.UserContext;
import java.util.Collection;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
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
    public Pregnancy findById(int pregnancyId) {
        return pregnancyRepository.findById(pregnancyId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Collection<Pregnancy> findAll() {
        return pregnancyRepository.findByUserProfileId(userContext.userProfileId());
    }

    @Override
    public Pregnancy save(Pregnancy pregnancy) {
        pregnancy.setUserProfileId(userContext.userProfileId());
        return pregnancyRepository.save(pregnancy);
    }
}
