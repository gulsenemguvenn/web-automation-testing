import org.testng.annotations.*;

public class MyTests {

    @BeforeSuite
    public void test01() {
        System.out.println("1 - @BeforeSuite");
    }

    @BeforeTest
    public void test02() {
        System.out.println("2 - @BeforeTest");
    }

    @BeforeClass
    public void test03() {
        System.out.println("3 - @BeforeClass");
    }

    @BeforeGroups
    public void test04() {
        System.out.println("4 - @BeforeGroups");
    }

    @BeforeMethod
    public void test05() {
        System.out.println("5 - @BeforeMethod");
    }

    @Test
    public void test06() {
        System.out.println("6 - @Test");
    }

    @AfterMethod
    public void test07() {
        System.out.println("7 - @AfterMethod");
    }

    @AfterClass
    public void test08() {
        System.out.println("8 - @AfterClass");
    }

    @AfterTest
    public void test09() {
        System.out.println("9 - @AfterTest");
    }

    @AfterSuite
    public void test10() {
        System.out.println("10 - @AfterSuite");
    }
}
