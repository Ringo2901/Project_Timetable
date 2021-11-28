package com.example.project_timetable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertTimeout;

class HelloApplicationTest {

    @Test
    void main() throws Exception{
        assertTimeout(ofSeconds(50), () -> {
            HelloApplication.main("as");
        });
    }
}