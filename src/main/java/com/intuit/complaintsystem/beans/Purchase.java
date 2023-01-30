package com.intuit.complaintsystem.beans;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "`purchases`")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {

    @Id
    @Column(name = "`id`")
    @Type(type = "uuid-char")
    private UUID id;

    @ManyToOne(cascade = {CascadeType.ALL})
    private User user;

    @Column(name = "`productId`")
    @Type(type = "uuid-char")
    private UUID productId;

    @Column(name = "`productName`")
    private String productName;

    @Column(name = "`pricePaidAmount`")
    private double pricePaidAmount;

    @Column(name = "`priceCurrency`")
    private String priceCurrency;

    @Column(name = "`discountPercent`")
    private double discountPercent;

    @Column(name = "`merchantId`")
    @Type(type = "uuid-char")
    private UUID merchantId;

    @Column(name = "`purchaseDate`")
    private Date purchaseDate;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "purchase")
    @Singular
    @ToString.Exclude
    @JsonIgnore
    private List<Complaint> complaints;

}
