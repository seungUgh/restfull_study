package restfull_study.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
   @Override
   public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
      configurer.enable();
   }
   
   @Override
   public void configureViewResolvers(ViewResolverRegistry registry) {
      registry.jsp("/WEB-INF/view/", ".jsp");
   }
   
   public void addViewControllers(ViewControllerRegistry registry) {
	   registry.addViewController("/main").setViewName("/test");
	   registry.addViewController("/memberlist").setViewName("/member/list");
	   registry.addViewController("/read").setViewName("/member/get");
   }
   
   @Bean
   public MessageSource messageSource() { // 빈의 아이디를 반드시 messageSource로 지정
      ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
      ms.setBasename("message.label");
      ms.setDefaultEncoding("UTF-8");
      return ms;
   }
   
   @Override
   public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
      ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
            .featuresToEnable(SerializationFeature.INDENT_OUTPUT)
            .serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(formatter))
            .simpleDateFormat("yyyy-MM-dd HH:mm:ss").build();
      converters.add(0, new MappingJackson2HttpMessageConverter(objectMapper));
   }

}