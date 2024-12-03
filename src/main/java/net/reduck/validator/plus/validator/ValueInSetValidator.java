package net.reduck.validator.plus.validator;

import net.reduck.validator.plus.validator.anatation.ValueInSet;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValueInSetValidator implements ConstraintValidator<ValueInSet, String> {

    private Set<String> validValues;  // 存储有效的值集合

    @Override
    public void initialize(ValueInSet constraintAnnotation) {
        // 获取注解中的有效值数组，并将其转换为 Set 集合
        validValues = new HashSet<>(Arrays.asList(constraintAnnotation.values()));
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 校验 value 是否在 validValues 集合中
        if (value == null) {
            return true;  // 如果为 null，可以根据需要修改为不允许为 null
        }
        return validValues.contains(value);
    }
}
