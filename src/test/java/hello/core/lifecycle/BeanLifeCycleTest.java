package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifCycleTest(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifecycleConfig.class);
        NetworkClient networkClient = ac.getBean(NetworkClient.class);
        networkClient.disconnect();
    }

    @Configuration
    static class LifecycleConfig {
        @Bean
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://localhost:8080");
            return networkClient;
        }
    }
}
