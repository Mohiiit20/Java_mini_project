package Model;
// company class which contains attributes common for companies
abstract public class Company {

    private int id;
    private String name;
    private String email;
    private String country_of_origin;

    public Company(int id, String name, String email, String country_of_origin) {
        setAirlineId(id);
        setName(name);
        setEmail(email);
        setCountry_of_origin(country_of_origin);

    }

    public void setAirlineId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCountry_of_origin(String country_of_origin) {
        this.country_of_origin = country_of_origin;
    }

    public int getAirlineId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCountry_of_origin() {
        return this.country_of_origin;
    }



     abstract String ConvertNameToCode(String name);
    final public String display_()
    {
        return ( " Name : "+getName()+ ", CountryofOrigin  : "+getCountry_of_origin());
    }




}
