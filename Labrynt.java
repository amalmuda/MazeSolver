import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Labrynt {
	int x;
	int y;
	Rute[][] kordinater;

	String info = "";

	public Labrynt(String filnavn) throws FileNotFoundException {
		File fil = new File(filnavn);
		Scanner scanner = new Scanner(fil);
		x = scanner.nextInt();
		y = scanner.nextInt();
		kordinater = new Rute[x][y];
		int rad = 0;
		int kolonne;
		Rute start = null;
		String line;
		for (int t = 0; t < x; t++) {
			line = scanner.next();
			kolonne = 0;
			for (int i = 0; i < y; i++) {
				if (line.charAt(i) == "#".charAt(0)) {
					if (kolonne == 0) {
						start = new SortRute(rad, kolonne);
						kordinater[rad][kolonne] = start;
					}
					Rute tmp = new SortRute(rad, kolonne);
					tmp.labrynt = this;
					if (kolonne != 0) {
						tmp.vest = start;
					}
					if (kolonne != y) {
						start.oest = tmp;
					}
					start = tmp;
					kordinater[rad][kolonne] = tmp;
					kolonne++;
					info = info + '\n' + "Kordinat " + start.toString();
				} else if (line.charAt(i) == ".".charAt(0)) {
					if (kolonne == 0) {
						start = new HvitRute(rad, kolonne);
						kordinater[rad][kolonne] = start;
					}
					Rute tmp = null;
					if (rad == 0 || rad == x - 1 || kolonne == y - 1 || kolonne == 0) {
						tmp = new Aapning(rad, kolonne);
					} else {
						tmp = new HvitRute(rad, kolonne);
					}
					start.labrynt = this;
					if (kolonne != 0) {
						tmp.vest = start;
					}
					if (kolonne != y) {
						start.oest = tmp;
					}
					start = tmp;
					kordinater[rad][kolonne] = start;
					kolonne++;
					info = info + '\n' + "Kordinat " + start.toString();
				}
			}
			rad++;
		}
		for (int i = 0; i < y - 1; i++) {
			for (int k = 0; k < x - 1; k++) {
				this.kordinater[k][i].syd = this.kordinater[k + 1][i];
				this.kordinater[k + 1][i].nord = this.kordinater[k][i];
			}
		}
		scanner.close();
	}

	@Override
	public String toString() {
		return info;
	}

	public void finnUtveiFra(int rad, int kol) {
		Rute gjeldende = this.kordinater[rad][kol];
		gjeldende.finn(null);
	}
}