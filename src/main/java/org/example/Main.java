package org.example;

import entidades.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mi-unidad-de-persistencia");

        EntityManager entityManager = entityManagerFactory.createEntityManager();


        try {
            // Iniciar una transacción
            entityManager.getTransaction().begin();

//            Cliente cliente1 = new Cliente().builder().nombre("Lionel").apellido("Messi").dni(123456789).build();
//
//            entityManager.persist(cliente1);

            //Para limpiar la conexión
            entityManager.flush();

            //Termina de persistir el objeto en la BD
            entityManager.getTransaction().commit();




        }catch (Exception e){

            //Evitar errores
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("No se pudo grabar.");}

        // Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}
