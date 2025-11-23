package crud.serviceable.impl;

import uz.sardorbroo.crud.impl.AbsService;
import uz.sardorbroo.crud.marker.Mapper;
import uz.sardorbroo.crud.marker.Repository;
import crud.serviceable.AnimalService;
import crud.serviceable.domain.Animal;
import crud.serviceable.dto.AnimalDto;

public class AnimalServiceImpl extends AbsService<Long, AnimalDto, Animal> implements AnimalService {

    @Override
    public <M extends Mapper<Long, AnimalDto, Animal>> M getMapper() {
        return null;
    }

    @Override
    public <R extends Repository<Long, Animal>> R getRepository() {
        return null;
    }
}
