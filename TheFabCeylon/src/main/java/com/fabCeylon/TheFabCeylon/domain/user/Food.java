package com.fabCeylon.TheFabCeylon.domain.user;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Foods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Food {
    @Id
    private long id;

    private String foodName;

    private int price;

    private boolean isDeliveryAvailable;

    private String description;



}
