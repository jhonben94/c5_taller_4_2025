package py.edu.ucom.taller.models.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
public class Players {
     
    @Id 
    @GeneratedValue
    Integer idPlayer;
    String name;
    String lastName;
    public Integer getIdPlayer() {
        return idPlayer;
    }
    public void setIdPlayer(Integer idPlayer) {
        this.idPlayer = idPlayer;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    
}
