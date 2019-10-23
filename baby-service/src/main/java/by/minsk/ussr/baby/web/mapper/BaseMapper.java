package by.minsk.ussr.baby.web.mapper;

import java.util.Collection;
import java.util.List;

public interface BaseMapper<E, D> {
    E toEntity(D dto);
    D toDto(E entity);

    Collection<E> toEntities(Collection<D> dtos);
    Collection<D> toDtos(Collection<E> entities);
}
