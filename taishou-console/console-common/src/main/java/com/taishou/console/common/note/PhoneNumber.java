package com.taishou.console.common.note;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/5/23-9:56
 * @Version:
 */
@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
public @interface PhoneNumber {
    String message() default "手机号码格式不正确！";
    Class[] groups() default {};
    Class[] payload() default {};
}



