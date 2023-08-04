package com.idat.mzgym.model;

import com.idat.mzgym.util.enums.TransactionState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="transaction", discriminatorType= DiscriminatorType.STRING)
@Entity
@Table(name = "TRANSACTIONS")
public class Transactions implements Serializable {

    @Id
    @Column(name = "transaction_uuid",nullable = false,unique = true)
    private String transactionUuid;

    @Column(name = "total", nullable = false, updatable = false)
    private Double total;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    private TransactionState transactionState;

    public Transactions(Double total){
        this.transactionUuid = UUID.randomUUID().toString();
        this.total = total;
        this.createdDate = LocalDateTime.now();
        this.transactionState = TransactionState.valueOf(TransactionState.ON_HOLD.getValue());
    }
}
