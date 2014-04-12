package br.unirn.exemplos.dao;

import java.util.Collection;

import org.hibernate.Session;

/**
 * Interface que indica os m�todos dos daos
 * 
 * @author RAUL
 * 
 * @param <T>
 *            Classe template para os Daos
 */
public interface InterfaceDao<T> {

	/**
	 * cria um item da classe no banco
	 * 
	 * @param entity
	 *            Objeto
	 */
	public void save(T entity);

	/**
	 * Atualiza um item da classe no banco
	 * 
	 * @param entity
	 *            Objeto
	 */
	public void update(T entity);

	/**
	 * Deleta um item da classe no banco
	 * 
	 * @param entity
	 *            Objeto
	 */
	public void delete(T entity);

	/**
	 * Busca um item da classe no banco
	 * 
	 * @param id
	 *            id do objeto
	 */
	public T find(int id);

	/**
	 * Encontra todas as ocorr�ncias da entidade
	 * 
	 * @return lista de todos os itens da entidade
	 */
	public Collection<T> findAll();

	/**
	 * Pega a sess�o aberta (se tiver fechada, abre)
	 * 
	 * @return sess�o
	 */
	public Session getSession();

	/**
	 * Fecha Sess�o
	 */
	public void close();

	/**
	 * Seta a sess�o
	 * 
	 * @param session
	 *            sess�o
	 */
	public void setSession(Session session);

}
