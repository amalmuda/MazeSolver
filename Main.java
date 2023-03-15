import java.io.FileNotFoundException;
import java.util.Scanner;

public class Oblig6 {
	public static void main(String[] args) throws FileNotFoundException {
		String filnavn = args[0];
		Labrynt lab = new Labrynt(filnavn);

		String map = "";
		for (int i = 0; i < lab.x; i++) {
			for (int k = 0; k < lab.y; k++) {
				if (lab.kordinater[i][k] instanceof SortRute) {
					map = map + "# ";
				} else {
					map = map + ". ";
				}
			}
			map = map + '\n';
		}
		System.out.println('\n');
		System.out.println("Slik ser labyrinten ut:");
		System.out.println();
		System.out.println(map);

		System.out.println("************************************************************");
		System.out.println("Skriv inn koordinater <rad> <kolonne> ('-1' for aa avslutte)");
		int rad;
		int kolonne;
		while (true) {
			lab = new Labrynt(filnavn);
			System.out.println();
			Scanner scanner = new Scanner(System.in);
			System.out.print("Kordinater: ");
			rad = scanner.nextInt();
			if (rad == -1) {
				System.out.println();
				System.out.println("************************************************************");
				System.out.println("Program avsluttet");
				return;
			}
			kolonne = scanner.nextInt();
			System.out.println();
			System.out.println("Aapninger:");
			lab.finnUtveiFra(rad, kolonne);
			System.out.println('\n');
			System.out.println("***************************************************************");
			System.out.println("Skriv inn nye koordinater <rad> <kolonne> ('-1' for aa avslutte)");
			continue;
		}
	}
}