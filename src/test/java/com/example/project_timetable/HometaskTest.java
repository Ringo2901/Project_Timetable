package com.example.project_timetable;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

import static java.time.Duration.ofSeconds;

class HometaskTest {

    @Test
    void addHometask() throws Exception{
        Scanner input = new Scanner (System.in);
        assertTimeout(ofSeconds(1), () -> {
            Hometask.addHometask(input);
        });
    }

}
