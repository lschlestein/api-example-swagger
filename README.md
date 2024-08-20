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


[Swaager Oauth2](https://codersite.dev/spring-boot-oauth2/)
[Spring Rest OpenApi](https://www.baeldung.com/spring-rest-openapi-documentation)
