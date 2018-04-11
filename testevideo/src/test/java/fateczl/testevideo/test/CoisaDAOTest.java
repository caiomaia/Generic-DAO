package fateczl.testevideo.test;

import org.junit.Ignore;
import org.junit.Test;

import fateczl.testevideo.dao.CoisaDAO;
import fateczl.testevideo.domain.Coisa;

public class CoisaDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		Coisa coisa = new Coisa();
		coisa.setCodigo(0L);
		coisa.setNome("LABORATORIO DE ENGENHARIA");
		
		CoisaDAO coisaDAO = new CoisaDAO();
		coisaDAO.salvar(coisa);
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 0L; 
		CoisaDAO CoisaDAO = new CoisaDAO();
		Coisa Coisa = CoisaDAO.buscar(codigo);
		if (Coisa == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro encontrado");
			System.out.println(Coisa.getCodigo() + "-" + Coisa.getNome());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 1L;
		CoisaDAO CoisaDAO = new CoisaDAO();
		Coisa coisa = CoisaDAO.buscar(codigo);
		if (coisa == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			CoisaDAO.excluir(coisa);
		}
	}
	
}
