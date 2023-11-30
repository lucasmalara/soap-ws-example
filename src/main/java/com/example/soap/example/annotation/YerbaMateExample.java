package com.example.soap.example.annotation;

import com.example.soap.example.schema.YerbaMate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 *     Use this annotation wisely
 *     - that means annotate method iff it returns instance of {@link YerbaMate} with correctly set field values.
 * </p>
 * @see com.example.soap.example.utils.YerbaMateExampleValidator
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface YerbaMateExample {
}
