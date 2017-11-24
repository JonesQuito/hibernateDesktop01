package hibernatedesktop.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jones-dqo
 */

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
    
    private String login;
    private String senha;
    private String perfil;

    @Id
    @Column(name = "login", nullable = false, length = 50)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "senha", nullable = false,  length = 10, unique = true)
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Column(name = "perfil", length = 30, nullable = false)
    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
}
