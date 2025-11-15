package commons.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Timed {

    private Long value = 1L;

    private ChronoUnit unit = ChronoUnit.MILLIS;

    public Duration getAsDuration() {
        return Duration.of(value, unit);
    }

    public Instant plus(Instant date) {
        return date.plus(getAsDuration());
    }

    public Instant minus(Instant date) {
        return date.minus(getAsDuration());
    }
}
