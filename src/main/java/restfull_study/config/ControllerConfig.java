package restfull_study.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ContextDataSource.class, ContextSqlSession.class})
@ComponentScan(basePackages = {"restfull_study.mapper","restfull_study.service","restfull_study.controller"})
public class ControllerConfig {
	
}
