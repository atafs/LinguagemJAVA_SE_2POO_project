/** 
 * americoLIB concept 
 * @author Americo Tomas (atafs): 12/03/2015 
*/

package modules.lists.phonebook_arraylist;

public interface PhoneBook {
	
	public void addEntry(final String name, int number);
	public String getName(int number);
	public int getNumber(final String name);
	public void remove(final String name);
	public boolean contains(int number);
	public String toString();
	

}
