package fateczl.testevideo.dao;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fateczl.testevideo.util.HibernateUtil;

public class GenericDAO<Entidade> {
	private Class<Entidade> classe;
	
	public GenericDAO(){
		this.classe = (Class<Entidade>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void salvar(Entidade entidade){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.merge(entidade);
			transacao.commit();
		} catch (RuntimeException erro){
			if(transacao != null){
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}
		
		public Entidade buscar(Long codigo){
			Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
			Entidade resultado = null;
			try {
				resultado = sessao.find(classe, codigo);
				return resultado;
			} catch (RuntimeException erro){
				throw erro;
			} finally {
				sessao.close();
			}
		}
		
		public void excluir(Entidade entidade){
			Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
			Transaction transacao = null;
			try {
				transacao = sessao.beginTransaction();
				sessao.delete(entidade);
				transacao.commit();
			} catch (RuntimeException erro){
				if(transacao != null){
					transacao.rollback();
				}
				throw erro;
			}
			finally {
				sessao.close();
			}
		}
	}


