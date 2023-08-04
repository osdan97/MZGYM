package com.idat.mzgym.model;

import com.idat.mzgym.util.enums.TransactionState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "ORDERS")
public class Orders {

    @Id
    @Column(name = "order_uuid",nullable = false,unique = true)
    private String orderUuid;

    @Column(name="description",nullable = false,unique = true)
    private String description ;

    @Column(name = "total", nullable = false, updatable = false)
    private Double total;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_uuid", nullable = true)
    private Account account;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "membership_uuid", nullable = true)
    private Memberships membership;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_uuid", nullable = true)
    private Location location;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    private TransactionState transactionState;

    public Orders(Account account,Memberships membership,Location location ,String description){
        this.orderUuid = UUID.randomUUID().toString();
        this.account=account;
        this.membership=membership;
        this.location=location;
        this.description=description;
        this.total = total;
        this.createdDate = LocalDateTime.now();
        this.transactionState = TransactionState.valueOf(TransactionState.ON_HOLD.getValue());
    }
}
