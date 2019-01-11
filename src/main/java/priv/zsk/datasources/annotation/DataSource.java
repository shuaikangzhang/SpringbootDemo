package priv.zsk.datasources.annotation;

import java.lang.annotation.*;

/**
 * @author:zsk
 * @CreateTime:2019-01-10 13:41
 *
 *
 * 自定义多数据源注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default "";
}
