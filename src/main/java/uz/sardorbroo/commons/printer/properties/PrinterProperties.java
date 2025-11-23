package uz.sardorbroo.commons.printer.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import uz.sardorbroo.commons.constants.PropertiesConstants;
import uz.sardorbroo.commons.printer.enumeration.PrintType;

@Data
@Configuration
@ConfigurationProperties(PropertiesConstants.PROPERTIES_PRINTER)
public class PrinterProperties {

    private boolean enabled;

    private PrintType type;

    public void setType(String type) {

        this.type = PrintType.valueOf(type.toUpperCase());
    }
}
