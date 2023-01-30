package com.intuit.complaintsystem.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "`users`")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "`id`")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "`fullName`")
    private String fullName;

    @Column(name = "`emailAddress`")
    private String emailAddress;

    @Column(name = "`physicalAddress`")
    private String physicalAddress;

    @OneToMany(mappedBy = "user")
    @Singular
    @ToString.Exclude
    @JsonIgnore
    private List<Complaint> complaints;

}
