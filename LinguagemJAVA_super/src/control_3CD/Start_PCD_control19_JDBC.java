package control_3CD;

import pt.progJava.americoLib.control19.bean.Pessoa;
import pt.progJava.americoLib.control19.db.PessoaDao;

public class Start_PCD_control19_JDBC {

	public static void main(String[] args) {

		Pessoa p1 = new Pessoa();
		p1.setNome("Amer");
		p1.setDdd("62");
		p1.setEmail("atafs@iscte-iul.pt");
		p1.setCpf("12345678910");
		p1.setFone("917639454");
		
		PessoaDao pd = new PessoaDao();
		pd.salvar(p1);
	}

}
