package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 코드 상으로는 memberService(), orderService()에 의해 new MemoryMemberRepository()가 2번 호출되어야 한다.
// 하지만 단 한 번만 실행되는데, 스프링 프레임워크의 @Configuration 을 통한 싱글톤 패턴 적용 때문이다.

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    // 역할을 분리함으로써 중복 제거
    @Bean
    public static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //사용 영역(service)의 코드를 변경할 필요가 없어졌다.
    //구성 영역(config)은 당연히 변경될 수 있다.
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
