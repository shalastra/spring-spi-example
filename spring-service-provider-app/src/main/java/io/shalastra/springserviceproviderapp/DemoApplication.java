package io.shalastra.springserviceproviderapp;

import io.shalastra.springserviceproviderapi.DemoProvider;
import io.shalastra.springserviceproviderapi.DemoProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

  @Autowired
  private DemoProvider demoProvider;

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Override
  public void run(String... args) {
    demoProvider.createDummyProvider();
  }
}
