package seng202.group5;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */

    public void testApp()
    {
        assertTrue( true );
        assertTrue( 1 + 2 != 2 );
    }

    /**
     * Git push test
     */
    public void testgit()
    {
        assertTrue( 1 != 2 );
    }

    /**
     *  Shivin's random test
     */

    public void testing()
    {
        assertTrue( true);
        assertTrue( 2 * 2 != 5);
    }

    public void test1() {
        assertTrue(1+2 == 3);
    }
    public void testanother() {
        boolean cool = false;
        assertFalse(cool == true);
        cool = false;
        assertTrue(cool == false);
    }
    public void testJames() {
        assertTrue(3 + 2 != 10);
    }
}

