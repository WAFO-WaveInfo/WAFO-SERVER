package wafo.wafoserver.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "Wafo-Server API 명세서",
                description = "Wafo-Server API 명세서",
                version = "v1"
        )
)
@Configuration
public class SwaggerConfig {

}
