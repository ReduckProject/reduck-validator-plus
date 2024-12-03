package net.reduck.validator.plus.validator.anatation;

import net.reduck.validator.plus.validator.StringInSetValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StringInSetValidator.class)  // 指定验证器类
public @interface IntInSet {

    String message() default "Value must be one of the predefined values";  // 默认错误信息

    Class<?>[] groups() default {};  // 用于分组校验

    Class<? extends Payload>[] payload() default {};  // 可用于携带元数据

    int[] values() default {};  // 允许传入的值集合
}
