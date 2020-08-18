package businessObject;

public class Locale {

    private String country;
    private String location;

    public Locale setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public String getLocation() {
        return location;
    }

    public Locale setLocation(String location) {
        this.location = location;
        return this;
    }
}
