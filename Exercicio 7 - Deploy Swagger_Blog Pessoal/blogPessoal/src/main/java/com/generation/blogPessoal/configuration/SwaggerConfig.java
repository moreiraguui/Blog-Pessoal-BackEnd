package com.generation.blogPessoal.configuration;


import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

	@Configuration
	public class SwaggerConfig {
		
		@Bean
	    public OpenAPI springblogPessoalOpenAPI() {
	        
	        return new OpenAPI()
	                .info(new Info()
	                        .title("Projeto Blog Pessoal")
	                        .description("Projeto Blog Pessoal - Generation Brasil")
	                        .version("v0.0.1")
	                .license(new License()
	                        .name("Generation Brasil")
	                        .url("https://generation.org"))
	                .contact(new Contact()
	                        .name("Blog Pessoal - Guilherme")
	                          .url("https://github.com/moreiraguui/Blog-Pessoal-BackEnd")
	                          .email("guilhermemoreira111@hotmail.com")))
	                .externalDocs(new ExternalDocumentation()
	                        .description("Github")
	                        .url("https://github.com/moreiraguui/Blog-Pessoal-BackEnd"));
	    }
		
		@Bean
	    public OpenApiCustomiser customerGlobalHeaderOpenApiCustomiser() {
	        
	        return openApi -> {
	            openApi.getPaths().values()
	                .forEach(pathItem -> pathItem.readOperations()
	                    .forEach(operation -> {
	                            
	                    ApiResponses apiResponses = operation.getResponses();
	                            
	                        apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
	                        apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
	                        apiResponses.addApiResponse("204", createApiResponse("Objeto Exclu??do!"));
	                        apiResponses.addApiResponse("400", createApiResponse("Erro na Requisi????o!"));
	                        apiResponses.addApiResponse("401", createApiResponse("Acesso N??o Autorizado!"));
	                        apiResponses.addApiResponse("404", createApiResponse("Objeto N??o Encontrado!"));
	                        apiResponses.addApiResponse("500", createApiResponse("Erro na Aplica????o!"));
	                    
	                    }));
	        };
	    }
	    
	    private ApiResponse createApiResponse(String message) {
	          
	        return new ApiResponse().description(message);
	    
	    }
	}

