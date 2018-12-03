import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.Hello;
import com.example.Printer;
import com.example.StringPrinter;

public class TestApp {

	private ApplicationContext ctx;
	
	@Before
	public void init() {
		this.ctx = new GenericXmlApplicationContext("classpath:config/beans.xml");
	}
	
	@Test
	public void test() {
		assertNotNull(this.ctx);
	}
	
	@Test
	public void test1() {
		Hello hello = (Hello)this.ctx.getBean("hello");
		hello.print();
		System.out.println(hello.getNames().size());
		Printer printer = (StringPrinter)this.ctx.getBean("stringPrinter");
		System.out.println(printer);
		for(String str : hello.getNames()) {
			System.out.println(str);
		}
	}

}
