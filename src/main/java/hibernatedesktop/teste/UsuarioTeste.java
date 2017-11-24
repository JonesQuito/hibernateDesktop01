/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatedesktop.teste;

import hibernatedesktop.model.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

/**
 *
 * @author jones-dqo
 */
public class UsuarioTeste {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnidadePU");
        EntityManager manager = factory.createEntityManager();

        // Criando um usuário para ser persistido no banco
        Usuario user = new Usuario();
        user.setLogin("jones-dqo");
        user.setSenha("Jones@SI2015");

        EntityTransaction transaction = manager.getTransaction();
        try {
            
            transaction.begin();
            manager.persist(user);
            transaction.commit();
            
        } catch (Exception e) {
            
            transaction.rollback();
            
        }finally{
            manager.close();
            factory.close();
        }

    }

}
