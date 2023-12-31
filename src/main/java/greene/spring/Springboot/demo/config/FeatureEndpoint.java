package greene.spring.Springboot.demo.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Endpoint(id = "features")
public class FeatureEndpoint {
    private Map<String, Feature> featuresMap = new HashMap<>();

    public FeatureEndpoint() {
        featuresMap.put("Department", new Feature(true));
        featuresMap.put("User", new Feature(false));
        featuresMap.put("Authentication", new Feature(false));

    }

    @ReadOperation
    public Map<String, Feature> features() {
        return featuresMap;
    }

    @ReadOperation
    public Feature feature(@Selector String featureName) {
        return featuresMap.get(featureName);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    private static class Feature {
        private boolean enabled;
    }


}
