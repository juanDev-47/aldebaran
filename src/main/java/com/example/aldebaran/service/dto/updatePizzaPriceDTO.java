package com.example.aldebaran.service.dto;

import lombok.Data;

@Data
public class updatePizzaPriceDTO {
    private int pizzaId;
    private Double newPrice;
}
