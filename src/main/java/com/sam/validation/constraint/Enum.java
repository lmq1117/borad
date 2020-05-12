package com.sam.validation.constraint;


import com.sam.validation.constraint.validator.EnumValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE,ElementType.CONSTRUCTOR,ElementType.PARAMETER,ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Enum.List.class)
@Constraint(validatedBy = {EnumValidator.class})
public @interface Enum {
    String message() default "*{*.validation.constraint.Enum.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * the enum's class-type
     * @return Class
     */
    Class<?> clazz();


    String method() default "ordinal";


    @Documented
    @Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE,ElementType.CONSTRUCTOR,ElementType.PARAMETER,ElementType.TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List{
        Enum[] value();
    }

}
