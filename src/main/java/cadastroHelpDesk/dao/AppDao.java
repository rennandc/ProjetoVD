/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroHelpDesk.dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author sala302b
 */
public abstract class AppDao<T>  {
    
    protected EntityManager em;
    private final Class<T> classe;
    
    public AppDao(Class<T> classe){
        this.classe = classe;
    }
    
    public void inserir(T entidade){
        em = JPAUtil.getEntityManager();//pegando o gerente de entidade
        em.getTransaction().begin();//iniciando a transação        
           em.persist(entidade); //executando o insert
        em.getTransaction().commit(); //finalizando a transação
        em.close();
    }
    
    public void atualizar(T entidade){
        em = JPAUtil.getEntityManager();//pegando o gerente de entidade
        em.getTransaction().begin();//iniciando a transação        
           em.merge(entidade); //executando a atualização
        em.getTransaction().commit(); //finalizando a transação
        em.close();
    }
    
    public void excluir(T entidade){
        em = JPAUtil.getEntityManager();//pegando o gerente de entidade
        em.getTransaction().begin();//iniciando a transação        
           em.remove(em.merge(entidade)); //executando a exclusao
        em.getTransaction().commit(); //finalizando a transação
        em.close();
    }
    
    /**
     * Método utilizado para recuperar uma entidade
     * no banco de dados, através do ID informado
     * @param id (ID da entidade)
     * @return (entidade)
     */
    public T buscar(Long id){
        em = JPAUtil.getEntityManager();//pegando o gerente de entidade
        em.getTransaction().begin();//iniciando a transação        
        T t = em.find(classe, id); //busca o objeto
        em.getTransaction().commit(); //finalizando a transação
        em.close();
        return t;
    }
    
        public List<T> buscarTodos(){
        em = JPAUtil.getEntityManager();//pegando o gerente de entidade
        em.getTransaction().begin();//iniciando a transação        
        List<T> lista;
        
        Query q = em.createQuery("From " + classe.getName());
        
        lista = (List<T>) q.getResultList();
        
        em.getTransaction().commit(); //finalizando a transação
        em.close();
        return lista;
    }
    
    
}
