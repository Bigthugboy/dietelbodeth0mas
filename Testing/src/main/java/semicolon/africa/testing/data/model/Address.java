package semicolon.africa.testing.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
//@Document
public class Address {
    // @Id
    //  private String id;
    private String country;
    private String city;
    private int postcode;


    public Address() {
//        Address address = new Address();
//        address.setCity("lagos");
//        address.setCountry("nigeria");
//        address.setPostcode(100001);
//        List<Address> addresses = new ArrayList<>();
//        addresses.add(address);
    }
}
