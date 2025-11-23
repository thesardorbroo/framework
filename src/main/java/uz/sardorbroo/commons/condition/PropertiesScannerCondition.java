package uz.sardorbroo.commons.condition;

import uz.sardorbroo.commons.constants.PropertiesConstants;

public class PropertiesScannerCondition extends AbsBooleanCondition {

    @Override
    public String getKey() {
        return PropertiesConstants.SCANNER_ENABLED_KEY;
    }
}
