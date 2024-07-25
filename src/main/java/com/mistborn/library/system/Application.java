package com.mistborn.library.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import com.mistborn.library.system.application.ServiceComponent;

@EnableCaching
@SpringBootApplication
@ComponentScan(
    includeFilters = {
        @ComponentScan.Filter(
            type = FilterType.ANNOTATION,
            classes = {ServiceComponent.class})
    })
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
