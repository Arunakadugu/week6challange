package me.aruna.week6challange;

import javax.persistence.*;
import java.util.Set;
@Entity
public class UserTransaction {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(unique=true)
    private String role;

    @ManyToMany(mappedBy = "transactions",fetch=FetchType.LAZY)
    private Set<UserTransaction> transactions;

    public UserTransaction(String transaction) {
        this.transactions =transactions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTransaction() {
        return "transaction";
    }

    public void setTransaction(String transaction) {
        this.transactions =transactions;
    }

    public Set<UserTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<UserTransaction> transactions) {
        this.transactions = transactions;
    }
}


