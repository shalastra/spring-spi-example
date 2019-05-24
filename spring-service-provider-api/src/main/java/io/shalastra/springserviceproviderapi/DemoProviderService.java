package io.shalastra.springserviceproviderapi;

import java.util.ArrayList;
import java.util.List;

import io.shalastra.springserviceproviderapi.exception.ImplementedProviderNotFoundException;
import io.shalastra.springserviceproviderapi.exception.MoreThanOneProviderFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

@Slf4j
@Service
public class DemoProviderService {

  private static final int DEFAULT_PROVIDER_POSITION = 0;

  public DemoProviderService() { }

  public DemoProvider getDemoProvider() {
    DemoProvider demoProvider;

    String providerName = getLoadedProviderName();

    try {
      Class<?> instanceClass = ClassUtils.forName(providerName, null);
      Assert.isAssignable(DemoProvider.class, instanceClass);

      demoProvider = (DemoProvider) instanceClass.newInstance();
    } catch (Exception e) {
      throw new IllegalArgumentException("Cannot instantiate " + providerName, e);
    }

    return demoProvider;
  }

  private String getLoadedProviderName() {
    List<String> names = new ArrayList<>(SpringFactoriesLoader.loadFactoryNames(DemoProvider.class, null));

    if (names.isEmpty()) {
      throw new ImplementedProviderNotFoundException("Cannot find any Provider implementation");
    }

    if (names.size() > 1) {
      throw new MoreThanOneProviderFoundException("Found more than one Provider implementation while only one is allowed");
    }

    return names.get(DEFAULT_PROVIDER_POSITION);
  }
}
