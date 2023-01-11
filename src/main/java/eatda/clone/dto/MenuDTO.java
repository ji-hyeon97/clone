package eatda.clone.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import eatda.clone.model.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuDTO {
    private Long id;
    @JsonIgnore
    private Store store;
    private String name;
    private String imageUrl;
    private int price;
}
