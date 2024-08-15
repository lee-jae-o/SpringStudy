package Spring.Core.Basic.discount;

import Spring.Core.Basic.member.Grade;
import Spring.Core.Basic.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")

    void  vip_o() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertEquals(1000, discount);

    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")

    void  vip_x() {
        //given
        Member member = new Member(2L, "memberVIP", Grade.Basic);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertEquals(0, discount);

    }

}