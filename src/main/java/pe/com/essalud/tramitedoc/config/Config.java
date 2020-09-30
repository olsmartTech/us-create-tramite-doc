package pe.com.essalud.tramitedoc.config;


//import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.ErrorPageFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.sql.DataSource;

//@EnableWebMvc
@Configuration
@ComponentScan({"pe.com.essalud.tramitedoc"})
public class Config {

    @Bean
    public ErrorPageFilter errorPageFilter() {
        return new ErrorPageFilter();
    }

    @Bean
    public FilterRegistrationBean disableSpringBootErrorFilter(ErrorPageFilter filter) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.setEnabled(false);
        return filterRegistrationBean;
    }

    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        /*DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        driverManagerDataSource.setUrl("jdbc:oracle:thin:@10.0.0.95:1521:qasalud");
        driverManagerDataSource.setUsername("TRAMITE_NUEVO");
        driverManagerDataSource.setPassword("tramite_nuevo$2019");*/

        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        driverManagerDataSource.setUrl("jdbc:oracle:thin:@10.0.1.77:1521:tramite");
        driverManagerDataSource.setUsername("TRAMITE_NUEVO");
        driverManagerDataSource.setPassword("Essalud20");
        return driverManagerDataSource;
    }
/*
    @Bean(name = "dataSourceTest")
    public DataSource getDataSource()
    {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        //dataSourceBuilder.url("jdbc:h2:file:C:/temp/test");
        dataSourceBuilder.url("jdbc:h2:AutorizadorDS");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }
*/
}
