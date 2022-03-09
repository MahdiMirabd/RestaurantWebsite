package uk.ac.rhul.cs2810.restaurantsystem.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/editMenu").setViewName("editMenu");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/kitchen").setViewName("kitchen");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/menu").setViewName("menu");
        registry.addViewController("/order").setViewName("order");
        registry.addViewController("/payment").setViewName("payment");
        registry.addViewController("/waiter").setViewName("waiter");
    }

}

