
package models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity

  @NamedQueries({
  @NamedQuery(name ="Director.findAll", query = "SELECT d FROM Director d"),
  @NamedQuery(name ="Director.findById", query = "SELECT d FROM Director d WHERE d.id=:id"),
  @NamedQuery(name ="Director.findByName", query = "SELECT d FROM Director d WHERE d.name=:name"),
  @NamedQuery(name ="Director.findByAge", query = "SELECT d FROM Director d WHERE d.age=:age")
  })


public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Basic
    private String name;

    @Basic
    private int age;

    @Basic
    private String gender;

    @OneToMany(targetEntity = Movie.class, mappedBy = "director", cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private List<Movie> movies = new ArrayList<>();

    public Director() {
    }

    public Director(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    
    

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Movie> getMovies() {
        return this.movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "\nid=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender;
    }
     

}