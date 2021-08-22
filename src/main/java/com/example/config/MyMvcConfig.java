package com.example.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //静态资源释放
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/index").setViewName("/login");
        registry.addViewController("/").setViewName("/index");

        registry.addViewController("/admin").setViewName("adminIndex");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main").setViewName("index");
        registry.addViewController("/contact").setViewName("contact");
        registry.addViewController("/service").setViewName("service");
        registry.addViewController("/service2").setViewName("service2");
        registry.addViewController("/service3").setViewName("service3");
        registry.addViewController("/tousu").setViewName("tousu");
        registry.addViewController("/netlist").setViewName("netlist");
        registry.addViewController("/search").setViewName("search");
        registry.addViewController("/search2").setViewName("search2");
        registry.addViewController("/search3").setViewName("search3");
        registry.addViewController("/search4").setViewName("search4");
        registry.addViewController("/product").setViewName("product");
        registry.addViewController("/product2").setViewName("product2");
        registry.addViewController("/product3").setViewName("product3");
        registry.addViewController("/product4").setViewName("product4");
        registry.addViewController("/product5").setViewName("product5");
        registry.addViewController("/join").setViewName("join");
        registry.addViewController("/job").setViewName("job");
        registry.addViewController("/news").setViewName("news");
        registry.addViewController("/about").setViewName("about");
        registry.addViewController("/contact").setViewName("contact");
    }

}