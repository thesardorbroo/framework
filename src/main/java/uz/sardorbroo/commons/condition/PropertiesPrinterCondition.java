package uz.sardorbroo.commons.condition;

import uz.sardorbroo.commons.constants.PropertiesConstants;

public class PropertiesPrinterCondition extends AbsBooleanCondition {

    @Override
    public String getKey() {
        return PropertiesConstants.PROPERTIES_PRINTER_ENABLED_KEY;
    }
}
