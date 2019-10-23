package by.minsk.ussr.baby.web.facade;

import by.minsk.ussr.baby.error.NewEntityIdEnableException;
import by.minsk.ussr.baby.error.IdMustNotBeNullException;
import by.minsk.ussr.baby.model.Pregnancy;
import by.minsk.ussr.baby.service.PregnancyService;
import by.minsk.ussr.baby.web.dto.PregnancyDto;
import by.minsk.ussr.baby.web.mapper.PregnancyMapper;
import java.util.Collection;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PregnancyFacade {
    private final PregnancyService pregnancyService;
    private final PregnancyMapper pregnancyMapper;

    public PregnancyFacade(PregnancyService pregnancyService, PregnancyMapper pregnancyMapper) {
        this.pregnancyService = pregnancyService;
        this.pregnancyMapper = pregnancyMapper;
    }

    public PregnancyDto findActive() {
        return pregnancyMapper.toDto(pregnancyService.findActive());
    }

    public Collection<PregnancyDto> allPregnancies() {
        return pregnancyMapper.toDtos(pregnancyService.findAll());
    }

    public PregnancyDto createPregnancy(PregnancyDto dto) {
        if (dto.getId() == null) {
            throw new NewEntityIdEnableException();
        }
        Pregnancy pregnancy = pregnancyService.save(pregnancyMapper.toEntity(dto));
        return pregnancyMapper.toDto(pregnancy);
    }
}
