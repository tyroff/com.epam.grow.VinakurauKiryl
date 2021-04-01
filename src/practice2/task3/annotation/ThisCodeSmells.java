package practice2.task3.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ThisCodeSmells {
    ThisCodeSmell[] value();
}
