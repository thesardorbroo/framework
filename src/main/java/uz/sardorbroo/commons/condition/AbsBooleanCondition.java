package uz.sardorbroo.commons.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Objects;

public abstract class AbsBooleanCondition implements Condition {

    public abstract String getKey();

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        String val = context.getEnvironment().getProperty(getKey());
        if (Objects.isNull(val)) {
            return false;
        }

        return Objects.equals(String.valueOf(Boolean.TRUE).toLowerCase(), val.toLowerCase());
    }
}
