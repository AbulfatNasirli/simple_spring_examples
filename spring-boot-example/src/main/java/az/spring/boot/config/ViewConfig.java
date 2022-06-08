package az.spring.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class ViewConfig {

    @Bean
    public InternalResourceViewResolver internalResourceView() {
        InternalResourceViewResolver internalResourceView = new InternalResourceViewResolver();
        internalResourceView.setPrefix("/WEB-INF/views/");
        internalResourceView.setSuffix(".jsp");
       // internalResourceView.setViewClass(JstlView.class);

        return internalResourceView;
    }
}
