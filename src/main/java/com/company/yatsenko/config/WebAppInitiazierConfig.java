package com.company.yatsenko.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractRefreshableConfigApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**
 * Use for changing from web xml to annotation configuration
 */
public class WebAppInitiazierConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
                PersistenceConfig.class, CoreAspectConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    /**
     * <servlet-mapping>
     * <servlet-name>dispatcher</servlet-name>
     * <url-pattern>/</url-pattern>
     * </servlet-mapping>
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
