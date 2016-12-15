package cat.david.album.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@Import({DataSourceConfig.class})
@EnableWebMvc
@ComponentScan(basePackages={"cat.david.album.controller", "cat.david.album.dao"})
public class AppConfig {
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
		pspc.setLocation(new ClassPathResource("config/mysql.properties"));
		pspc.setIgnoreUnresolvablePlaceholders(true);
		return pspc;
	}
	
}
