package be.evoliris.formation.jpa.models;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Administratif extends Personnel{
    //region attribut
    @Column(name = "administratif_cout_heure_sup")
    private double coutHeureSupplementaire;
    //endregion
    //region propriété de navigation
    @ManyToOne(targetEntity = Cadre.class, fetch = FetchType.LAZY)
    @ColumnDefault(value = "null")
    private Cadre responsable = null;
    //endregion

    public double getCoutHeureSupplementaire() {
        return coutHeureSupplementaire;
    }
    public void setCoutHeureSupplementaire(double coutHeureSupplementaire) {
        this.coutHeureSupplementaire = coutHeureSupplementaire;
    }

    public Cadre getResponsable() {
        return responsable;
    }
    public void setResponsable(Cadre responsable) {
        this.responsable = responsable;
    }

    @Override public boolean equals(Object o) {
        return super.equals(o);
    }
    @Override public int hashCode() {
        return Objects.hash(super.hashCode(), coutHeureSupplementaire, responsable);
    }
    @Override public String toString() {
        return "Administratif{" +
                "employe= '"+ super.toString()+ "\'"+
                ", coutHeureSupplementaire=" + coutHeureSupplementaire +
                ", responsable=" + responsable +
                '}';
    }
}
