package CodingChallenges.Human;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void hasBetterGrade() {
        Student alex = new Student("Müller", "Alex");
        Student julian = new Student("Kropp", "Julian");
        alex.setNote(1.3);
        julian.setNote(2.3);
        assertFalse(julian.hasBetterGrade(alex));

    }
}