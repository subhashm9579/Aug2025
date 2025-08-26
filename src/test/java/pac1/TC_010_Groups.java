package pac1;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class TC_010_Groups {
  @Test (groups = {"smoke"}, priority = 4)
  public void test1() {
	  System.out.println("Smoke test 1");
  }
  
  @Test (groups = {"regression"}, priority = 3)
  public void test2() {
	  System.out.println("Regression test 1");
  }
  
  @Test (groups = {"smoke"}, priority = 2)
  public void test3() {
	  System.out.println("Smoke test 2");
	  
  }
  
  @Test (groups = {"regression"}, priority = 1)
  public void test4() {
	  System.out.println("Regression test 2");
  }
}
