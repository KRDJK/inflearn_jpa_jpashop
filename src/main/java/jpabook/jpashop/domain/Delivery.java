package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) // 기본값이 EnumType.ORDINAL임 그러면 열거 순서에 따라 0, 1, 2 이렇게 들어감. 꼭 String으로 써라!!
    private DeliveryStatus status; // READY, COMP
}
