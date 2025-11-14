package crud;

import crud.marker.Mapper;
import crud.marker.Repository;
import crud.marker.Dto;
import crud.marker.Entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface Serviceable<I, D extends Dto<I>, E extends Entity<I>> {

    <M extends Mapper<I, D, E>> M getMapper();

    <R extends Repository<I, E>> R getRepository();

    List<D> getAll();

    Page<D> getAll(Pageable pageable);

    Optional<D> getById(I id);

    Optional<D> save(D dto);

    Optional<D> update(D dto);

    Optional<D> deleteById(I id);
}
