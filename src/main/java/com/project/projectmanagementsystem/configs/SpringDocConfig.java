package com.project.projectmanagementsystem.configs;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
	@Bean
    public GroupedOpenApi controllerApi() {
        return GroupedOpenApi.builder()
                .group("com.project")
                .packagesToScan("com.project.projectmanagementsystem.controller")
                .build();
    }
}
