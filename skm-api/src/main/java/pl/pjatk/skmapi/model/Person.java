package pl.pjatk.skmapi.model;

import com.github.javafaker.Faker;
import pl.pjatk.skmapi.service.DbEntity;

import javax.persistence.*;
import java.util.Locale;

@Entity
@Table(name = "people")
public class Person implements DbEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Station dest;
    private String name;
    private String lastname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id")
    private Section section;

    public Person() {
    }

    public Person(Station dest) {
        Faker faker = new Faker(new Locale("pl-PL"));
        this.setDest(dest);
        setName(faker.name().firstName());
        setLastname(lastname = faker.name().lastName());
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Station getDest() {
        return dest;
    }

    public void setDest(Station dest) {
        this.dest = dest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
