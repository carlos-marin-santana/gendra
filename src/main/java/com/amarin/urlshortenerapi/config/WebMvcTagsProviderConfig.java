package com.amarin.urlshortenerapi.config;

import org.springframework.boot.actuate.metrics.web.servlet.WebMvcTagsProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class WebMvcTagsProviderConfig {
    @Bean
    public WebMvcTagsProvider webMvcTagsProvider() {
        return new CustomWebMvcTagsProvider();
    }
}