package cn.exrick.manager.shiro;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.filter.DelegatingFilterProxy;

@Configuration
public class ShiroConfig {
	
	
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		System.out.println("1111111111111111111111111111111111111");
		FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter")); 
        filterRegistration.setEnabled(true);
        filterRegistration.addUrlPatterns("/*"); 
        filterRegistration.setDispatcherTypes(DispatcherType.REQUEST);
        return filterRegistration;
	}
	
	 /**  
     * @see org.apache.shiro.spring.web.ShiroFilterFactoryBean  
     * @return  
     */  
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(){  
    	System.out.println("22222222222222222222222222222222222");
        ShiroFilterFactoryBean bean = new MyShiroFilterFactoryBean();  
        bean.setSecurityManager(securityManager());  
        bean.setLoginUrl("/login");  
        bean.setSuccessUrl("/");
        bean.setUnauthorizedUrl("/403");  
  
        Map<String, Filter>filters = new HashMap<>();
        filters.put("perms", urlPermissionsFilter());  
//        filters.put("roles", urlPermissionsFilter());  
        filters.put("anon", new AnonymousFilter());  
        bean.setFilters(filters);  
  
        Map<String, String> chains = new HashMap<>();
        chains.put("/login", "anon");  
        chains.put("/unauthor", "anon");  
        chains.put("/logout", "logout");  
        chains.put("/base/**", "anon");  
        chains.put("/css/**", "anon");  
        chains.put("/layer/**", "anon");  
        chains.put("/**", "authc,perms");  
        bean.setFilterChainDefinitionMap(chains);  
        return bean;  
    }  

    /**  
     * @see org.apache.shiro.mgt.SecurityManager  
     * @return  
     */  
    @Bean(name="securityManager")
    public DefaultWebSecurityManager securityManager() {  
    	System.out.println("33333333333333333333333333333333333");
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();  
        manager.setRealm(userRealm());  
        return manager;  
    }  
    
    
    /**
	 * @see DefaultWebSessionManager
	 * @return
	 */
	@Bean(name="sessionManager")
	public DefaultWebSessionManager defaultWebSessionManager() {
		System.out.println("88888888888888888888888888888888888");
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		//sessionManager.setCacheManager(cacheManager());
		sessionManager.setGlobalSessionTimeout(1800000);
		sessionManager.setDeleteInvalidSessions(true);
		sessionManager.setSessionValidationSchedulerEnabled(true);
		sessionManager.setDeleteInvalidSessions(true);
		return sessionManager;
	}
  
    /** 
     * @see UserRealm--->AuthorizingRealm 
     * @return 
     */  
    @Bean  
    @DependsOn(value="lifecycleBeanPostProcessor")
    public MyRealm userRealm() {  
    	MyRealm userRealm = new MyRealm();  
    	System.out.println("55555555555555555555555555555555");
        return userRealm;  
    }  
  
    @Bean  
    public MyPermissionFilter urlPermissionsFilter() {  
    	System.out.println("666666666666666666666666666");
        return new MyPermissionFilter();  
    }  
    @Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		System.out.println("99999999999999999999999999999");
		return new LifecycleBeanPostProcessor();
	}
}
