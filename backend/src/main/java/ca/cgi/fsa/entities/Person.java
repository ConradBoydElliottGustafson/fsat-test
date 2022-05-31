package ca.cgi.fsa.entities;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CollectionId;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long personId;

    @Column(nullable = false)
    private String firstName;
    private String lastName;
    @Column(nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;

    Person() {

    }

    public Person(String inFirstName, String inLastName, String inEmail) {
        this.firstName = inFirstName;
        this.lastName = inLastName;
        this.email = inEmail;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Person))
            return false;
        Person Person = (Person) o;
        return Objects.equals(this.personId, Person.personId) && Objects.equals(this.firstName, Person.firstName)
                && Objects.equals(this.lastName, Person.lastName) && Objects.equals(this.email, Person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.personId, this.firstName, this.lastName, this.email);
    }

    @Override
    public String toString() {
        return "Person {" + "PersonId=" + this.personId + ", FirstName='" + this.firstName + ", LastName='"
                + this.lastName
                + ", email='" + this.email + '\'' + '}';
    }

}