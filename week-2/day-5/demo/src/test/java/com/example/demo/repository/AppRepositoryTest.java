package com.example.demo.repository;

import com.example.demo.domain.App;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class AppRepositoryTest {
    @Autowired
    private AppRepository repository;

    @Test
    public void testAppBetweenDates() {
        List<App> apps = repository.findByPubDtBetween(
                Date.valueOf(LocalDate.of(2021, 1, 1)),
                Date.valueOf(LocalDate.of(2022, 1, 1))
        );
        Assertions.assertTrue(apps.size() > 0);
    }
}
