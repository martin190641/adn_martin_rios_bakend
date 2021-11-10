package com.ceiba.infraestructura.configuracion;

import com.ceiba.infraestructura.actuator.DataSourceHealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ConfiguracionHealth {


    private final DataSource dataSource;


    public ConfiguracionHealth(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Bean
    public DataSourceHealthIndicator dataSourceHealthIndicator() {
        return new DataSourceHealthIndicator(this.dataSource);

    }

}
