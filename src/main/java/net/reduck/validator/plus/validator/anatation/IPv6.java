package net.reduck.validator.plus.validator.anatation;

import net.reduck.validator.plus.validator.IPv6Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 标记该注解适用于字段或方法参数
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
// 关联自定义的验证器类
@Constraint(validatedBy = IPv6Validator.class)
public @interface IPv6 {

    // 错误信息
    String message() default "Invalid IPv6 address";

    // 校验分组
    Class<?>[] groups() default {};

    // 校验附加元数据
    Class<? extends Payload>[] payload() default {};
}
