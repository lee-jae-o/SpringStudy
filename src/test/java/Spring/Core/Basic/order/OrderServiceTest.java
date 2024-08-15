package Spring.Core.Basic.order;

import Spring.Core.Basic.AppConfig;
import Spring.Core.Basic.member.Grade;
import Spring.Core.Basic.member.Member;
import Spring.Core.Basic.member.MemberService;
import Spring.Core.Basic.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "ItemA", 10000);

        Assertions.assertEquals(1000, order.getDiscountPrice());
    }
}
