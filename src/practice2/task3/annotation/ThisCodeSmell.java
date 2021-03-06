package practice2.task3.annotation;


import java.lang.annotation.*;

/**
 * @ThisCodeSmells(reviewer=”Petya”) which could be attached everywhere and could be repeatable
 */
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(ThisCodeSmells.class)
public @interface ThisCodeSmell {
    String reviewer();
}