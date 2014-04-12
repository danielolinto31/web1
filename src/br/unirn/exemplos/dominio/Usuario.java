package br.unirn.exemplos.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @author Daniel Olinto
 * 
 */

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@Column(name = "id_usuario")
	@GenericGenerator(name = "public.log_seq", strategy = "sequence")
	@GeneratedValue(generator = "public.log_seq")
	int id;

	@Column(name = "nome")
	String nome;

	@Column(name = "login")
	String login;

	@Column(name = "senha")
	String senha;

	@Column(name = "descricaoPessoal")
	String descricaoPessoal;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dataCadastro")
	Date dataCadastro;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDescricaoPessoal() {
		return descricaoPessoal;
	}

	public void setDescricaoPessoal(String descricaoPessoal) {
		this.descricaoPessoal = descricaoPessoal;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
