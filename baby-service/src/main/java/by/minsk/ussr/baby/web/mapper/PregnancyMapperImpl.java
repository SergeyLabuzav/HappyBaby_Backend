package by.minsk.ussr.baby.web.mapper;

import by.minsk.ussr.baby.model.Pregnancy;
import by.minsk.ussr.baby.web.dto.PregnancyDto;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class PregnancyMapperImpl implements PregnancyMapper {
    @Override
    public Pregnancy toEntity(PregnancyDto dto) {
        if (dto == null) {
            return null;
        }
        Pregnancy entity = new Pregnancy();
        entity.setId(dto.getId());
        entity.setPeriod(dto.getPeriod());
        entity.setActive(dto.isActive());

        return entity;
    }

    @Override
    public PregnancyDto toDto(Pregnancy entity) {
        if (entity == null) {
            return null;
        }
        PregnancyDto dto = new PregnancyDto();
        dto.setId(entity.getId());
        dto.setPeriod(entity.getPeriod());
        dto.setActive(entity.isActive());

        return dto;
    }

    @Override
    public Collection<Pregnancy> toEntities(Collection<PregnancyDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    @Override
    public Collection<PregnancyDto> toDtos(Collection<Pregnancy> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
