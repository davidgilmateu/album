package cat.david.album.spring;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

@Configuration
public class DataSourceConfig {

	@Value("${jdbc.driverClassName}")	private String driverClassName;
    @Value("${jdbc.url}")				private String url;
    @Value("${jdbc.username}")			private String username;
    @Value("${jdbc.password}")			private String password;
    
    @Value("${hibernate.dialect}")		private String hibernateDialect;
    @Value("${hibernate.show_sql}")		private String hibernateShowSql;
    @Value("${hibernate.hbm2ddl.auto}")	private String hibernateHbm2ddlAuto;
    
    @Bean()    
    public DataSource getDataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();        
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);     
        return ds;
    }
    
    @Bean
    public LocalSessionFactoryBean getSessionFactory(){
    	LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
        lsfb.setDataSource(getDataSource());
        lsfb.setHibernateProperties(getHibernateProperties());        
        lsfb.setPackagesToScan(new String[]{"cat.david.album.model"});
        return lsfb;
    }
    
    private Properties getHibernateProperties(){
        Properties properties = new Properties();
        properties.put("hibernate.dialect", hibernateDialect);
        properties.put("hibernate.show_sql", hibernateShowSql);
        properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
        return properties;
    }
    
    @Bean
    @Autowired 
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager htm = new HibernateTransactionManager();
        htm.setSessionFactory(sessionFactory);
        return htm;
    }
    
    @Bean
    @Autowired
    public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory){
        HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
        return hibernateTemplate;
    }
    
}
