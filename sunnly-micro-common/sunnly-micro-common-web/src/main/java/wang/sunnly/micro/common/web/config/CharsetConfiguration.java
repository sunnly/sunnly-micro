//package wang.sunnly.micro.common.web.config;
//
//import com.google.common.collect.Lists;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.StringHttpMessageConverter;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import wang.sunnly.micro.common.web.interceptor.CharsetInterceptor;
//
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//
///**
// * @author Sunnly
// * @ClassName CharsetConfiguration
// * @Date 2019/6/18 10:19
// * @Version 1.0
// */
//
////TODO @Configuration
//public class CharsetConfiguration extends WebMvcConfigurationSupport {
//    @Bean
//    public HttpMessageConverter<String> responseBodyConverter() {
//        StringHttpMessageConverter converter = new StringHttpMessageConverter(
//                StandardCharsets.UTF_8);
//        List<MediaType> list = Lists.newArrayList();
//        list.add(MediaType.parseMediaType("text/html;charset=UTF-8"));
//        list.add(MediaType.parseMediaType("application/json;charset=UTF-8"));
//        list.add(MediaType.parseMediaType("*/*;charset=UTF-8"));
//        converter.setSupportedMediaTypes(list);
//
//        return converter;
//    }
//
//    @Bean
//    public CharsetInterceptor charsetInterceptor(){
//        return new CharsetInterceptor();
//    }
//
//
//    @Override
//    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(responseBodyConverter());
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(charsetInterceptor()).addPathPatterns("/**");
//    }
//
//    @Override
//    public void configureMessageConverters(
//            List<HttpMessageConverter<?>> converters) {
//        converters.add(responseBodyConverter());
//    }
//
//
//    @Override
//    public void configureContentNegotiation(
//            ContentNegotiationConfigurer configurer) {
//        configurer.favorPathExtension(false).defaultContentType(MediaType.APPLICATION_JSON);
//    }
//
//}
