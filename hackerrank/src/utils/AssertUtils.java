package utils;

public class AssertUtils {
    public static void assertTrue(boolean actual)  {
        if(!actual)
            throw new RuntimeException("Expected true, actual false.");
    }

    public static void assertFalse(boolean actual) {
        if(actual)
            throw new RuntimeException("Expected false, actual true.");
    }

    public static void equals(int expected, int actual) {
        if(expected != actual) {
            throw new RuntimeException(String.format("Expected %d, actual %d.", expected, actual));
        }
    }

    public static void equals(long expected, float actual) {
        if(expected != actual) {
            throw new RuntimeException(String.format("Expected %f, actual %f.", expected, actual));
        }
    }

    public static void equals(String expected, String actual) {
        if(!expected.equals(actual)) {
            throw new RuntimeException(String.format("Expected %s, actual %s.", expected, actual));
        }
    }


}
