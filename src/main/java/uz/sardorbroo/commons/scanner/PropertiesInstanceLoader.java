package uz.sardorbroo.commons.scanner;

import java.util.Map;
import java.util.Optional;

public interface PropertiesInstanceLoader {

    /**
     * Finds all instances(objects) of class which client gives.
     * Throws {@link IllegalArgumentException} if class parameter will be null.
     *
     * @param clazz
     * @return {@link Map<String, Object>}
     * @throws IllegalArgumentException
     */
    Map<String, Object> getInstance(Class<Object> clazz);

    /**
     * Finds the specific instance(object) of class which client gives.
     * Throws {@link IllegalArgumentException} if class parameter will be null.
     *
     * @param clazz
     * @param qualified (name)
     * @return {@link Optional<Object>}
     * @throws IllegalArgumentException
     */
    Optional<Object> getInstanceOrAny(Class<Object> clazz, String qualified);
}
