package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UsersDatabaseTest {

    final UsersDatabase usersDatabase = new UsersDatabase();

    @Test
    public void testFindFractionMultiplicationByUserFamilyName(){
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
}
