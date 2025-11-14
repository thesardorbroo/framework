package crud.impl;

import crud.Serviceable;
import crud.marker.Mapper;
import crud.marker.Repository;
import crud.marker.Dto;
import crud.marker.Entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class AbsService<I, D extends Dto<I>, E extends Entity<I>> implements Serviceable<I, D, E> {

    abstract public <M extends Mapper<I, D, E>> M getMapper();

    abstract public <R extends Repository<I, E>> R getRepository();

    @Transactional
    public Optional<D> save(D dto) {
        // log.info("Save new data. DTO: {}", dto);

        if (Objects.isNull(dto)) {
            // log.warn("Invalid argument is passed! DTO must not be null! DTO: {}", dto);
            return Optional.empty();
        }

        E entity = getMapper().toEntity(dto);
        getRepository().save(entity);

        // log.info("Data has saved successfully. DTO: {}", entity);
        return Optional.of(getMapper().toDto(entity));
    }

    @Transactional
    public Optional<D> update(D dto) {
        // log.info("Update data. DTO: {}", dto);

        if (Objects.isNull(dto)) {
            // log.warn("Invalid argument is passed! DTO must not be null! DTO: {}", dto);
            return Optional.empty();
        }

        Optional<D> oldDtoOptional = getById(null /* call getId() method of dto object */);
        if (oldDtoOptional.isEmpty()) {
            // log.warn("Invalid argument is passed! Updated data is not found in DB!");
            return Optional.empty();
        }

        E entity = getMapper().toEntity(dto);
        getRepository().save(entity);

        // log.info("Data has updated successfully. DTO: {}", entity);
        return Optional.of(getMapper().toDto(entity));
    }

    @Transactional
    public Optional<D> deleteById(I id) {
        // log.info("Delete data by ID. ID: {}", id);

        Optional<D> dtoOptional = getById(id);
        if (dtoOptional.isEmpty()) {
            // log.warn("Delete data not worked! Data is not found by ID! ID: {}", id);
            return Optional.empty();
        }

        getRepository().deleteById(id);
        // log.info("Data has deleted successfully! ID: {}", id);
        return dtoOptional;
    }

    @Transactional
    public Optional<D> getById(I id) {
        // log.info("Get by ID. ID: {}", id);

        if (Objects.isNull(id)) {
            // log.warn("Invalid argument is passed! ID must not be null!");
            return Optional.empty();
        }

        Optional<D> dtoOptional = getRepository()
                .findById(id).map(getMapper()::toDto);

        // log.info("Is data found by ID? Result: {}", dtoOptional.isPresent());
        return dtoOptional;
    }

    @Transactional
    public List<D> getAll() {
        // log.info("Get all data without pagination");

        List<D> dtos = getRepository().findAll()
                .stream()
                .map(getMapper()::toDto)
                .toList();

        // log.info("All data are fetched successfully. DTOs count: {}", dtos.size());
        return dtos;
    }

    @Transactional
    public Page<D> getAll(Pageable pageable) {
        // log.info("Get all data with pagination");

        if (Objects.isNull(pageable)) {
            // log.warn("Invalid argument is passed! Pageable must not be null!");
            return Page.empty();
        }

        Page<D> dtos = getRepository()
                .findAll(pageable).map(getMapper()::toDto);
        // log.info("All data are fetched successfully by pagination. DTOs count: {}", dtos.getTotalElements());
        return dtos;
    }
}
