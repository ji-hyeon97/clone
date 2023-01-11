package eatda.clone.model;

import lombok.Getter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Getter
@Entity
public class Store {

    @Id
    @GeneratedValue
    @Column(name = "store_id")
    private Long id;

    private String name;
    private int minOrderPrice;
    private String backgroundImageUrl;

    @OneToMany(mappedBy = "store", cascade = ALL)
    private List<Likes> likes = new ArrayList<>();
}
