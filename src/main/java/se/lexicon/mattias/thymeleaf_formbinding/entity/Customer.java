package se.lexicon.mattias.thymeleaf_formbinding.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer customerId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "regDate")
    private LocalDate regDate;

    @Column(name = "active")
    private boolean active;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id")
    private CustomerDetails details;


    /** Constructors **/

    public Customer() {
    }


    public Customer(String name, String email, CustomerDetails details) {
        this.regDate = LocalDate.now();
        this.active = true;
        this.name = name;
        this.email = email;
        this.details = details;
    }

    public Customer(Integer customerId, String name, String email, CustomerDetails details) {
        /** Generate ID **/
        this.customerId = customerId;

        /** Set values (Date today, active = true **/
        this.regDate = LocalDate.now();
        this.active = true;

        /** Get information to email and details **/
        this.name = name;
        this.email = email;
        this.details = details;
    }


    /** Getters and setters **/

    public Integer getCustomerId() {
        return customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
/**
    public CustomerDetails getDetails() {
        return details;
    }

    public void setDetails(CustomerDetails details) {
        this.details = details;
    }
**/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /** To string **/

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", regDate=" + regDate +
                ", active=" + active +
                '}';
    }


}
