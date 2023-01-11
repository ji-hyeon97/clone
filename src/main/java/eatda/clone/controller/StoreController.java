package eatda.clone.controller;

import eatda.clone.dto.MenuDTO;
import eatda.clone.dto.ResponseDTO;
import eatda.clone.dto.StoreDTO;
import eatda.clone.model.Menu;
import eatda.clone.model.Store;
import eatda.clone.service.StoreService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @ApiOperation(value = "가게상세", notes = "가게상세 페이지로 가게정보, 메뉴, 좋아요수를 리턴합니다.")
    @GetMapping("/storeDetail/{id}")
    public ResponseDTO<?> storeDetail(@AuthenticationPrincipal String userId, @PathVariable Long id){
        storeService.initialize();
        Store store = storeService.storeDetail(id);
        List<MenuDTO> menuDTOList = new ArrayList<>();
        for(Menu m : store.getMenus()){
            MenuDTO menuDTO = MenuDTO.builder()
                    .id(m.getId())
                    .store(m.getStore())
                    .name(m.getName())
                    .imageUrl(m.getImageUrl())
                    .price(m.getPrice())
                    .build();
            menuDTOList.add(menuDTO);
        }

        StoreDTO storeDTO = StoreDTO.builder()
                .id(store.getId())
                .name(store.getName())
                .minOrderPrice(store.getMinOrderPrice())
                .backgroundImageUrl(store.getBackgroundImageUrl())
                .menus(menuDTOList)
                .like(store.getLikesCount())
                .build();

        return new ResponseDTO<>(HttpStatus.OK.value(), storeDTO);
    }
}
