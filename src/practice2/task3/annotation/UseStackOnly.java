package practice2.task3.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @UseStackOnly which could be attached to fields and couldn’t be accessed in Runtime.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.CLASS)
public @interface UseStackOnly {}
