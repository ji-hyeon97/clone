package eatda.clone.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreDTO {
    private Long id;
    private String name;
    private int minOrderPrice;
    private String backgroundImageUrl;
    private List<MenuDTO> menus = new ArrayList<>();
    private int like;
}
