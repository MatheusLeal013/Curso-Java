package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	// Remoção do throws ParseException para tratar exceções
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {
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

		} 
		catch (DateTimeParseException e) {
			System.out.println("Invalid date format");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		/* É possível capturar qualquer tipo de RuntimeException colocando o catch dele
		}
		 catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		*/

		sc.close();
	}
}