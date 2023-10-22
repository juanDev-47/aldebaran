package com.example.aldebaran.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_item")
@IdClass(OrderItemId.class)
@Getter
@Setter
@NoArgsConstructor
public class OrderItemEntity {

    @Id
    @Column(name = "id_order", nullable = false)
    private Integer idOrder;

    @Id
    @Column(name = "id_item", nullable = false)
    private Integer idItem;

    @Column(name = "id_pizza")
    private Integer pizzaId;

    @Column(columnDefinition = "DECIMAL(2,1)", nullable = false)
    private Double quantity;

    @Column(columnDefinition = "DECIMAL(5,2)", nullable = false)
    private Double price;

    @OneToOne
    @JoinColumn(name = "id_pizza", referencedColumnName = "id_pizza", updatable = false, insertable = false)
    private PizzaEntity pizza;

    @ManyToOne
    @JoinColumn(name = "id_order", referencedColumnName = "id_order", updatable = false, insertable = false)
    private OrderEntity order;

}
