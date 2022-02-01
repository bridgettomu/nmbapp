package com.nmb.nmbApp.model;

import com.nmb.nmbApp.enums.Gender;
import com.nmb.nmbApp.enums.Title;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
public class Customer {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String surname;
    private String nationalId;

    @Enumerated(EnumType.STRING)
    private Title title;

    @Type(type = "yes_no")
    private boolean homeOwner;

    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String username;

    @CreationTimestamp
    private LocalDate creationDate;

    @UpdateTimestamp
    private LocalDate updateDate;


    @OneToMany
    private List<Account> accounts;

}
