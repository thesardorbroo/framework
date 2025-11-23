package uz.sardorbroo.commons.scanner.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import uz.sardorbroo.commons.constants.PropertiesConstants;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Configuration
@ConfigurationProperties(PropertiesConstants.SCANNER)
public class ScannerProperties {

    private String base;

    private boolean enabled;

    private Set<Filter> included = new HashSet<>();

    private Set<Filter> excluded = new HashSet<>();

    public boolean isSuitableForIncluded(String name) {

        return getIncluded().stream().anyMatch(f -> f.suitable(name));
    }

    public boolean isSuitableForExcluded(String name) {

        return getExcluded().stream().anyMatch(f -> f.suitable(name));
    }

    public void setIncluded(Set<String> included) {

        if (Objects.isNull(included)) {
            return;
        }

        this.included = included.stream()
                .map(Filter::of)
                .collect(Collectors.toSet());
    }

    public void setExcluded(Set<String> excluded) {

        if (Objects.isNull(excluded)) {
            return;
        }

        this.excluded = excluded.stream()
                .map(Filter::of)
                .collect(Collectors.toSet());
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Accessors(chain = true)
    public static class Filter {

        private static final String DELIMITER = ":";

        private String name;

        private FilterType type;

        public boolean suitable(String source) {

            if (StringUtils.isBlank(source)) {
                return false;
            }

            if (Objects.equals(FilterType.EQUALS, this.getType())) {

                return Objects.equals(source, this.getName());
            } else if (Objects.equals(FilterType.CONTAINS, this.getType())) {

                return source.contains(this.getName());
            } else if (Objects.equals(FilterType.NOT_CONTAINS, this.getType())) {

                return !source.contains(this.getName());
            } else if (Objects.equals(FilterType.PATTERN, this.getType())) {

                return source.matches(this.getName());
            } else if (Objects.equals(FilterType.STARTS_WITH, this.getType())) {

                return source.startsWith(this.getName());
            } else if (Objects.equals(FilterType.ENDS_WITH, this.getType())) {

                return source.endsWith(this.getName());
            }

            return false;
        }

        public static Filter of(String name) {
            return of(name, DELIMITER);
        }

        public static Filter of(String line, String delimiter) {

            if (StringUtils.isBlank(line) || StringUtils.isBlank(delimiter)) {
                return null;
            }

            String[] arr = line.split(delimiter);
            if (arr.length < 2) {
                return null;
            }

            FilterType type = FilterType.of(arr[0]);
            return new Filter()
                    .setName(arr[1])
                    .setType(type);
        }
    }

    public enum FilterType {
        EQUALS,
        PATTERN,
        CONTAINS,
        NOT_CONTAINS,
        ENDS_WITH,
        STARTS_WITH,
        ;

        public static FilterType of(String typeAsString) {

            if (StringUtils.isBlank(typeAsString)) {
                return null;
            }

            typeAsString = typeAsString.replace("-", "_").toUpperCase();
            return FilterType.valueOf(typeAsString);
        }
    }
}
