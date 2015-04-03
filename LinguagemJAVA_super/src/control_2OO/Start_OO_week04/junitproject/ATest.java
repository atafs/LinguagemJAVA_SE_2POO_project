package control_2OO.Start_OO_week04.junitproject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * 
 */

/**
 * @author lmmn
 *
 */
public class ATest {

	private A oneA;
	private A anotherA;
	private A yetAnotherA;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		oneA = new A(1, "1");
		anotherA = new A(1, "1");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void notNull() {
		Assert.assertNotNull(anotherA.getX());
	}
	
	@Test
	public void equal() {
		Assert.assertEquals(oneA.getId(), anotherA.getId());
		Assert.assertEquals(oneA.getX(), anotherA.getX());
	}
	
	@Test
	public void notTheSame() {
		Assert.assertNotSame(oneA, anotherA);
	}
	
	@Test(expected=NullPointerException.class)
	public void nullPointer() {
		yetAnotherA.getId();
	}
	
	@Test
	public void shouldFail() {
		//should fail the test
		Assert.assertSame(oneA, anotherA);
	}
	
	@Test
	public void unexpectedFail() {
		//should fail to finish "unexpectedly"
		yetAnotherA.getX();
	}

	@Test(timeout=100)
	public void shouldntTakeThisLong() {
		//should fail by timeout (unless your computer is very fast)
		for (int i = 0; i != -1; ++i) {
			notATest();
		}
	}
	
	@Ignore
	public void notATest() {
		// Auxiliary code for other test
	}
}
