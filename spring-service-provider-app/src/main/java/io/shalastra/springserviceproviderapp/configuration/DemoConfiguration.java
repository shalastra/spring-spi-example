package io.shalastra.springserviceproviderapp.configuration;

import io.shalastra.springserviceproviderapi.DemoProvider;
import io.shalastra.springserviceproviderapi.DemoProviderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfiguration {

  @Bean
  public DemoProvider demoProvider() {
    DemoProviderService service = new DemoProviderService();

    return service.getDemoProvider();
  }
}
