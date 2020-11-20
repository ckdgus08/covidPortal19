package com.covidPotar19;

import com.covidPotar19.servlet.DetailServlet;
import com.covidPotar19.servlet.GoogleMapServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletRegistrationConfig {

    @Bean
    public ServletRegistrationBean googleMapBean() {
        // googleMap Servlet -> Spring bean으로 등록
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new GoogleMapServlet());
        registrationBean.addUrlMappings("/googleMap");

        return registrationBean;
    }

    @Bean
    public ServletRegistrationBean DetailBean() {
        // googleMap Servlet -> Spring bean으로 등록
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new DetailServlet());
        registrationBean.addUrlMappings("/detail");

        return registrationBean;
    }
}
