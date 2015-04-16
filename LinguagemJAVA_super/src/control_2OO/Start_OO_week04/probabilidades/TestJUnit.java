/** 
 * americoLIB concept 
 * @author Americo Tomas (atafs): 05/03/2015 
*/

package control_2OO.Start_OO_week04.probabilidades;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestJUnit {

	@SuppressWarnings("unused")
	@Test
	public void test() {
		double value = 0.5;
		Probabilidades prob = new Probabilidades(0.5);
		
		//GARANTY THAT IS BEING WELL CREATED
		assertNotNull(prob);
		
		//EQUALS
		assertEquals(0.5,  prob.doubleValue(), 0.0001);
		assertEquals(0.5,  prob.floatValue(), 0);
		assertEquals(1,  prob.intValue(), 0.0001);
		assertEquals(0,  prob.longValue(), 0.0001);
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test2() {
		new Probabilidades(20);
	}

}
