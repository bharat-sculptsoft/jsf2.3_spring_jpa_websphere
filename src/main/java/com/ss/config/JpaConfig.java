package com.ss.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.ss.repo")
@ComponentScan({"com.ss"})
enable it from web.xml
*/
public class JpaConfig {

	// Replace the database properties below with your actual database settings
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/jsf_db";
    private static final String DATABASE_DRIVER = "org.postgresql.Driver";
    private static final String DATABASE_USERNAME = "postgres";
    private static final String DATABASE_PASSWORD = "admin";

    @Bean(name = "dataSource")
    public DataSource dataSource() {
    	System.out.println("datasource");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DATABASE_DRIVER);
        dataSource.setUrl(DATABASE_URL);
        dataSource.setUsername(DATABASE_USERNAME);
        dataSource.setPassword(DATABASE_PASSWORD);
        return dataSource;
    }

    @Bean(name = "emf")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource ) {
       
    	System.out.println("LocalContainerEntityManagerFactoryBean");

    	LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.ss.*"); // Package where your JPA entities reside
        em.setJpaProperties(jpaProperties());
        em.setPersistenceProviderClass(HibernatePersistenceProvider.class);

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(Boolean.TRUE);
		vendorAdapter.setShowSql(Boolean.TRUE);
        em.setJpaVendorAdapter(vendorAdapter);
        //em.setPersistenceUnitName("myPersistenceUnit"); // Specify the name of your persistence unit
        return em;
    }

    private Properties jpaProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.hbm2ddl.auto", "update"); // Change this based on your requirements
        properties.put("hibernate.show_sql", "true"); // Enable SQL logging (optional)
        return properties;
    }

    @Bean(name="txManager")
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
    	System.out.println("transactionManager");

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
       
        return transactionManager;
    }
    
	
}
