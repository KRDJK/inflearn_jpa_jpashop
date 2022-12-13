package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") // mappedBy를 입력된 곳이 연관관계 주인이 아니라는 뜻!! 맵핑된 것일 뿐이다라는 뜻!!
    private List<Order> orders = new ArrayList<>();
}
