package Spring.Core.Basic.discount;

import Spring.Core.Basic.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
