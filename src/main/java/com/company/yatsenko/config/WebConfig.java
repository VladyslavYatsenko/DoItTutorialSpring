package com.company.yatsenko.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.Properties;

/**
 * <mvc:annotation-driven/>
 * <context:component-scan base-package="com.company.yatsenko"/>
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.company.yatsenko")
public class WebConfig implements WebMvcConfigurer {

    /**
     * <bean class="org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver">
     * <property name="suffix" value=".ftl"/>
     * <property name="contentType" value="text/html;charset=UTF-8"/>
     * <property name="cache" value="false"/>
     * </bean>
     */
    @Bean
    public FreeMarkerViewResolver viewResolver() {
        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
        viewResolver.setSuffix(".ftl");
        viewResolver.setContentType("text/html;charset=UTF-8");
        viewResolver.setCache(false);
        return viewResolver;
    }

    /**
     * <bean id="freemarkerConfig" class="org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer">
     * <property name="templateLoaderPath" value="/WEB-INF/templates"/>
     * <property name="defaultEncoding" value="UTF-8"/>
     * <property name="freemarkerSettings">
     * <props>
     * <prop key="default_encoding">UTF-8</prop>
     * </props>
     * </property>
     * </bean>
     */
    @Bean
    public FreeMarkerConfigurer freemarkerConfigurer() {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("WEB-INF/templates");
        configurer.setDefaultEncoding("UTF-8");
        configurer.setFreemarkerSettings(new Properties() {{
            this.put("default_encoding", "UTF-8");
        }});
        return configurer;
    }
}
