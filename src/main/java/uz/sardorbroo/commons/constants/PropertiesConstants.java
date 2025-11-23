package uz.sardorbroo.commons.constants;

public class PropertiesConstants {

    private static final String BASE_PREFIX = "";

    public static final String SCANNER = BASE_PREFIX + "scanner";

    public static final String SCANNER_ENABLED_KEY = join(SCANNER, "enabled");

    public static final String PROPERTIES_PRINTER = BASE_PREFIX + "printer";

    public static final String PROPERTIES_PRINTER_ENABLED_KEY = join(PROPERTIES_PRINTER, "enabled");

    private static String join(String... strings) {
        return String.join(".", strings);
    }
}
