public class DummyTest {

  @org.junit.Test
  public void mainTest() {
    Test.main(new String[] {});
  }

  @org.junit.Test
  public void newInstance() {
    org.junit.Assertions.assertNotNull(new Test());
  }
}
