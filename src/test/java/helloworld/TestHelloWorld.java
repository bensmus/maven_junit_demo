package helloworld;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.CsvFileSource;

public class TestHelloWorld {

    private HelloWorld helloWorld = new HelloWorld();

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({ "0,    1,   1", "1,    2,   3", "49,  51, 100", "1,  100, 101" })
    void add(int first, int second, int expectedResult) {
        assertEquals(expectedResult, helloWorld.add(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @Test
    public void addSingle() {
        assertEquals(7, helloWorld.add(3, 4), "3 + 4 should equal 7");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1) // skip the header
    void toUpperCase_ShouldGenerateTheExpectedUppercaseValueCSVFile(String input, String expected) {
        String actualValue = input.toUpperCase();
        assertEquals(expected, actualValue);
    }
}
