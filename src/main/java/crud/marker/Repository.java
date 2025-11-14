package crud.marker;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface Repository<I, E extends Entity<I>> {

    List<E> findAll();

    Page<E> findAll(Pageable pageable);

    Optional<E> findById(I id);

    Optional<E> save(E entity);

    Optional<E> deleteById(I id);
}
