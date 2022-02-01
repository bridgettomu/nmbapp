package com.nmb.nmbApp.dto;

import com.nmb.nmbApp.enums.Gender;
import com.nmb.nmbApp.enums.Title;
import lombok.Data;

@Data
public class UpdateCustomerDTO {

    private Long id;

    private String firstName;
    private String surname;
    private String nationalId;

    private Title title;

    private boolean homeOwner;

    private String email;
    private Gender gender;
    private String username;

    private Long accountId;
}
