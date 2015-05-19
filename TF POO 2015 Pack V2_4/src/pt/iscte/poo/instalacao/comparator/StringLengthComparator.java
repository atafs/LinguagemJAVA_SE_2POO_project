package pt.iscte.poo.instalacao.comparator;

import java.util.Comparator;

import pt.iscte.poo.instalacao.eventos.Evento;

public class StringLengthComparator implements Comparator<Evento> {

	@Override
	public int compare(Evento x, Evento y) {
		if (x.getTempo() < y.getTempo()) {
			return -1;
		}
		if (x.getTempo() > y.getTempo()) {
			return 1;
		}
		return 0;
	}
	
}
