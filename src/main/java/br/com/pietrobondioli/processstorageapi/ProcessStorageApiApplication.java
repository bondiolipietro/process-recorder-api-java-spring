package br.com.pietrobondioli.processstorageapi;

import br.com.pietrobondioli.processstorageapi.filter.AuthFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProcessStorageApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProcessStorageApiApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean<AuthFilter> filterRegistrationBean() {
        FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>();
        AuthFilter authFilter = new AuthFilter();
        registrationBean.setFilter(authFilter);
        registrationBean.addUrlPatterns("/api/processes/*");
        return registrationBean;
    }

}
