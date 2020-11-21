package com.covidPotar19;

import com.covidPotar19.controller.GoogleMapServlet;
import com.covidPotar19.service.DetailService;
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
}
