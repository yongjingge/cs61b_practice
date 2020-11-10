/* CS61B Lecture11 Libraries, Abstract Classes, Packages */

public abstract class Model implements PaperShredder {
	public int count = 0;
	public int countNo() {
		return count;
	}
	public void shredAll(Document[] d) {
		for (int i = 0; i < d.length; i += 1) {
			shred(d[i]);
		}
	}
	public abstract void connectToWifi();
	public abstract void shred(Document d);
}