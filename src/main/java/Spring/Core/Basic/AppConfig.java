package Spring.Core.Basic;

import Spring.Core.Basic.discount.DiscountPolicy;
import Spring.Core.Basic.discount.RateDiscountPolicy;
import Spring.Core.Basic.member.MemberRepository;
import Spring.Core.Basic.member.MemberService;
import Spring.Core.Basic.member.MemberServiceImpl;
import Spring.Core.Basic.member.MemoryMemberRepository;
import Spring.Core.Basic.order.OrderService;
import Spring.Core.Basic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
