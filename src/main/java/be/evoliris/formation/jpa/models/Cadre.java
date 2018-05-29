package be.evoliris.formation.jpa.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Cadre extends Personnel{
    //region attribut

    //endregion
    //region propriete de navigation
    @OneToOne(targetEntity = Salle.class)
    private Salle bureau;
    @OneToMany(targetEntity = Administratif.class, mappedBy = "responsable")
    private List<Administratif> administratifs;
    //endregion

    //region constructors
    public Cadre() {
        super();
        this.administratifs = new ArrayList<>();
    }
    public Cadre(String nom, String prenom, Double salaire, LocalDate dateEmploie, String adresse, Service serviceDirige, Salle bureau) {
        super(nom, prenom, salaire, dateEmploie, adresse, serviceDirige);
        this.bureau = bureau;
        this.administratifs = new ArrayList<>();
    }
    //endregion

    //region getters && setters
    public Salle getBureau() {
        return bureau;
    }
    public void setBureau(Salle bureau) {
        this.bureau = bureau;
    }

    public List<Administratif> getAdministratifs() {
        return administratifs;
    }
    public void setAdministratifs(List<Administratif> administratifs) {
        this.administratifs = administratifs;
    }
    //endregion

    public void addAdministratif(Administratif administratif){
        if(administratifs.contains(administratif))return;
        administratifs.add(administratif);
    }
    public void removeAdministratif(Administratif administratif){
        if(!administratifs.contains(administratif))return;
        administratifs.remove(administratif);
    }

    @Override public boolean equals(Object o) {
        return super.equals(o);
    }
    @Override public int hashCode() {
        return Objects.hash(super.hashCode(), bureau.hashCode(), administratifs);
    }
    @Override public String toString() {
        return "Cadre{" +
                "employe= "+ super.toString()+
                ", bureau=" + bureau +
                ", administratifs=" + administratifs +
                '}';
    }
}
