package com.zkl.taishou.common.note;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/5/23-9:57
 * @Version:
 */
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber,String> {

    @Override
    public boolean isValid(String phoneField, ConstraintValidatorContext context) {
        if (phoneField == null) {
            // can be null
            return true;
        }
        return phoneField.matches("^1[3-9][0-9]\\d{8}$") && phoneField.length() > 8 && phoneField.length() < 14;
    }

    @Override
    public void initialize(PhoneNumber phoneNumber) {

    }
}
