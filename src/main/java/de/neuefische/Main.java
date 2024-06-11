package de.neuefische;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {

        //LocalDate = Nur Datum
        LocalDate localDate = LocalDate.now();
        System.out.println("LocalDate: " + localDate);

        //LocalDateTime = Datum & Uhrzeit
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("LocalDateTime: " + localDateTime);

        //ZonedDateTime = Datum & Uhrzeit & Zeitzone
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("ZonedDateTime: " + zonedDateTime);

        //Instant = Zulu Zeitpunkt
        Instant instant = Instant.now();
        System.out.println("Instant: " + instant);

        //Umwandlung Instant zu LocalDateTime
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime convertedLocalDateTime = instant.atZone(zoneId).toLocalDateTime();
        System.out.println("Converted Instant to LocalDateTime: " + convertedLocalDateTime);

        //Umwandlung LocalDateTime zu Instant
        Instant convertedInstant = localDateTime.atZone(zoneId).toInstant();
        System.out.println("Converted LocalDateTime to instant: " + convertedInstant);

        //Format der Zeitangabe anpassen
        //E = Wochentag / d = Tag / M = Monat / y = Jahr / H = Stunde / m = Minute / s = Sekunde / n = nano
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MMMM.yyyy");

        System.out.println(localDate.format(formatter));

         //String in LocalDate umwandeln
        LocalDate parsedLocalDate = LocalDate.parse("12.August.2024", formatter);
        System.out.println("Parse String to LocalDate: " + parsedLocalDate);

        //Differenz zwischen zwei Zeitpunkten errechnen
        LocalDateTime start = LocalDateTime.of(2024, 6, 11, 12, 00, 00);
        LocalDateTime finish = LocalDateTime.now();

        //Errechnen FESTE EINHEIT der Zeitdifferenz
        long hoursBetween = ChronoUnit.HOURS.between(start, finish);
        long minutesBetween = ChronoUnit.MINUTES.between(start, finish);
        long secondsBetween = ChronoUnit.SECONDS.between(start, finish);

        //So ein Output würde also keinen Sinn machen!
        System.out.println("Wie viele Stunden zwischen Start und Ziel? " + hoursBetween + ":" + minutesBetween+ ":" + secondsBetween);
    }
}