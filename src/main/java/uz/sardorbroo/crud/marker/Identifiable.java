package uz.sardorbroo.crud.marker;

/**
 * Indicates that the class has field that identifies
 */
@Marker
public interface Identifiable<I> {

    I getId();

    void setId(I id);
}
