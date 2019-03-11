import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class exampleTest {

    example example;

    @BeforeAll
    void beforeAll() {

        System.out.println("Before All ...");
    }

    @BeforeEach
    void setUp() {
        example = new example();
    }

    @AfterEach
    void tearDown() {
        System.out.println("clean Up ....");
    }


    @Test
    @DisplayName("Example Class Add Method")
    void addTest() {
        int acttual = example.add(10, 20);

        assertEquals(30, acttual, "The method add two numbers ");
    }

    // enabled on linux only
    @EnabledOnOs(OS.LINUX)
    @EnabledOnJre(JRE.JAVA_8)
    @Test
    @DisplayName("Example Class Divid Method")
    void divideTest() {

//        assertEquals(30, acttual ,"The method divide two numbers ");
        assertThrows(ArithmeticException.class, () -> example.divide(10, 0),
                "Invalid Divid By 0");
    }

    @Test
    @Disabled
    @DisplayName("Fail Method ")
    public void failMethod() {

        fail("Faile ");
    }
}