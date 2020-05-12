package com.sam.config.properties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

//@Configuration
@ConfigurationProperties(prefix = "file")
@Getter
@Setter
@ToString
@Data
public class FileProperties {

    private String url;

    private String uploadDir;

}
