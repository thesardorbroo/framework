package crud.serviceable.mapper;

import crud.marker.Mapper;
import crud.serviceable.domain.Animal;
import crud.serviceable.dto.AnimalDto;

public interface AnimalMapper extends Mapper<Long, AnimalDto, Animal> {
}
