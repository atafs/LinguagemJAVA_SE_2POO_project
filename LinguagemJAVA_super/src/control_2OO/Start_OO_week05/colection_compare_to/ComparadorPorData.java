package control_2OO.Start_OO_week05.colection_compare_to;

import java.util.Comparator;

public class ComparadorPorData implements Comparator<Contact>{

	@Override
	public int compare(Contact c1, Contact c2) {
		return c1.getData().compareTo(c2.getData());
	}

}
