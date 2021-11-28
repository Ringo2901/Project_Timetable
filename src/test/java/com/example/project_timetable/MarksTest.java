package com.example.project_timetable;

import org.junit.Test;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

class MarksTest {

    @Test
    void setNum() throws Exception {
        assertTimeout(ofSeconds(50000), () -> {
            Marks.setNum("1");
        });
    }
}