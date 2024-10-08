package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

class UsersDatabaseTest {

    final UsersDatabase usersDatabase = new UsersDatabase();

    @Test
    void testFindFractionMultiplicationByUserFamilyName(){
        Fraction fractionNonExisting = usersDatabase.findFractionMultiplicationByUserFamilyName("NonExistingFamilyName");
        Assertions.assertEquals(1.0, fractionNonExisting.decimal(), 1e-5);
        Fraction fractionFernandez = usersDatabase.findFractionMultiplicationByUserFamilyName("Fernandez");
        Assertions.assertEquals(0.0, fractionFernandez.decimal(), 1e-5);
        Fraction fractionBlanco = usersDatabase.findFractionMultiplicationByUserFamilyName("Blanco");
        Assertions.assertEquals(0.0, fractionBlanco.decimal(), 1e-5);
        Fraction fractionLopez= usersDatabase.findFractionMultiplicationByUserFamilyName("López");
        Assertions.assertEquals(-0.05, fractionLopez.decimal(), 1e-5);
        Fraction fractionTorres= usersDatabase.findFractionMultiplicationByUserFamilyName("Torres");
        Assertions.assertTrue(Double.isNaN(fractionTorres.decimal()));
    }

    @Test
    void testFindFractionDivisionByUserId(){
        Fraction fractionNonExisting = usersDatabase.findFractionDivisionByUserId("NonExistingId");
        Assertions.assertEquals(1.0, fractionNonExisting.decimal(), 1e-5);
        Fraction fractionUserId1 = usersDatabase.findFractionDivisionByUserId("1");
        Assertions.assertTrue(Double.isInfinite(fractionUserId1.decimal()));
        Assertions.assertTrue(fractionUserId1.decimal() > 0.0);
        Fraction fractionUserId2 = usersDatabase.findFractionDivisionByUserId("2");
        Assertions.assertEquals(-3.75, fractionUserId2.decimal(), 1e-5);
        Fraction fractionUserId3 = usersDatabase.findFractionDivisionByUserId("3");
        Assertions.assertEquals(-20.0, fractionUserId3.decimal(), 1e-5);
        Fraction fractionUserId4 = usersDatabase.findFractionDivisionByUserId("4");
        Assertions.assertEquals(1.0, fractionUserId4.decimal(), 1e-5);
        Fraction fractionUserId5 = usersDatabase.findFractionDivisionByUserId("5");
        Assertions.assertTrue(Double.isInfinite(fractionUserId5.decimal()));
        Assertions.assertTrue(fractionUserId5.decimal() < 0.0);
        Fraction fractionUserId6 = usersDatabase.findFractionDivisionByUserId("6");
        Assertions.assertTrue(Double.isNaN(fractionUserId6.decimal()));
    }

    @Test
    void findFirstProperFractionByUserId() {
        Fraction fractionNonExisting = usersDatabase.findFirstProperFractionByUserId("NonExistingId");
        Assertions.assertNull(fractionNonExisting);
        Fraction fractionUserId1 = usersDatabase.findFirstProperFractionByUserId("1");
        Assertions.assertEquals(0.0, fractionUserId1.decimal(), 1e-5);
        Fraction fractionUserId2 = usersDatabase.findFirstProperFractionByUserId("2");
        Assertions.assertEquals(-0.2, fractionUserId2.decimal(), 1e-5);
        Fraction fractionUserId3 = usersDatabase.findFirstProperFractionByUserId("3");
        Assertions.assertEquals(0.2, fractionUserId3.decimal(), 1e-5);
        Fraction fractionUserId4 = usersDatabase.findFirstProperFractionByUserId("4");
        Assertions.assertNull(fractionUserId4);
        Fraction fractionUserId5 = usersDatabase.findFirstProperFractionByUserId("5");
        Assertions.assertEquals(0.0, fractionUserId5.decimal(), 1e-5);
        Fraction fractionUserId6 = usersDatabase.findFirstProperFractionByUserId("6");
        Assertions.assertNull(fractionUserId6);
    }

    @Test
    void findUserIdByAllProperFraction() {
        Stream<String> userIds = usersDatabase.findUserIdByAllProperFraction();
        Assertions.assertEquals(0, userIds.count());
    }
}
