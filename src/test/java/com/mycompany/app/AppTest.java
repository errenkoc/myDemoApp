package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;
import java.util.Arrays;



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
    }
   public void testFoundin1() {
      int [] arr1= new int[]{1,2,3,4};
      int [] arr2= new int[]{5,6,7,8};
      assertTrue(new App().search(arr1, arr2, 2, 2));
    }
   public void testFoundin2() {
      int [] arr1= new int[]{1,2,3,4};
      int [] arr2= new int[]{5,6,7,8};
      assertTrue(new App().search(arr1, arr2, 2, 3));
    }
   public void testFoundinboth() {
      int [] arr1= new int[]{1,2,3,4};
      int [] arr2= new int[]{4,5,6,7};
      assertFalse(new App().search(arr1, arr2, 2, 2));
    }
    public void testNotFound() {
      int [] arr1= new int[]{1,2,3,4};
      int [] arr2= new int[]{5,6,7,8};
      assertFalse(new App().search(arr1, arr2, 2, 5));
    }
    public void testEmptyArray1() {
      int [] arr1= new int[5];
      int [] arr2= new int[]{1,2,3,4};
      assertFalse(new App().search(arr1, arr2, 2, 3));
    }
    public void testEmptyArray2() {
      int [] arr1= new int[]{1,2,3,4};
      int [] arr2= new int[5];
      assertFalse(new App().search(arr1, arr2, 2, 3));
    }
}
