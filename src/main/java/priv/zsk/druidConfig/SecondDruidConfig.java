package priv.zsk.druidConfig;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author:zsk
 * @CreateTime:2018-11-22 16:32
 */
@Configuration
@MapperScan(basePackages = {"priv.zsk.second.mapper"},
        sqlSessionFactoryRef = "secondSqlSessionFactory"
)
public class SecondDruidConfig {
    private Logger logger = LoggerFactory.getLogger(SecondDruidConfig.class);

    /*
    * 配置该数据源对应的xml文件
    *
    * */
    static final String MAPPER_LOCATION = "classpath:mapper/second/*.xml";

    @Value("${second.datasource.url:#{null}}")
    private String dbUrl;
    @Value("${second.datasource.username: #{null}}")
    private String username;
    @Value("${second.datasource.password:#{null}}")
    private String password;
    @Value("${second.datasource.driverClassName:#{null}}")
    private String driverClassName;
    @Value("${second.datasource.initialSize:#{null}}")
    private Integer initialSize;
    @Value("${second.datasource.minIdle:#{null}}")
    private Integer minIdle;
    @Value("${second.datasource.maxActive:#{null}}")
    private Integer maxActive;
    @Value("${second.datasource.maxWait:#{null}}")
    private Integer maxWait;
    @Value("${second.datasource.timeBetweenEvictionRunsMillis:#{null}}")
    private Integer timeBetweenEvictionRunsMillis;
    @Value("${second.datasource.minEvictableIdleTimeMillis:#{null}}")
    private Integer minEvictableIdleTimeMillis;
    @Value("${second.datasource.validationQuery:#{null}}")
    private String validationQuery;
    @Value("${second.datasource.testWhileIdle:#{null}}")
    private Boolean testWhileIdle;
    @Value("${second.datasource.testOnBorrow:#{null}}")
    private Boolean testOnBorrow;
    @Value("${second.datasource.testOnReturn:#{null}}")
    private Boolean testOnReturn;
    @Value("${second.datasource.poolPreparedStatements:#{null}}")
    private Boolean poolPreparedStatements;
    @Value("${second.datasource.maxPoolPreparedStatementPerConnectionSize:#{null}}")
    private Integer maxPoolPreparedStatementPerConnectionSize;
    @Value("${second.datasource.filters:#{null}}")
    private String filters;
    @Value("{second.datasource.connectionProperties:#{null}}")
    private String connectionProperties;

    @Bean(name = "secondDataSource")
    public DataSource dataSource(){
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(this.dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        //configuration
        if(initialSize != null) {
            datasource.setInitialSize(initialSize);
        }
        if(minIdle != null) {
            datasource.setMinIdle(minIdle);
        }
        if(maxActive != null) {
            datasource.setMaxActive(maxActive);
        }
        if(maxWait != null) {
            datasource.setMaxWait(maxWait);
        }
        if(timeBetweenEvictionRunsMillis != null) {
            datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        }
        if(minEvictableIdleTimeMillis != null) {
            datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        }
        if(validationQuery!=null) {
            datasource.setValidationQuery(validationQuery);
        }
        if(testWhileIdle != null) {
            datasource.setTestWhileIdle(testWhileIdle);
        }
        if(testOnBorrow != null) {
            datasource.setTestOnBorrow(testOnBorrow);
        }
        if(testOnReturn != null) {
            datasource.setTestOnReturn(testOnReturn);
        }
        if(poolPreparedStatements != null) {
            datasource.setPoolPreparedStatements(poolPreparedStatements);
        }
        if(maxPoolPreparedStatementPerConnectionSize != null) {
            datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        }

        if(connectionProperties != null) {
            datasource.setConnectionProperties(connectionProperties);
        }

        return datasource;
    }

    @Bean(name = "secondSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("secondDataSource") DataSource clusterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        /*设置转驼峰*/
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        sessionFactory.setConfiguration(configuration);

        sessionFactory.setDataSource(clusterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(SecondDruidConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
