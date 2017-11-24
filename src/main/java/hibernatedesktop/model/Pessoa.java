package hibernatedesktop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // mapeia a classe Pessoa como uma entidade do banco de dados
@Table(name = "pessoa") //cria uma tabela pessoa correspondente à classe Pessoa
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	
	@Id  //Mapeia o atributo id como chave primária na tabela pessoa
	@GeneratedValue  //Especifica que o valor do id será gerado como auto incremento
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(length = 60, nullable = false)
	public String getNome() {
		return nome;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
