package be.evoliris.formation.jpa.models;

public enum Machines {
    INFORMATIQUE_CHEF("MI 101", "Machine du responsable informatique"),
    INFORMATIQUE_SALLE_1_PC1("MI 111", "Machine 1 de la salle 1"),
    INFORMATIQUE_SALLE_1_PC2("MI 112", "Machine 2 de la salle 1");

    private String numero;
    private String nom;
    private Machines(String numero, String nom){ this.numero = numero; this.nom = nom; }

    public String getNom() {
        return nom;
    }
    public String getNumero(){
        return this.numero;
    }

    public static Machines getMachineByNumero(String numero){
        for(Machines machines : Machines.values()){
            if(machines.numero.equals(numero))return machines;
        }
        return null;
    }
}
