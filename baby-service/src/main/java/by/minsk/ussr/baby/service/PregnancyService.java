package by.minsk.ussr.baby.service;

import by.minsk.ussr.baby.model.Pregnancy;
import java.util.Collection;

public interface PregnancyService {
    Pregnancy findActive();

    Collection<Pregnancy> findAll();

    Pregnancy createNewPregnancy(int period);
}
