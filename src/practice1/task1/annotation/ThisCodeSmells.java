package practice1.task1.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

/**
 * @ThisCodeSmells(reviewer=”Petya”) which could be attached everywhere and could be repeatable
 */
@Repeatable(ThisCodeSmell.class)
public @interface ThisCodeSmells {
    String reviewer();
}

@interface ThisCodeSmell {
    ThisCodeSmells[] value();
}
