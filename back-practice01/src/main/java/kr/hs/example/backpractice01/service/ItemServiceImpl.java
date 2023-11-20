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

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public Item insertItem(String name, int count, int price) {
        if(name.isEmpty()){
            throw new IllegalStateException("이름을 입력해주세요.");
        }
        if(count < 0){
            throw new IllegalStateException("0개 이하는 입력할 수 없습니다.");
        }
        if(price < 0){
            throw new IllegalStateException("0원 이하는 입력할 수 없습니다.");
        }
        Optional<Item> foundByName = itemRepository.findByName(name);
        if (foundByName.isPresent()) {
            throw new IllegalStateException("상품의 이름이 이미 존재합니다.");
        }
        Item newItem = Item.createItem()
                .name(name)
                .count(count)
                .price(price)
                .build();
        return itemRepository.save(newItem);
    }

    @Override
    public List<Item> getItem() {
        return itemRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateItem(Long id, String name, int count, int price) {
        if(count < 0){
            throw new IllegalStateException("0개 이하는 입력할 수 없습니다.");
        }
        if(price < 0){
            throw new IllegalStateException("0원 이하는 입력할 수 없습니다.");
        }
        Optional<Item> foundItem = itemRepository.findById(id);
        if(foundItem.isEmpty()){
            throw new IllegalStateException("찾는 아이템이 없습니다.");
        }

        foundItem.get().updateItem(name,count,price);
    }
}

