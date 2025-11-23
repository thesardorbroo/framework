package uz.sardorbroo.commons.runner;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import uz.sardorbroo.commons.printer.PropertiesPrinter;

@Service
@RequiredArgsConstructor
public class PropertiesPrinterRunner implements CommandLineRunner {

    private final PropertiesPrinter printer;

    @Override
    public void run(String... args) {
        printer.print();
    }
}
