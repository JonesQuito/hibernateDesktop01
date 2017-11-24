package hibernatedesktop.model.control;

import hibernatedesktop.model.Usuario;
import hibernatedesktop.view.CadastroUsuarioView;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class CadastroUsuarioControl {
    private Usuario usuario;
    private CadastroUsuarioView viewUsuario;
    
    public CadastroUsuarioControl(CadastroUsuarioView viewUsuario){
        this.viewUsuario = viewUsuario;
        this.usuario = new Usuario();
    }
    
    public void cadastrar(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnidadePU");
        EntityManager manager = factory.createEntityManager();
        
        usuario.setLogin(viewUsuario.getUsuario());
        usuario.setSenha(viewUsuario.getSenha());
        usuario.setPerfil(viewUsuario.getPerfil());
        
        EntityTransaction transaction = manager.getTransaction();
        try {
            
            transaction.begin();
            manager.persist(usuario);
            transaction.commit();
            JOptionPane.showMessageDialog(viewUsuario, "Cadastro realizado com êxito", "Cadastro", 1);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(viewUsuario, "Não foi possível realizar o cadastro", "Erro", 0);
            transaction.rollback();
            
        }finally{
            manager.close();
            factory.close();
        }
        
    }
    
}
