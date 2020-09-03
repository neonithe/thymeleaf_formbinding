package se.lexicon.mattias.thymeleaf_formbinding.entity;

import javax.persistence.*;

@Entity
@Table(name = "details")
public class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer detailsId;

    @Column(name = "street")
    private String street;

    @Column(name = "zipCode")
    private String zipCode;

    @Column(name = "city")
    private String city;

    @Column(name = "homePhone")
    private String homePhone;

    @Column(name = "mobile")
    private String mobile;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "details")
    private Customer customer;

        /** Constructors **/

        public CustomerDetails(String street, String zipCode, String city, String homePhone, String mobile) {
            this.street = street;
            this.zipCode = zipCode;
            this.city = city;
            this.homePhone = homePhone;
            this.mobile = mobile;
        }

        public CustomerDetails() {
        }

    public CustomerDetails(Integer detailsId, String street, String zipCode, String city, String homePhone, String mobile) {
        this.detailsId = detailsId;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.homePhone = homePhone;
        this.mobile = mobile;
    }



        /** Getters and setters **/

        public Integer getDetailsId() {
            return detailsId;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getHomePhone() {
            return homePhone;
        }

        public void setHomePhone(String homePhone) {
            this.homePhone = homePhone;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /** To string **/

        @Override
        public String toString() {
            return "CustomerDetails{" +
                    "detailsId='" + detailsId + '\'' +
                    ", street='" + street + '\'' +
                    ", zipCode='" + zipCode + '\'' +
                    ", city='" + city + '\'' +
                    ", homePhone='" + homePhone + '\'' +
                    ", mobile='" + mobile + '\'' +
                    '}';
        }

}
