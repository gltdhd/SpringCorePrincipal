package hello.core.Singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {
    @Test
    void configurationTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        System.out.println("memberRepository = " + memberRepository);
        MemberRepository memberRepository1 = memberService.getMemberRepository();
        System.out.println("memberRepository1 = " + memberRepository1);
        MemberRepository memberRepository2 = orderService.getMemberRepository();
        System.out.println("memberRepository2 = " + memberRepository2);

        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);

        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);

    }
    @Test
    void configurationDeep(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean = " + bean.getClass());
    }
}
