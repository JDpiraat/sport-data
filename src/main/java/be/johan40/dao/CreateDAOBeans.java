package be.johan40.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import be.johan40.entities.Sportsman;
import be.johan40.valueobjects.SportsSession;

@Configuration
@ComponentScan(basePackageClasses = CreateDAOBeans.class)
@EnableJpaRepositories(basePackageClasses = { CreateDAOBeans.class })
// spring data!
public class CreateDAOBeans {

	@Autowired
	private DataSource dataSource;

	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource);
		factory.setPackagesToScan(Sportsman.class.getPackage().getName(),
				SportsSession.class.getPackage().getName());
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setShowSql(true);
		factory.setJpaVendorAdapter(adapter);
		factory.getJpaPropertyMap().put("hibernate.format_sql", true);
		factory.getJpaPropertyMap().put("hibernate.use_sql_comments", true);
		/* !!!***!!! creating database !!!***!!!
		factory.getJpaPropertyMap().put(
				"javax.persistence.schema-generation.database.action", "create");
		*/
		return factory;
	}

	@Bean
	JpaTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory().getObject());
	}

}
