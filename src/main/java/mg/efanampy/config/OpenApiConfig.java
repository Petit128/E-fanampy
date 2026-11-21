package mg.efanampy.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.*;
@Configuration
public class OpenApiConfig {
    @Bean public OpenAPI api() {
        return new OpenAPI().info(new Info().title("E-fanampy API").version("0.0.1").description("MADAHELP backend"));
    }
}