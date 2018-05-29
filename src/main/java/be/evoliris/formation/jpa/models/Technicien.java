package be.evoliris.formation.jpa.models;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OrderColumn;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Technicien extends Personnel {
    //region attribut
    @Column(name = "technicien_cout_heure_sup") private double coutHeureSupplementaire;
    @ElementCollection @OrderColumn
    private List<String> machines;
    //endregion
    //region propriété de navigation

    //endregion

    //region constructors
    public Technicien(){
        super();
        this.machines = new ArrayList<>();
    }
    public Technicien(String nom, String prenom, Double salaire, LocalDate dateEmploie, String adresse, Service service, double coutHeureSupplementaire) {
        super(nom, prenom, salaire, dateEmploie, adresse, service);
        this.coutHeureSupplementaire = coutHeureSupplementaire;
        this.machines = new ArrayList<>();
    }
    //endregion

    //region getters && setters
    public double getCoutHeureSupplementaire() {
        return coutHeureSupplementaire;
    }
    public void setCoutHeureSupplementaire(double coutHeureSupplementaire) {
        this.coutHeureSupplementaire = coutHeureSupplementaire;
    }

    public List<String> getMachines() {
        return machines;
    }
    public void setMachines(List<String> machines) {
        this.machines = machines;
    }
    //endregion

    public void addMachine(String numero){
        if(machines.contains(numero))return;
        machines.add(numero);
    }
    public void removeMachine(String numero){
        if(!machines.contains(numero))return;
        machines.remove(numero);
    }

    @Override public boolean equals(Object o) {
        return super.equals(o);
    }
    @Override public int hashCode() {
        return Objects.hash(super.hashCode(), coutHeureSupplementaire, machines);
    }
    @Override public String toString() {
        return "Technicien{" +
                "employe= '"+ super.toString()+ "\'"+
                ", coutHeureSupplementaire=" + coutHeureSupplementaire +
                ", machines=" + machines +
                '}';
    }
}
