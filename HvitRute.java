public class HvitRute extends Rute {

	public HvitRute(int x, int y) {
		super(x, y);
	}

	String farge = "Hvit";

	@Override
	public String farge() {
		return farge;
	}

	public String toString() {
		return "(" + this.rad + ", " + this.kolonne + ")";
	}

	int t = 0;

	public void finn(Rute fra) {
		t++;
		if (t > 1) {
			return;
		}
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
		} else {
			if (!forrige.equals(this.nord) && this.nord != null) {
				this.nord.finn(this);
			}
			if (!forrige.equals(this.syd) && this.syd != null) {
				this.syd.finn(this);
			}
			if (!forrige.equals(this.vest) && this.vest != null) {
				this.vest.finn(this);
			}
			if (!forrige.equals(this.oest) && this.oest != null) {
				this.oest.finn(this);
			}
		}
	}
}