package hr.ferit.lv8;

public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;

    @Override
    public String toString() {
        return street + '\n' + suite + '\n' + city + '\n' + zipcode + '\n';
    }
}
