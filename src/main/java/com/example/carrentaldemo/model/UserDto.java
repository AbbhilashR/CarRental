package com.example.carrentaldemo.model;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserDto {

    @NotNull(message = "UserName Cannot Be null")
    private String userName;

    @NotNull(message = "Address Cannot Be null")
    private String address;
    @NotNull(message = "Roleid Cannot be Null")
    private int roleid;

}
