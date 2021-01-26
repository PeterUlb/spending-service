package io.mybartab.spendingservice.config;


import io.mybartab.spendingservice.validator.PropertySet;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@ConfigurationProperties(prefix = "app.gcp")
@Validated
@Getter
@Setter
public class GcpProperties {
    @PropertySet
    private String keyPath;

    @PropertySet
    private String projectId;
}
