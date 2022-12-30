package ar.com.challenge.acme.clothing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@EnableCaching
@SpringBootApplication
@ComponentScan("ar.com.challenge.acme.clothing")
public class AcmeClothingApplication {

  public static void main(String[] args) {
    SpringApplication.run(AcmeClothingApplication.class, args);
  }

}
