package com.intuit.complaintsystem.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "`complaints`")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Complaint {

    @Id
    @Column(name = "`id`")
    @Type(type = "uuid-char")
    private UUID id;

    @ManyToOne(cascade = {CascadeType.ALL})
    private User user;

    @Column(name = "`subject`", nullable = false)
    private String subject;

    @Column(name = "`complaint`", nullable = false)
    private String complaint;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Purchase purchase;

}
