package uz.sardorbroo.commons.printer;

import uz.sardorbroo.commons.printer.enumeration.PrintType;

public interface Printer {

    void print(Object obj, PrintType type);

    void print(String text, PrintType type);
}
