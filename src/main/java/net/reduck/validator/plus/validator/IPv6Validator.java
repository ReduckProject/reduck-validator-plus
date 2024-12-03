package net.reduck.validator.plus.validator;

import net.reduck.validator.plus.validator.anatation.IPv6;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class IPv6Validator implements ConstraintValidator<IPv6, String> {

    // IPv6 地址的正则表达式
    private static final String IPV6_PATTERN = "^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$" +
            "|^([0-9a-fA-F]{1,4}:){1,7}:$" +
            "|^::(?:[0-9a-fA-F]{1,4}:){0,7}[0-9a-fA-F]{1,4}$" +
            "|^fe80:(?:[0-9a-fA-F]{1,4}:){0,4}[0-9a-fA-F]{1,4}$" +
            "|^::(?:ffff(:0{1,4}){0,1}:){0,1}[0-9a-fA-F]{1,4}(:[0-9a-fA-F]{1,4}){1,2}$";

    private Pattern pattern = Pattern.compile(IPV6_PATTERN);

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 如果值为 null，则认为有效（可以根据需求修改为不允许 null）
        if (value == null) {
            return true;
        }
        // 校验是否匹配 IPv6 格式
        return pattern.matcher(value).matches();
    }
}
