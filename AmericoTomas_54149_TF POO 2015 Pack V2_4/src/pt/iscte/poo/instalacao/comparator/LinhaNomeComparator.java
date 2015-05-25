package pt.iscte.poo.instalacao.comparator;

import java.util.Comparator;

import pt.iscte.poo.instalacao.Linha;

public class LinhaNomeComparator  implements Comparator<Linha>{

	@Override
	public int compare(Linha l1, Linha l2) {
		return l1.getId().compareTo(l2.getId());
	}

}
