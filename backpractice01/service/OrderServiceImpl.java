package kr.hs.example.backpractice01.service;

import kr.hs.example.backpractice01.domain.Clothes;
import kr.hs.example.backpractice01.domain.Member;
import kr.hs.example.backpractice01.domain.Order;
import kr.hs.example.backpractice01.domain.OrderClothes;
import kr.hs.example.backpractice01.repository.ClothesRepository;
import kr.hs.example.backpractice01.repository.MemberRepository;
import kr.hs.example.backpractice01.repository.OrderClothesRepository;
import kr.hs.example.backpractice01.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.apache.bcel.classfile.Module;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ClothesRepository clothesRepository;
    private final OrderClothesRepository orderClothesRepository;

    @Transactional
    @Override
    public Order insertOrder(Long memberId, String clothesName, int count, String address){
        Optional<Member> member = memberRepository.findById(memberId);

        if(member.isEmpty()){
            throw new IllegalStateException("존재하지 않는 사용자입니다.");
        }
        Optional<Clothes> clothes = clothesRepository.findByName(clothesName);
        if(clothes.isEmpty()){
            throw new IllegalStateException("존재하지 않는 옷입니다.");
        }
        if(count > clothes.get().getCount()){
            throw  new IllegalStateException("존재하지 않는 갯 수 입니다.");
        }
        Order newOrder = orderRepository.save(
                Order.createOrder()
                        .member(member.get())
                        .count(count)
                        .address(address)
                        .build()
        );

        clothes.get().minusCount(count);

        orderClothesRepository.save(OrderClothes.createOrderClothes()
                .order(newOrder)
                .clothes(clothes.get())
                .build());

        return newOrder;
    }
    @Override
    public List<Order> getOrdersByMember(Long memberId){
        List<Order> orders = orderRepository.findByMemberId(memberId);
        return orders;
    }
    @Override
    public List<Order> getOrders(){
        return  orderRepository.findAll();
    }
}
