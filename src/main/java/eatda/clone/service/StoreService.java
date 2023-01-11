package eatda.clone.service;

import eatda.clone.exception.store.StoreNotFoundException;
import eatda.clone.model.Menu;
import eatda.clone.model.Store;
import eatda.clone.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreService {

    private final StoreRepository storeRepository;

    @Transactional
    public void initialize(){
        Store s1 = Store.builder()
                .name("가게1")
                .minOrderPrice(12000)
                .backgroundImageUrl("https://naver.com")
                .build();

        Menu m1 = Menu.builder()
                .name("떡볶이")
                .price(3500)
                .store(s1)
                .imageUrl("https://daum.net")
                .build();

        Menu m2 = Menu.builder()
                .name("오징어 튀김")
                .price(4000)
                .store(s1)
                .imageUrl("https://daum.net")
                .build();

        Menu m3 = Menu.builder()
                .name("잔치국수")
                .price(5000)
                .store(s1)
                .imageUrl("https://daum.net")
                .build();

        s1.addMenu(m1);
        s1.addMenu(m2);
        s1.addMenu(m3);

        storeRepository.save(s1);
    }

    public Store storeDetail(Long id){
        Store store = storeRepository.findByIdWithMenus(id).orElseThrow(()-> {
            throw new StoreNotFoundException();
        });
        return store;
    }
}
