//package com.cyriii.config;
//
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.oas.annotations.EnableOpenApi;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//@Configuration
//@EnableOpenApi
//public class SwaggerConfig {
//
//    @Value("${swagger.enable:true}")
//    private Boolean swaggerEnable;
//
//    @Bean
//    public Docket createRestApi() {
//
//        return new Docket(DocumentationType.OAS_30)
//                .enable(swaggerEnable)
//                .select()
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .paths(PathSelectors.any())
//                .build();
//
//    }
//
//    /**
//     * 文档信息
//     *
//     * @return ApiInfo
//     */
//    private ApiInfo apiInfo() {
//
//        return new ApiInfoBuilder()
//
//                .title("这是swagger3的接口文档")
//
//                .description("更多请咨询服务开发者mt1020")
//
//                .contact(new Contact("mt1020", "浙江省嘉兴市", "3174393"))
//
//                .version("1.0")
//
//                .build();
//
//    }
//
//}
