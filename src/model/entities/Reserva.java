package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private int numeroQuarto;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
	}

	public Reserva(int numeroQuarto, Date checkin, Date checkout) {
		this.numeroQuarto = numeroQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}
	
	public long duracao() {
		long diferenca = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public String atulizaDatas(Date checkin, Date checkout) {
		
		Date agora = new Date();
		
		if (agora.after(checkin) || agora.after(checkout)) {
			return "Erro na reserva: Datas para reserva devem ser posteriores ao dia de hoje.";
		}
		
		if (checkin.after(checkout)) {
			return "Erro na reserva: Check-out dever ser posterior ao Check-in.";
		}
		
		this.checkin = checkin;
		this.checkout = checkout;
		
		return null;
	}
	
	@Override
	public String toString() {
		return "Quarto " + numeroQuarto + 
			   ", Check-in: " + sdf.format(checkin) +
			   ", Check-out: " + sdf.format(checkout) +
			   ", " + duracao() + " noites";
	}
}
