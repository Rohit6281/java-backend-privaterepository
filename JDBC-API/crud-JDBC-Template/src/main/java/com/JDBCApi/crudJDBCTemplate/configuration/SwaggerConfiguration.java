package com.JDBCApi.crudJDBCTemplate.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket getDocket(){
        Contact contact = new Contact("AVA Team","https://www.collabera.com/","avm@co");
        List<VendorExtension> vendorExtensionList = new ArrayList<VendorExtension>();
        ApiInfo apiInfo = new ApiInfo("JDBC documentation", "****",
                "AVA snapshot 1.0.1", "https://www.collabera.com/", contact, "Licence 1172",
                "http://jsonbeautifier.org/",vendorExtensionList);

        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.JDBCApi.crudJDBCTemplate")).build().apiInfo(apiInfo).useDefaultResponseMessages(false);

    }
}
