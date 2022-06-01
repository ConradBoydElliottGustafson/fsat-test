package ca.cgi.fsa.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.lang.NonNull;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cityId;

    @Column(nullable = false)
    private String cityName;

    @OneToOne(mappedBy = "city")
    private Person person;

    City() {

    }

    public City(String inCityName) {
        this.cityName = inCityName;
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof City))
            return false;
        City city = (City) o;
        return Objects.equals(this.cityId, city.cityId) && Objects.equals(this.cityName, city.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.cityId, this.cityName);
    }

    @Override
    public String toString() {
        return "City{" + "cityId=" + this.cityId + ", CityName='" + this.cityName + '\'' + '}';
    }

}