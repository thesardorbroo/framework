package uz.sardorbroo.commons.printer.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.sardorbroo.commons.printer.Printer;
import uz.sardorbroo.commons.printer.enumeration.PrintType;

import java.util.Objects;

@Slf4j
@Service
public class SimpleLogPrinter implements Printer {

    @Override
    public void print(Object obj, PrintType type) {
        log(obj, type);
    }

    @Override
    public void print(String text, PrintType type) {
        log(text, type);
    }

    private void log(Object obj, PrintType type) {

        if (Objects.equals(PrintType.INFO, type)) {

            log.info("{}", obj);
        } else if (Objects.equals(PrintType.DEBUG, type)) {

            log.debug("{}", obj);
        } else if (Objects.equals(PrintType.TRACE, type)) {

            log.trace("{}", obj);
        }
    }
}
