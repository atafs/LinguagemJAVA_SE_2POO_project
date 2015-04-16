package control_0Pattern.observer;

import pt.progJava.americoLib.control100.Child;
import pt.progJava.americoLib.control100.Dog;
import pt.progJava.americoLib.control100.Person;

public class Start_OBSERVER_Dog_Person_Child_control100 {
	
	public static void main(String[] args) {
		
		Dog dog1 = new Dog("Husky");
		Dog dog2 = new Dog("Tufa");
		
		Person person1 = new Person("Americo");
		Child child = new Child("Tomas");
		
		dog1.addDogListener(person1);
		dog1.addDogListener(child.getListener());

		dog2.addDogListener(person1);
		dog2.addDogListener(child.getListener());

	}

}
