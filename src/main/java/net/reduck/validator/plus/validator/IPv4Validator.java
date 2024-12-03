package net.reduck.validator.plus.validator;

import net.reduck.validator.plus.validator.anatation.IPv4;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class IPv4Validator implements ConstraintValidator<IPv4, String> {

    // IPv4 地址的正则表达式
    private static final String IPV4_PATTERN =
            "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
                    + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
                    + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
                    + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

    private Pattern pattern = Pattern.compile(IPV4_PATTERN);

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 如果值为 null，则认为有效（可以根据需求修改为不允许 null）
        if (value == null) {
            return true;
        }
        // 校验是否匹配 IPv4 格式
        return pattern.matcher(value).matches();
    }
}
