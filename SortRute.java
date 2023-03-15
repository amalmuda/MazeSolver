public class SortRute extends Rute {

	public SortRute(int x, int y) {
		super(x, y);
	}

	String farge = "Sort";

	@Override
	public String farge() {
		return farge;
	}

	public void finn(Rute fra) {
		forrige = fra;
		if (forrige == null) {
			System.out.println("Kan ikke starte fra sort rute");
		}
	}

	public String toString() {
		return "(" + this.rad + ", " + this.kolonne + ")";
	}
}