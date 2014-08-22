package be.johan40.datasource;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class CreateTestDataSourceBean {
	@Bean
	DataSource dataSource() {
	return new DriverManagerDataSource("jdbc:mysql://localhost/mijndb",
	"root", "vdab");
	// of voor testen met een in-memory database:
	// new DriverManagerDataSource("jdbc:hsqldb:mem:mijndb", "sa", "")
	}

}
