package be.evoliris.formation.jpa;

import be.evoliris.formation.jpa.models.*;

import javax.persistence.*;
import javax.transaction.Transaction;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        //region create manager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("db");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        //endregion
//        Service service = new Service();
//        service.setNom("Informatique");
//
//        Salle salle1 = new Salle();
//        salle1.setNom("Salle 1");
//        Salle salle2 = new Salle();
//        salle2.setNom("Salle 2");
//        Salle bureau1 = new Salle();
//        bureau1.setNom("B 314");
//
//        service.addSalle(salle1);
//        service.addSalle(salle2);
//
//        Cadre cadre = new Cadre();
//        cadre.setNom("Ovyn");
//        cadre.setPrenom("Flavian");
//        cadre.setSalaire(1500.0);
//        cadre.setAdresse("Rue du cadre 57, 1000 Bruxelles");
//        cadre.setBureau(bureau1);
//        cadre.setService(service);
//
//        service.setChef(cadre);
//
//        et.begin();
//        em.persist(salle1);
//        em.persist(salle2);
//        em.persist(bureau1);
//        em.persist(cadre);
//        em.persist(service);
//
//        et.commit();

        Service informatiqueService = em.find(Service.class, 5L);
//        Salle salle2 = em.find(Salle.class, 2L);
//        informatiqueService.addSalle(salle2);
//
//        et.begin();
//        em.merge(informatiqueService);
//        et.commit();
//
//        System.out.println(informatiqueService);
        Technicien technicien = em.find(Technicien.class, 6L);

        for(String machine : technicien.getMachines()){
            Machines machineType = Machines.getMachineByNumero(machine);
            System.out.println(machineType.getNom());
        }

        //region close manager
        em.close();
        emf.close();
        //endregion
    }

}
