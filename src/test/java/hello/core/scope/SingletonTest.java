package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

public class SingletonTest {

    @Test
    void singtonBeanFind(){

    }

    @Scope("singleton")
    static class SingletonBean {

    }
}
