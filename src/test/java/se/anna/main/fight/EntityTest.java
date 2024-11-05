package se.anna.main.fight;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EntityTest {

    @Test
    void attackTest() {
        Resident resident = new Resident("the resident", 12, 3);
        Burglar burglar = new Burglar("the burglar", 12, 4);
        resident.takeDamage(burglar.getDamage());
        Assertions.assertEquals(8, resident.getHealth());
    }

    @Test
    void takeDamageTest() {
        Resident resident = new Resident("the resident", 12, 3);
        Burglar burglar = new Burglar("the burglar", 12, 4);
        int burglarHealth = burglar.getHealth();
        Assertions.assertEquals(9, burglarHealth -= resident.getDamage());
    }

    @Test
    void isConsciousTestFalse() {
        Resident resident = new Resident("the resident", 12, 3);
        Burglar burglar = new Burglar("the burglar", 12, 15);
        resident.takeDamage(burglar.getDamage());
        boolean result = resident.isConscious();
        Assertions.assertFalse(result);
    }

    @Test
    void isConsciousTestTrue() {
        Resident resident = new Resident("the resident", 12, 3);
        Burglar burglar = new Burglar("the burglar", 12, 4);
        burglar.takeDamage(resident.getDamage());
        boolean result = burglar.isConscious();
        Assertions.assertTrue(result);
    }
}