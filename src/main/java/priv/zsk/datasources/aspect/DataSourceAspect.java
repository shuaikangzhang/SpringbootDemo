package priv.zsk.datasources.aspect;


import priv.zsk.datasources.DataSourceNames;
import priv.zsk.datasources.DynamicDataSource;
import priv.zsk.datasources.annotation.DataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * @author:zsk
 * @CreateTime:2019-01-10 13:42
 *
 * 多数据源，对于注解的切面处理类
 */
@Aspect
@Component
public class DataSourceAspect implements Ordered {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public int getOrder() {
        return 1;
    }

    @Pointcut("@annotation(priv.zsk.datasources.annotation.DataSource)")
    public void dataSourcePointCut(){

    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point)throws Throwable{
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        DataSource ds = method.getAnnotation(DataSource.class);
        if(ds == null){
            DynamicDataSource.setDataSource(DataSourceNames.masterData);
            logger.debug("set datasource is " + DataSourceNames.masterData);
        }else {
            DynamicDataSource.setDataSource(ds.name());
            logger.debug("set datasource is " + ds.name());
        }

        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
            logger.debug("clean datasource");
        }
    }



}
