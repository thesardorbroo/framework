package crud.serviceable.dto;

import crud.marker.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class AnimalDto implements Dto<Long> {

    private Long id;

    private String name;

    private String type;

    private String gender;
}
