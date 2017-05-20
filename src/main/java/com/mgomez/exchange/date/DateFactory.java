package com.mgomez.exchange.date;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DateFactory {

    public String today() {
        return LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public String daysFromToday(long daysFromToday) {
        return LocalDate.now().minusDays(daysFromToday).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
