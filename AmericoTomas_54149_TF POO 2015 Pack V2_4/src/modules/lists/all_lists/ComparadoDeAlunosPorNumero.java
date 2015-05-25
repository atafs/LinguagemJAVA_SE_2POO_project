package modules.lists.all_lists;

import java.util.Comparator;

public class ComparadoDeAlunosPorNumero implements Comparator<Aluno> {

	@Override
	public int compare(Aluno o1, Aluno o2) {
		return (int)(o1.getNumero() - o2.getNumero());
	}

}
