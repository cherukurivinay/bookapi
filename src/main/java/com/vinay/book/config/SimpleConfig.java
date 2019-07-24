package com.vinay.book.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="com.vinay")

@EnableTransactionManagement
public class SimpleConfig {
	/*@Autowired
    private Environment env;*/
	
	// Change the below based on the DBMS you choose
	private final static String DATABASE_DRIVER = "oracle.jdbc.driver.OracleDriver";
		private final static String DATABASE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
		
		private final static String DATABASE_DIALECT = "org.hibernate.dialect.Oracle10gDialect";
		private final static String DATABASE_USERNAME = "system";
		private final static String DATABASE_PASSWORD = "vinay";
		
		
		 
		 @Bean
		public DataSource getDataSource()throws SQLException {
				
				BasicDataSource dataSource = new BasicDataSource();
				
				// Providing the database connection information
				dataSource.setDriverClassName(DATABASE_DRIVER);
				dataSource.setUrl(DATABASE_URL);
				dataSource.setUsername(DATABASE_USERNAME);
				dataSource.setPassword(DATABASE_PASSWORD);
				
						
				
				return dataSource;
				
			}
		// sessionFactory bean will be available
		
		@Bean
		public SessionFactory getSessionFactory(DataSource dataSource) {
			
			LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
			
			builder.addProperties(getHibernateProperties());
			builder.scanPackages("com.vinay");
			
			return builder.buildSessionFactory();
			
		}

		
		
		// All the hibernate properties will be returned in this method	
		private Properties getHibernateProperties() {
			
			Properties properties = new Properties();
			
			
			properties.put("hibernate.dialect", DATABASE_DIALECT);		
			properties.put("hibernate.show_sql", "true");
			properties.put("hibernate.format_sql", "true");
			//properties.put("hibernate.hbm2ddl.auto", "update");
			
			properties.put("hibernate.hbm2ddl.auto", "update");
			
			
			return properties;
		}
		
		// transactionManager bean
		@Bean
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
			return transactionManager;
		}
		
	/*@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr=new InternalResourceViewResolver();
		vr.setPrefix("/");
		vr.setSuffix(".jsp");
		vr.setViewClass(InternalResourceView.class);
		return vr;
	}*/

}
