package Spring.Core.Basic;

import Spring.Core.Basic.member.Grade;
import Spring.Core.Basic.member.Member;
import Spring.Core.Basic.member.MemberService;
import Spring.Core.Basic.member.MemberServiceImpl;
import Spring.Core.Basic.order.Order;
import Spring.Core.Basic.order.OrderService;
import Spring.Core.Basic.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new
                AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService =
                applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService",
                OrderService.class);
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
    }
}
