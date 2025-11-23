package uz.sardorbroo.commons.printer.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.sardorbroo.commons.printer.Printer;
import uz.sardorbroo.commons.printer.PropertiesPrinter;
import uz.sardorbroo.commons.printer.properties.PrinterProperties;
import uz.sardorbroo.commons.scanner.PropertiesInstanceLoader;
import uz.sardorbroo.commons.scanner.PropertiesScanner;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PropertiesPrinterImpl implements PropertiesPrinter {

    private final Printer printer;

    private final PropertiesScanner scanner;

    private final PrinterProperties properties;

    private final PropertiesInstanceLoader loader;

    @Override
    public void print() {
        log.debug("Print all properties...");

        scanner.scan()
                .stream()
                .map(c -> loader.getInstanceOrAny(c, null))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(b -> printer.print(b, properties.getType()));
    }
}
