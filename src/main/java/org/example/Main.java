package org.example;

import entidades.*;

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

            Categoria categoriaElectronica = Categoria.builder().denominacion("Electrónica").build();
            Categoria categoriaRopa = Categoria.builder().denominacion("Ropa").build();
            Categoria categoriaAlimentos = Categoria.builder().denominacion("Alimentos").build();
            Categoria categoriaNecesidadesBasicas = Categoria.builder().denominacion("NecesidadesBasicas").build();


            Articulo articulo1 = Articulo.builder().denominacion("Smartwatch").cantidad(12).precio(25000).build();
            Articulo articulo2 = Articulo.builder().denominacion("Remera").cantidad(50).precio(3000).build();
            Articulo articulo3 = Articulo.builder().denominacion("Pan").cantidad(30).precio(1000).build();
            Articulo articulo4 = Articulo.builder().denominacion("Jeans").cantidad(40).precio(5000).build();
            Articulo articulo5 = Articulo.builder().denominacion("Arroz integral").cantidad(100).precio(200).build();

            articulo2.getCategorias().add(categoriaRopa);
            articulo2.getCategorias().add(categoriaNecesidadesBasicas);
            articulo1.getCategorias().add(categoriaElectronica);
            articulo3.getCategorias().add(categoriaAlimentos);
            articulo3.getCategorias().add(categoriaNecesidadesBasicas);
            articulo4.getCategorias().add(categoriaRopa);
            articulo5.getCategorias().add(categoriaAlimentos);

            categoriaAlimentos.getArticulos().add(articulo3);
            categoriaAlimentos.getArticulos().add(articulo5);
            categoriaElectronica.getArticulos().add(articulo1);
            categoriaRopa.getArticulos().add(articulo2);
            categoriaRopa.getArticulos().add(articulo4);
            categoriaNecesidadesBasicas.getArticulos().add(articulo2);
            categoriaNecesidadesBasicas.getArticulos().add(articulo3);

            DetalleFactura detalle1 = DetalleFactura.builder().cantidad(3).subtotal(75000).articulo(articulo1).build();
            DetalleFactura detalle2 = DetalleFactura.builder().cantidad(5).subtotal(15000).articulo(articulo2).build();
            DetalleFactura detalle3 = DetalleFactura.builder().cantidad(2).subtotal(2000).articulo(articulo3).build();
            DetalleFactura detalle4 = DetalleFactura.builder().cantidad(3).subtotal(15000).articulo(articulo4).build();
            DetalleFactura detalle5 = DetalleFactura.builder().cantidad(5).subtotal(1000).articulo(articulo5).build();


            Factura factura1 = Factura.builder().numero(19).fecha("04/09/2024").build();
            factura1.getDetalles().add(detalle1);
            factura1.getDetalles().add(detalle2);
            factura1.getDetalles().add(detalle3);
            factura1.getDetalles().add(detalle4);
            factura1.getDetalles().add(detalle5);

            factura1.setTotal(detalle1.getSubtotal() + detalle2.getSubtotal() + detalle3.getSubtotal() + detalle4.getSubtotal() + detalle5.getSubtotal());

            Domicilio domicilio1 = Domicilio.builder().nombreCalle("Urquiza").numero(392).build();
            Cliente cliente1 = Cliente.builder().nombre("Sofía").apellido("Villafane").dni(45532485).domicilio(domicilio1).build();

            factura1.setCliente(cliente1);

            entityManager.persist(factura1);



//            //Para traer todos los registros que tenga en la BD
//            Domicilio domicilio2 = entityManager.find(Domicilio.class, 1L);
//            Cliente cli = entityManager.find(Cliente.class, 1L);
//            System.out.println(cli);

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
