package web.config;

/*
Stage 3 
*/

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("web") // где смотреть контроллеры (пакет)
public class WebConfig implements WebMvcConfigurer {

  private final ApplicationContext applicationContext;
  private static final Logger logger = LogManager.getLogger(WebConfig.class);

  public WebConfig(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  @Bean
  public SpringResourceTemplateResolver templateResolver() {
    SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
    templateResolver.setApplicationContext(applicationContext);
    templateResolver.setPrefix("/WEB-INF/pages/");
    templateResolver.setSuffix(".html");
    templateResolver.setCharacterEncoding("UTF-8");
    logger.info("\u001B[32m WebConfig: templateResolver Bean. \u001B[0m]");
    return templateResolver;
  }

  @Bean
  public SpringTemplateEngine templateEngine() {
    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    templateEngine.setTemplateResolver(templateResolver());
    templateEngine.setEnableSpringELCompiler(true);
    logger.info("\u001B[36m WebConfig: SpringTemplateEngine Bean. \u001B[0m]");
    return templateEngine;
  }

  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
    logger.info("\u001B[35m WebConfig: configureViewResolvers Bean. \u001B[0m]");
    ThymeleafViewResolver resolver = new ThymeleafViewResolver();
    resolver.setCharacterEncoding("UTF-8");
    resolver.setTemplateEngine(templateEngine());
    registry.viewResolver(resolver);
  }
}
