package pl.alx.waluty;

import java.math.BigDecimal;
import java.util.Scanner;

public class PrzelicznikKonsola {

	public static void main(String[] args) {
		System.out.println("Pobieram aktualne kursy...");
		Tabela tabela = ObslugaNBP.pobierzAktualnaTabele();
		System.out.println(tabela);
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("\nPodaj kod waluty");
			String kod = sc.nextLine().trim().toUpperCase();
			if(kod == null || kod.isEmpty())
				break;
			
			Waluta waluta = tabela.znajdz(kod);
			if(waluta == null) {
				System.out.println("Nie ma takiej waluty.");
				continue;
			}
			
			System.out.println("Wybrana waluta: " + waluta.getNazwa());
			System.out.println("Podaj kwotę");
			if(!sc.hasNextBigDecimal()) {
				System.out.println("Nieprawidłowa kwota.");
				continue;
			}
			BigDecimal kwota = sc.nextBigDecimal();
			
			System.out.println(kwota + " " + kod + " = "
					+ waluta.przeliczWaluteNaPln(kwota) + " PLN");
			
			System.out.println(kwota + " PLN " + " = "
					+ waluta.przeliczPlnNaWalute(kwota) + " " + kod);
		}
	}
}
