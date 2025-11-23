package crud.serviceable.domain;

import uz.sardorbroo.crud.marker.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Animal implements Entity<Long> {

    private Long id;

    private String name;

    private String type;

    private String gender;
}
