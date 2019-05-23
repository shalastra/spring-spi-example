package io.shalastra.springserviceproviderapp;

import java.util.ArrayList;
import java.util.List;

import io.shalastra.springserviceproviderapi.DemoProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

@Slf4j
@Configuration
public class AppConfig {

  @Bean
  public DemoProvider demoProvider() {
    List<String> names = new ArrayList<>(SpringFactoriesLoader.loadFactoryNames(DemoProvider.class, null));
    String name = names.get(0);
    DemoProvider demoProvider;

    try {
      Class<?> instanceClass = ClassUtils.forName(name, null);
      Assert.isAssignable(DemoProvider.class, instanceClass);

      demoProvider = (DemoProvider) instanceClass.newInstance();
    } catch (Exception e) {
      throw new IllegalArgumentException("Cannot instantiate 'IntegrationConfigurationInitializer': " + name, e);
    }

    return demoProvider;
  }
}
