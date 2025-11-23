
package uz.sardorbroo.commons.scanner.impl;

import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import uz.sardorbroo.commons.scanner.PropertiesScanner;
import uz.sardorbroo.commons.scanner.properties.ScannerProperties;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PropertiesScannerImpl implements PropertiesScanner {

    private final Reflections reflections;
    private final ScannerProperties properties;

    public PropertiesScannerImpl(ScannerProperties properties) {
        this.properties = properties;
        this.reflections = new Reflections(properties.getBase());
    }

    @Override
    public List<Class<Object>> scan() {
        log.debug("Started scanning properties class");

        List<Class<Object>> classes = reflections.get(
                        Scanners.TypesAnnotated.with(Configuration.class, ConfigurationProperties.class).asClass()
                )
                .stream()
                .filter(c -> !properties.isSuitableForExcluded(c.getName()))
                .map(c -> (Class<Object>) c)
                .collect(Collectors.toList());

        log.debug("Classes have scanned. Scanned classes count: {}", classes.size());
        return classes;
    }
}
