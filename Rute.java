public abstract class Rute {
	String farge;
	int rad;
	int kolonne;
	Labrynt labrynt;
	Rute nord;
	Rute syd;
	Rute vest;
	Rute oest;
	Rute forrige;

	public String farge() {
		return farge;
	}

	public Rute(int x, int y) {
		rad = x;
		kolonne = y;
	}

	public void finn(Rute fra) {
		forrige = fra;
	}
}