package test;

import ast.locatable.Locatable;

public class Assertions {

    private Assertions () {
        // Prevent instantiation
    }

    public static void assertNotNull(Object obj) {
        if (obj == null) {
            throw new AssertionError("Object is null");
        }
    }

    public static void assertNull(Object obj) {
        if (obj != null) {
            throw new AssertionError("Object is not null");
        }
    }

    public static void assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionError("Condition is false");
        }
    }

    public static void assertFalse(boolean condition) {
        if (condition) {
            throw new AssertionError("Condition is true");
        }
    }

    public static void assertEquals(Locatable expected, Locatable actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError("\nExpected: " + expected + ".\nActual: " + actual + ".\n"
            + "Expected position: (" + expected.getLine() + ", " + expected.getColumn() + ")\nActual position: ("
            + actual.getLine() + ", " + actual.getColumn() + ")");
        }
    }

    public static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError("Expected: " + expected + ", but got: " + actual);
        }
    }

    public static void assertEquals(String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError("Expected: " + expected + ", but got: " + actual);
        }
    }

}
