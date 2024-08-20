# Open API (Swagger)

A OpenAPI é uma ferramenta de documentação, e também para testes, podemos assim dizer.
Essa API, pode ser adicionada a qualquer projeto REST, e uma fez configurada ela se torna transparente, ou seja, não necessárias novas configurações caso novos recursos sejam adicionados a nossa API.

Nesse repositório existe uma API rest exemplo, cujo a a qual, será a base para esse conteúdo em questão:

Para integrar a funcionalidade do Swagger, ao nosso projeto, caso não sejam desejadas configurações adicionais, basta adicionarmos a dependência da OpenAPI a nosso arquivo pom.xml.

``` xml
    <dependencies>
      ...
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.6.0</version>
        </dependency>
      ...
    </dependencies>
```

Uma vez adicionada a dependência, já é possível verificar se ela foi adicionada corretamente. Com a aplicação rodando, basta acessar o [dashboard](http://localhost:8080/swagger-ui/index.html) do Swagger-ui, no endereço /swagger-ui/index.html, caso esteja utilizando as configurações padrão do Spring Boot o endereço é http://localhost:8080/swagger-ui/index.html .

### Dashboard do Swagger
![image](https://github.com/user-attachments/assets/978cd52e-f055-486d-9f47-11a6d564f42b)

Nessa tela, devem aparecer todos os endpoint de nossa aplicação.
É possível interagir, com esses endpoints, através da UI do Swagger. Abaixo, um exemplo de como inserir um novo registro em nossa API:
Clicar em *Try it out*:
![image](https://github.com/user-attachments/assets/2bfd8195-c78b-40b4-bbe9-276857db55fa)

Em seguida, devemos editar os atributos de nossa entidade e cliclar em *Execute*.
![image](https://github.com/user-attachments/assets/a1be227f-feae-4daf-94a7-2539b5745a2f)

Todas as informações, configurados em nossa API, são exibidos tanto em caso de sucesso ou falha.

É possível customizar as configurações, do Swagger, através de uma classe de configuração, conforme um breve exemplo abaixo:

``` java
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
```
Nessa classe, estão sendo configurados o titúlo de nossa api, detalhes de contato, licença e informações sobre os servidores da aplicação.




[Swaager Oauth2](https://codersite.dev/spring-boot-oauth2/)
[Spring Rest OpenApi](https://www.baeldung.com/spring-rest-openapi-documentation)


