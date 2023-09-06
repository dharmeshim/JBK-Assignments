package hibernate.crud;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Logdetails {

    @Id
    private int id;
    private String name;
    private String email;

    public  Logdetails(){

    }
    public Logdetails(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "hibernate.crud.Logdetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
