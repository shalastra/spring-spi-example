package io.shalastra.springserviceproviderext;

import io.shalastra.springserviceproviderapi.DemoProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ExtDemoProvider implements DemoProvider {

  @Override
  public void createDummyProvider() {
    log.info("This is dummy implementation of Provider");
  }
}
