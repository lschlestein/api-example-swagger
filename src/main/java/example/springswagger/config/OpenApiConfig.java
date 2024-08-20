package example.springswagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Cars Management API")
                        .version("v1.0")
                        .description("Rest API for Cars")
                        .termsOfService("http://exemplo.com/terms/")
                        .contact(new Contact()
                                .name("Nome do Contato")
                                .email("email@exemplo.com")
                                .url("http://exemplo.com/contato"))
                        .license(new License()
                                .name("Licença da API")
                                .url("http://exemplo.com/licenca")))
         .servers(List.of(
                new Server().url("http://localhost:8080").description("Servidor de Desenvolvimento"),
                new Server().url("https://api.exemplo.com").description("Servidor de Produção")
        ));
    }
}
