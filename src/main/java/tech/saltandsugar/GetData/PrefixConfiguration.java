package tech.saltandsugar.GetData;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "configuration")
public class PrefixConfiguration {
    private String filepath;

    public String getFilepath(){
        return filepath;
    }
    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}
