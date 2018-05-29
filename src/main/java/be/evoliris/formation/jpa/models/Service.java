package be.evoliris.formation.jpa.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "service", uniqueConstraints = @UniqueConstraint(name = "UK_Service_Nom", columnNames = {"service_nom"}))
public class Service {
    //region attribut
    @Id @Column(name = "service_id") @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "service_nom") private String nom;
    //endregion
    //region propriété de navigation
    @OneToMany(targetEntity = Salle.class)
    private List<Salle> salles;
    @OneToOne(targetEntity = Cadre.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "cadre_id")
    private Cadre chef;
    @OneToMany(targetEntity = Personnel.class, mappedBy = "service", fetch = FetchType.LAZY)
    private List<Personnel> membres;
    //endregion

    //region constructors
    public Service() {
        this.salles = new ArrayList<>();
        this.membres = new ArrayList<>();
    }
    public Service(Long id, String nom, Cadre chef) {
        this.id = id;
        this.nom = nom;
        this.chef = chef;
        this.salles = new ArrayList<>();
        this.membres = new ArrayList<>();
    }
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

    public List<Salle> getSalles() {
        return salles;
    }
    public void setSalles(List<Salle> salles) {
        this.salles = salles;
    }

    public Cadre getChef() {
        return chef;
    }
    public void setChef(Cadre chef) {
        this.chef = chef;
    }

    public List<Personnel> getMembres() {
        return membres;
    }
    public void setMembres(List<Personnel> membres) {
        this.membres = membres;
    }

    public void addMembre(Personnel personnel){
        if(membres.contains(personnel))return;
        membres.add(personnel);
    }
    public void removeMembre(Personnel personnel){
        if(!membres.contains(personnel))return;
        membres.remove(personnel);
    }

    public void addSalle(Salle salle){
        if(salles.contains(salle))return;
        salles.add(salle);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return Objects.equals(id, service.id);
    }
    @Override public int hashCode() {
        return Objects.hash(id, nom, salles, chef, membres);
    }
    @Override public String toString() {
        return "Service{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", salles=" + salles +
                ", chef=" + chef +
                '}';
    }
}
