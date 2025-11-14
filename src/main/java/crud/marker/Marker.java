package crud.marker;

import java.lang.annotation.*;

@Inherited
@Target(value = { ElementType.TYPE })
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Marker {
}
