package hr.ferit.lv8;

public class User {
    private int id;
    private String name;
    private Address address;

    @Override
    public String toString() {
        return id + "\n" + name + '\n' + address;
    }
}
