package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {

	// sem o throws ParseException método main é um método normal sem exceção nenhuma
    public static void main(String[] args) throws ParseException{
        
    	Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Room number: ");
        int roomNumber = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        LocalDate checkIn = LocalDate.parse(sc.next(), fmt);
        System.out.print("Check-out date (dd/MM/yyyy): ");
        LocalDate checkOut = LocalDate.parse(sc.next(), fmt);

        Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
        System.out.println("Reservation: " + reservation);

        System.out.println();
        System.out.println("Enter data to update the reservation:");
        System.out.print("Check-in date (dd/MM/yyyy): ");
        checkIn = LocalDate.parse(sc.next(), fmt);
        System.out.print("Check-out date (dd/MM/yyyy): ");
        checkOut = LocalDate.parse(sc.next(), fmt);

        reservation.updateDates(checkIn, checkOut);
        System.out.println("Reservation: " + reservation);

        sc.close();
    }
}

