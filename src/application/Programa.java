package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Número do quarto: ");
		int numeroQuarto = sc.nextInt();
		System.out.print("Check-in (DD/MM/YYYY): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out (DD/MM/YYYY): ");
		Date checkout = sdf.parse(sc.next());
		
		if (checkin.after(checkout)) {
			System.out.println("Erro na reserva: Check-out dever ser posterior ao Check-in.");
		}
		else {
			Reserva reserva = new Reserva(numeroQuarto, checkin, checkout);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Entre com os dados para atualizar a reserva:");
			System.out.print("Check-in (DD/MM/YYYY): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out (DD/MM/YYYY): ");
			checkout = sdf.parse(sc.next());
			
			String erro = reserva.atulizaDatas(checkin, checkout);
			if (erro == null) {
				System.out.println("Reserva: " + reserva);
			}
			else {
				System.out.println(erro);
			}
			
		}
		
		sc.close();
	}

}
