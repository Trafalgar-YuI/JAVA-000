package yui.hesstina.homework.w2.q4.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @package: yui.hesstina.homework.w2.q4.config
 * @class: CustomAutoConfiguration
 * @description:
 * @author: YuI
 * @create: 2020/11/22 15:12 
 * @since:
 **/
@Configuration
@Import(CustomConfiguration.class)
public class CustomAutoConfiguration {
}
