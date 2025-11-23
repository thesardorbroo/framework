package crud.serviceable.mapper;

import uz.sardorbroo.crud.marker.Mapper;
import crud.serviceable.domain.Animal;
import crud.serviceable.dto.AnimalDto;

public interface AnimalMapper extends Mapper<Long, AnimalDto, Animal> {
}
