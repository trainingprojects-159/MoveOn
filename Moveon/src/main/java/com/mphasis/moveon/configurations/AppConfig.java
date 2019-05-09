package com.mphasis.moveon.configurations;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mphasis.moveon.entities.Admin;
import com.mphasis.moveon.entities.Booking_Details;
import com.mphasis.moveon.entities.Customer;
import com.mphasis.moveon.entities.Driver;
import com.mphasis.moveon.entities.Location;

import com.mphasis.moveon.entities.Passenger;
import com.mphasis.moveon.entities.Route;
import com.mphasis.moveon.entities.Schedule;

import com.mphasis.moveon.entities.Vehicle;







@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableTransactionManagement
@ComponentScan(basePackages="com.mphasis.moveon.*")
public class AppConfig {

	
	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("moveon");
		ds.setPassword("852852");
		return ds;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan("com.mphasis.moveon.entities");
		sessionFactory.setAnnotatedClasses(Customer.class);
		sessionFactory.setAnnotatedClasses(Admin.class);
		sessionFactory.setAnnotatedClasses(Booking_Details.class);
		sessionFactory.setAnnotatedClasses(Driver.class);
		
		sessionFactory.setAnnotatedClasses(Passenger.class);
		sessionFactory.setAnnotatedClasses(Route.class);
		sessionFactory.setAnnotatedClasses(Location.class);
		sessionFactory.setAnnotatedClasses(Vehicle.class);
		sessionFactory.setAnnotatedClasses(Schedule.class);
		Properties properties=new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		properties.put("hibernate.hbm2ddl.auto", "create");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.formate_sql", "true");
		sessionFactory.setHibernateProperties(properties);
		return sessionFactory;
		
	}
	

	@Bean
	public HibernateTransactionManager getHibernateTransactionManger(SessionFactory s) {
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(s);
		return hibernateTransactionManager;
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("HEAD","GET","POST","DELETE").allowedHeaders("Origin","X-Requested-With","Content-Type","Accept");
			}
			

			
		};
	}
}

