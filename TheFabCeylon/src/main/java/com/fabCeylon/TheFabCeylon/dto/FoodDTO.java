package com.fabCeylon.TheFabCeylon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {

    private long id;
    private String foodName;
    private String description;
    private int price;
    private boolean isDeliveryAvailable;

    private long adminId;
}
