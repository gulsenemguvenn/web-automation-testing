import org.junit.*;

public class MyFirstTests {

    @BeforeClass
    public static void beforeMyClass() {
        System.out.println("Before Tests");
    }

    @Before
    public void beforeMyTest() {
        System.out.println("Before Test");
    }

    @Test
    public void myTest1() {
        System.out.println("Test 1");
    }

    @Test
    public void myTest2() {
        System.out.println("Test 2");
    }

    @After
    public void afterMyTest() {
        System.out.println("After Test");
    }

    @AfterClass
    public static void afterMyClass() {
        System.out.println("After Tests");
    }



}
