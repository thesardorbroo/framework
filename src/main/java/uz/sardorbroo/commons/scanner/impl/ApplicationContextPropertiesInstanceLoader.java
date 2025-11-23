package uz.sardorbroo.commons.scanner.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import uz.sardorbroo.commons.scanner.PropertiesInstanceLoader;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApplicationContextPropertiesInstanceLoader implements PropertiesInstanceLoader {

    private final ApplicationContext context;

    @Override
    public Map<String, Object> getInstance(Class<Object> clazz) {
        log.debug("Find all instances of given class. Class: {}", clazz);

        Objects.requireNonNull(clazz, "Invalid argument has passed! Class must not be null!");

        Map<String, Object> instances = context.getBeansOfType(clazz);
        log.debug("All instances have found. Instances count: {}", instances.size());
        return instances;
    }

    @Override
    public Optional<Object> getInstanceOrAny(Class<Object> clazz, String qualified) {
        log.debug("Find the specific instance of given class. Class: {} | Qualified name: {}", clazz, qualified);

        Map<String, Object> instances = getInstance(clazz);
        Object instance = instances.get(qualified);

        if (Objects.isNull(instance)) {
            // log.warn("Qualified object of class has not found!");
            log.debug("Returns any object of class");

            return instances.values()
                    .stream()
                    .findAny();
        }

        log.debug("Qualified object of class has found. Object: {}", instance);
        return Optional.of(instance);
    }
}
