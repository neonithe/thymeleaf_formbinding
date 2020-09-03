package se.lexicon.mattias.thymeleaf_formbinding.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerDTO {

    /** Error messages **/
    public static final String NAME_ERROR       = "Name has to few characters";
    public static final String EMAIL_ERROR      = "Email not valid";
    public static final String STREET_ERROR     = "Street has to few characters";
    public static final String ZIPCODE_ERROR    = "Must contain at least 5 characters";
    public static final String CITY_ERROR       = "City has to few characters";
    public static final String HOMEPHONE_ERROR  = "Must contain min 9 numbers";
    public static final String MOBILE_ERROR     = "Must contain min 10 numbers";

    /** REGEX - Input rules **/
    public static final String EMAIL_RULE       = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$";
    public static final String ZIPCODE_RULE     = "^\\d{5}(-\\d{4})?$";
    public static final String HOMEPHONE_RULE   = "^[0-9- ]{0,9}$";
    public static final String MOBILE_RULE      = "^[0-9- ]{0,10}$";


    /** Data Transfer Object **/

    @NotBlank(message = "Name is required")
    @Size(min = 1, max = 100, message = NAME_ERROR)
    private String name;

    @NotBlank(message = "E-mail is required")
    @Email(regexp = EMAIL_RULE, message = EMAIL_ERROR)
    private String email;

    @Size(min = 1, max = 100, message = STREET_ERROR)
    private String street;

    @Pattern(regexp = ZIPCODE_RULE, message = ZIPCODE_ERROR, flags = Pattern.Flag.CASE_INSENSITIVE)
    private String zipCode;

    @Size(min = 1, max = 100, message = CITY_ERROR)
    private String city;

    @Pattern(regexp = HOMEPHONE_RULE, message = HOMEPHONE_ERROR, flags = Pattern.Flag.CASE_INSENSITIVE)
    private String homePhone;

    @Pattern(regexp = MOBILE_RULE, message = MOBILE_RULE, flags = Pattern.Flag.CASE_INSENSITIVE)
    private String mobile;


    /** Getters and setters **/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
