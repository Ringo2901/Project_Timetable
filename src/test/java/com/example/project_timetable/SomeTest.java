package com.example.project_timetable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import static org.junit.jupiter.api.Assertions.*;
class SomeTest {
    @Test
    void getNumber() {
        Some obj = new Some();
        assertEquals(5, obj.Sum(5));
    }
}