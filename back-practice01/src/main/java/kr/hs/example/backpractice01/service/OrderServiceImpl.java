package kr.hs.example.backpractice01.service;

import kr.hs.example.backpractice01.domain.Item;
import kr.hs.example.backpractice01.domain.Member;
import kr.hs.example.backpractice01.domain.Orders;
import kr.hs.example.backpractice01.repository.ItemRepository;
import kr.hs.example.backpractice01.repository.MemberRepository;
import kr.hs.example.backpractice01.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;


    @Override
    @Transactional
    public void buyItem(Long itemId, Long memberId, int count) {
        Item foundItem = itemRepository.findById(itemId).orElseThrow(() -> new IllegalStateException("아이템이 없습니다"));
        Member foundMember = memberRepository.findById(memberId).orElseThrow(() -> new IllegalStateException("찾는 멤버가 없습니다"));

        if (foundItem.getCount() < count) {
            throw new IllegalStateException("현재 재고 수량에 원하시는 구매 수량이 충분하지 않습니다.");
        }

        orderRepository.save(
                Orders.createOrder()
                        .count(count)
                        .member(foundMember)
                        .build());

        foundItem.minusCount(count);
    }
}
