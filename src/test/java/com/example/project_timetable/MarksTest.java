package com.example.project_timetable;

import org.junit.jupiter.api.Test;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

class MarksTest {

    @Test
    void setNum() throws Exception {
        assertTimeout(ofSeconds(50), () -> {
            Marks.setNum("1");
        });
    }

    @Test
    void addMarks() throws Exception {
        assertTimeout(ofSeconds(50), () -> {
            Marks.addMarks();
        });
    }
}