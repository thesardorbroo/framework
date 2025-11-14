package crud.serviceable;

import crud.serviceable.dto.AnimalDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AnimalService {

    List<AnimalDto> getAll();

    Page<AnimalDto> getAll(Pageable pageable);

    Optional<AnimalDto> getById(Long id);

    Optional<AnimalDto> save(AnimalDto dto);

    Optional<AnimalDto> update(AnimalDto dto);

    Optional<AnimalDto> deleteById(Long id);
}
