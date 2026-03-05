package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenAddDuplicatePassportThenReturnFalse() {
        PassportOffice office = new PassportOffice();
        Citizen citizen1 = new Citizen("2f44a", "Petr Arsentev");
        boolean addResult1 = office.add(citizen1);
        Citizen citizen2 = new Citizen("2f44a", "Ivan Ivanov");
        boolean addResult2 = office.add(citizen2);
        assertThat(addResult2).isFalse();
        assertThat(office.get(citizen1.getPassport())).isEqualTo(citizen1);
    }
}