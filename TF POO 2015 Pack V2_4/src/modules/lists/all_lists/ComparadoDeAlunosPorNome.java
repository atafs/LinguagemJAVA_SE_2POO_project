package modules.lists.all_lists;

import java.util.Comparator;

public class ComparadoDeAlunosPorNome implements Comparator<Aluno> {

	@Override
	public int compare(Aluno a0, Aluno a1) {		
		return a0.getNome().compareTo(a1.getNome());
	}

}
