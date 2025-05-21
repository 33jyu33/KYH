package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    // 역할을 분리함으로써 중복 제거
    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //사용 영역(service)의 코드를 변경할 필요가 없어졌다.
    //구성 영역(config)은 당연히 변경될 수 있다.
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
