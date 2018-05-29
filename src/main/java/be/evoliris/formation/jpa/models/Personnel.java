package be.evoliris.formation.jpa.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Personnel {
    //region attribut
    @Id @Column(name = "personnel_id") @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "personnel_nom") private String nom;
    @Column(name = "personnel_prenom") private String prenom;
    @Column(name = "personnel_salaire") private Double salaire;
    @Column(name = "personnel_date_emploie") private LocalDate dateEmploie;
    @Column(name = "personnel_adresse") private String adresse;
    //endregion
    //region propriété de navigation
    @ManyToOne(targetEntity = Service.class, fetch = FetchType.LAZY)
    private Service service;
    //endregion

    //region constructors
    public Personnel() {
    }
    public Personnel(String nom, String prenom, Double salaire, LocalDate dateEmploie, String adresse, Service service) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.salaire = salaire;
        this.dateEmploie = dateEmploie;
        this.adresse = adresse;
        this.service = service;
    }
    //endregion

    //region getters && setters
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

    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Double getSalaire() {
        return salaire;
    }
    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public LocalDate getDateEmploie() {
        return dateEmploie;
    }
    public void setDateEmploie(LocalDate dateEmploie) {
        this.dateEmploie = dateEmploie;
    }

    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Service getService() {
        return service;
    }
    public void setService(Service service) {
        this.service = service;
    }
    //endregion

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Personnel)) return false;
        Personnel personnel = (Personnel) o;
        return Objects.equals(id, personnel.id);
    }
    @Override public int hashCode() {
        return Objects.hash(id, nom, prenom, salaire, dateEmploie, adresse, service);
    }
    @Override public String toString() {
        return "Personnel{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", salaire='" + salaire + '\'' +
                ", dateEmploie=" + dateEmploie +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
