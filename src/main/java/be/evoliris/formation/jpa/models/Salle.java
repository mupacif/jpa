package be.evoliris.formation.jpa.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Salle {
    //region attribute
    @Id @Column(name = "salle_id") @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "salle_nom") private String nom;
    //endregion
    //region propriete de navigation

    //endregion


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salle salle = (Salle) o;
        return Objects.equals(id, salle.id);
    }
    @Override public int hashCode() {
        return Objects.hash(id, nom);
    }
    @Override public String toString() {
        return "Salle{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
