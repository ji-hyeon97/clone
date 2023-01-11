package eatda.clone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Getter
@Entity
@ToString(exclude = "likes")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store {

    @Id
    @GeneratedValue
    @Column(name = "store_id")
    private Long id;

    private String name;
    private int minOrderPrice;
    private String backgroundImageUrl;

    @OneToMany(mappedBy = "store", cascade = ALL)
    @Builder.Default
    @JsonIgnore
    private List<Menu> menus = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = ALL)
    @Builder.Default
    private List<Likes> likes = new ArrayList<>();

    public void addMenu(Menu menu){
        this.menus.add(menu);
    }

    public void deleteMenu(Menu menu){
        if(this.menus.contains(menu)){
            this.menus.remove(menu);
        }
    }

    public void addLike(Likes like){
        this.likes.add(like);
    }

    public void deleteLike(Likes like){
        if (this.likes.contains(like)){
            this.likes.remove(like);
        }
    }

    public int getLikesCount(){
        return likes.size();
    }
}
