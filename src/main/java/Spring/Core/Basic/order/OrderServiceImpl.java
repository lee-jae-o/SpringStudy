package Spring.Core.Basic.order;

import Spring.Core.Basic.discount.DiscountPolicy;
import Spring.Core.Basic.discount.FixDiscountPolicy;
import Spring.Core.Basic.member.Member;
import Spring.Core.Basic.member.MemberRepository;
import Spring.Core.Basic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}
