public class Aapning extends HvitRute {

	public Aapning(int x, int y) {
		super(x, y);
	}

	public String toString() {
		return "(" + this.rad + ", " + this.kolonne + ") ";
	}

	public void finn(Rute fra) {
		forrige = fra;
		if (forrige == null) {
			if (this.nord != null) {
				this.nord.finn(this);
			}
			if (this.syd != null) {
				this.syd.finn(this);
			}
			if (this.vest != null) {
				this.vest.finn(this);
			}
			if (this.oest != null) {
				this.oest.finn(this);
			}
		}
		System.out.print(this.toString());
	}
}