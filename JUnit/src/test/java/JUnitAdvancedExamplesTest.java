import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JUnitAdvancedExamplesTest {

    @BeforeAll
    static void setupAll() {
        System.out.println(" Tüm testlerden önce çalıştı (setupAll).");
    }

    @BeforeEach
    void setupEach() {
        System.out.println(" Her testten önce çalıştı (setupEach).");
    }


    @Test
    @Order(1)
    @Timeout(3)
    void timeoutExampleTest() throws InterruptedException {
        System.out.println(" Timeout testi başladı...");
        Thread.sleep(2000);
        System.out.println(" Timeout testi tamamlandı.");
    }

    @Test
    @Order(2)
    @Disabled("Bu test şu anda bakımda, geçici olarak devre dışı bırakıldı.")
    void ignoredTest() {
        System.out.println(" Bu test çalışmayacak çünkü devre dışı.");
    }


    @RepeatedTest(3)
    @Order(3)
    void repeatedTestExample(RepetitionInfo repetitionInfo) {
        System.out.println(" RepeatedTest çalışıyor. Tekrar sayısı: " +
                repetitionInfo.getCurrentRepetition() + "/" +
                repetitionInfo.getTotalRepetitions());
        Assertions.assertEquals(2, 1 + 1, "1 + 1 her zaman 2 olmalı");
    }


    @ParameterizedTest
    @ValueSource(strings = {"selenium", "junit", "automation"})
    @Order(4)
    void parameterizedTestExample(String keyword) {
        System.out.println(" Parametreli test çalışıyor → keyword: " + keyword);
        Assertions.assertFalse(keyword.isEmpty(), "Keyword boş olmamalı");
    }

    @AfterEach
    void tearDownEach() {
        System.out.println(" Her testten sonra çalıştı (tearDownEach).");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println(" Tüm testler tamamlandı (tearDownAll).");
    }
}