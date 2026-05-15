package hyperpaint.nerf_exporter.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("nerf-exporter")
@Getter
@Setter(AccessLevel.PACKAGE)
public class NerfExporterConfig {
    private String api;
}
