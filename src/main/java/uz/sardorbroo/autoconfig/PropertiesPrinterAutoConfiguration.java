package uz.sardorbroo.autoconfig;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import uz.sardorbroo.commons.condition.PropertiesPrinterCondition;
import uz.sardorbroo.commons.printer.Printer;
import uz.sardorbroo.commons.printer.PropertiesPrinter;
import uz.sardorbroo.commons.printer.impl.PropertiesPrinterImpl;
import uz.sardorbroo.commons.printer.impl.SimpleLogPrinter;
import uz.sardorbroo.commons.printer.properties.PrinterProperties;
import uz.sardorbroo.commons.runner.PropertiesPrinterRunner;
import uz.sardorbroo.commons.scanner.PropertiesInstanceLoader;
import uz.sardorbroo.commons.scanner.PropertiesScanner;
import uz.sardorbroo.commons.scanner.impl.ApplicationContextPropertiesInstanceLoader;
import uz.sardorbroo.commons.scanner.impl.PropertiesScannerImpl;
import uz.sardorbroo.commons.scanner.properties.ScannerProperties;

@AutoConfiguration
@Conditional(PropertiesPrinterCondition.class)
@EnableConfigurationProperties({ScannerProperties.class, PrinterProperties.class})
public class PropertiesPrinterAutoConfiguration {

    @Bean
    public Printer initPrinter() {
        return new SimpleLogPrinter();
    }

    @Bean
    public PropertiesScanner initScanner(ScannerProperties properties) {
        return new PropertiesScannerImpl(properties);
    }

    @Bean
    public PropertiesInstanceLoader initFinder(ApplicationContext context) {
        return new ApplicationContextPropertiesInstanceLoader(context);
    }

    @Bean
    public PropertiesPrinter initPropertiesPrinter(Printer printer, PropertiesScanner scanner, PrinterProperties properties, PropertiesInstanceLoader loader) {
        return new PropertiesPrinterImpl(printer, scanner, properties, loader);
    }

    // runner
    @Bean
    public PropertiesPrinterRunner initRunner(PropertiesPrinter printer) {
        return new PropertiesPrinterRunner(printer);
    }
}
