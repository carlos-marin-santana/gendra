package com.amarin.urlshortenerapi.config;

import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Tags;
import org.springframework.boot.actuate.metrics.web.servlet.DefaultWebMvcTagsProvider;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class CustomWebMvcTagsProvider extends DefaultWebMvcTagsProvider {
    public Iterable<Tag> getTags(HttpServletRequest request, HttpServletResponse response, Object handler, Throwable exception) {
        return Tags.of(super.getTags(request, response, handler, exception)).and(getShortUrlTag(request));
    }

    private Tag getShortUrlTag(HttpServletRequest request) {
        String shortUrl = ((Map<String, String>)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE)).get("shortUrl");
        if(shortUrl == null){
            shortUrl = "na";
        }
        return Tag.of("shortUrl", shortUrl);
    }
}