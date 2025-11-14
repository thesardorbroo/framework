package crud.marker;

import java.util.Collection;
import java.util.List;

public interface Mapper<I, D extends Dto<I>, E extends Entity<I>> {

    D toDto(E entity);

    List<D> toDto(Collection<E> entities);

    E toEntity(D dto);

    List<E> toEntity(Collection<D> dtos);
}
