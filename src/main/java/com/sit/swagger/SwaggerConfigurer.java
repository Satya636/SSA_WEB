package com.sit.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfigurer {

	@Bean
    public Docket api() { 
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
	            .apis(RequestHandlerSelectors.basePackage("com.sit.rest"))
	            .paths(PathSelectors.regex("/.*"))
	            .build().apiInfo(apiEndPointsInfo());
    }
	
	private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("USA FEDERAL GOVT.")
            .description("Social Security Administration System")
            .contact(new Contact("Mark Wills", "http://www.usa.gov", "ask@usa.gov"))
            .license("SSA-WEB-1.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .version("1.0.0") 
            .build();
    }
}
