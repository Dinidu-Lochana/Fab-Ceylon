package com.fabCeylon.TheFabCeylon.domain.user;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    private String id;
    private String contactNumber;
    private String name;
    private String password;
}
