package CodingChallenges.Human;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void hasBetterGrade() {
        Student kjell = new Student("Hanken", "Kjell");
        Student julian = new Student("Kropp", "Julian");
        kjell.setNote(1.3);
        julian.setNote(2.3);
        assertFalse(julian.hasBetterGrade(kjell));

    }
}