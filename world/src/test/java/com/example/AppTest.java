package com.example;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest 
{
	private App app;
		public AppTest(){
			app = new App();
		}

    @Test
    public void myTest(){
    	assertNotNull(app);
    }
/*    @Test
    public void myTest1(){
    	String testMessage = Hi! 이진웅 Good Morning;
    	assertEquals(app.getMessage("이진웅"),testMessage);
    }*/
    /*public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }*/
}
 