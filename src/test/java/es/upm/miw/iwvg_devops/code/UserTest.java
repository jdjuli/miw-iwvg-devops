package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class UserTest {
    private User johnDoe;

    @BeforeEach
    void setUp() {
        johnDoe = new User("userId", "John", "Doe", new ArrayList<>());
    }

    @Test
    void testConstructor() {
        Assertions.assertEquals("userId", johnDoe.getId());
        Assertions.assertEquals("John", johnDoe.getName());
        Assertions.assertEquals("Doe", johnDoe.getFamilyName());
        Assertions.assertTrue(johnDoe.getFractions().isEmpty());
    }

    @Test
    void testDefaultConstructor() {
        johnDoe = new User();
        johnDoe.setName("John");
        johnDoe.setFamilyName("Doe");
        johnDoe.setFractions(new ArrayList<>());
        Assertions.assertNull(johnDoe.getId());
        Assertions.assertEquals("John", johnDoe.getName());
        Assertions.assertEquals("Doe", johnDoe.getFamilyName());
        Assertions.assertTrue(johnDoe.getFractions().isEmpty());
    }

    @Test
    void testFractionListManipulation(){
        Fraction fraction1 = new Fraction();
        Assertions.assertTrue(johnDoe.getFractions().isEmpty());
        johnDoe.getFractions().add(fraction1);
        Assertions.assertEquals(1, johnDoe.getFractions().size());
        Assertions.assertEquals(fraction1, johnDoe.getFractions().get(0));
        Fraction fraction2 = new Fraction();
        johnDoe.addFraction(fraction2);
        Assertions.assertEquals(2, johnDoe.getFractions().size());
        Assertions.assertEquals(fraction2, johnDoe.getFractions().get(1));
        johnDoe.getFractions().clear();
        Assertions.assertTrue(johnDoe.getFractions().isEmpty());
    }

    @Test
    void testInitials(){
        Assertions.assertEquals("J.D.", johnDoe.initials());
        johnDoe.setName("Name");
        johnDoe.setFamilyName("FamilyName");
        Assertions.assertEquals("N.F.", johnDoe.initials());
    }

    @Test
    void testFullName(){
        Assertions.assertEquals("John Doe", johnDoe.fullName());
    }

    @Test
    void testToString(){
        String toStringRegexr = "User\\{id='userId', name='John', familyName='Doe', fractions=\\[.*]}";
        String stringEmptyList = johnDoe.toString();
        johnDoe.getFractions().add(new Fraction());
        String stringNonEmptyList = johnDoe.toString();
        Assertions.assertTrue(stringEmptyList.matches(toStringRegexr));
        Assertions.assertTrue(stringNonEmptyList.matches(toStringRegexr));
        Assertions.assertTrue(stringNonEmptyList.length() > stringEmptyList.length());
    }
}
