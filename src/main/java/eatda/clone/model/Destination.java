package eatda.clone.model;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
public class Destination {

    @Id
    @GeneratedValue
    @Column(name = "destination_id")
    private Long id;

    private String name;
}
