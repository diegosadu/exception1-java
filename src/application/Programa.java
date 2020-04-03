package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.ExcecaoDominio;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Número do quarto: ");
			int numeroQuarto = sc.nextInt();
			System.out.print("Check-in (DD/MM/YYYY): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Check-out (DD/MM/YYYY): ");
			Date checkout = sdf.parse(sc.next());
			
			Reserva reserva = new Reserva(numeroQuarto, checkin, checkout);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Entre com os dados para atualizar a reserva:");
			System.out.print("Check-in (DD/MM/YYYY): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out (DD/MM/YYYY): ");
			checkout = sdf.parse(sc.next());
			
			reserva.atulizaDatas(checkin, checkout);
			
			System.out.println("Reserva: " + reserva);
		}
		catch (ParseException e) {
			System.out.println("Formato de data inválido.");
		}
		catch (ExcecaoDominio e) {
			System.out.println(e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
		
		sc.close();
	}

}
