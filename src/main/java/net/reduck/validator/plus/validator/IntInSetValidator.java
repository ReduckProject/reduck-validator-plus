package net.reduck.validator.plus.validator;

import net.reduck.validator.plus.validator.anatation.IntInSet;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

public class IntInSetValidator implements ConstraintValidator<IntInSet, Integer> {

    private Set<Integer> validValues;  // 存储有效的值集合

    @Override
    public void initialize(IntInSet constraintAnnotation) {
        // 从注解中获取合法值数组，并将其转换为 Set 集合
        validValues = new HashSet<>();
        for (int value : constraintAnnotation.values()) {
            validValues.add(value);
        }
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        // 校验 value 是否在 validValues 集合中
        if (value == null) {
            return true;  // 如果为 null，可以根据需要修改为不允许为 null
        }
        return validValues.contains(value);
    }
}
