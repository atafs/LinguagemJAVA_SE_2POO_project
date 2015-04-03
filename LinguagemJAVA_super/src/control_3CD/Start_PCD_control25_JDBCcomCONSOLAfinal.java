package control_3CD;

import java.util.List;

import pt.progJava.americoLib.control25.bean.Pessoa;
import pt.progJava.americoLib.control25.dao.PessoaDao;

public class Start_PCD_control25_JDBCcomCONSOLAfinal {

	public static void main(String[] args) {

		Pessoa p = new Pessoa();
		p.setCpf("0202020202");
		p.setDdd("62");
		p.setEmail("fdadsfsdfds@gmail.com");
		p.setFone("214578963");
		p.setNome("AmGuida");
		p.setId(62);
	
		PessoaDao pd = new PessoaDao();
		pd.insert(p);

		@SuppressWarnings("unchecked")
		List<Pessoa> pessoas = pd.select();
		for (Pessoa pessoa2 : pessoas) {
			System.out.println(pessoa2.getNome());
		}
		System.out.println();
		
		Pessoa p1 = (Pessoa)pd.select(29);
		System.out.println(p1.getNome());
		
		PessoaDao pd1 = new PessoaDao();
		
		pd1.update(p);
//		pd1.delete(p);
		
		
	}

}
