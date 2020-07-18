/* Lecture 2 Walrus and Integer */

public class Lecture2 {
	public static class Walrus {
		public int weight;
		public double tuskSize;
		public Walrus(int w, double s) {
			weight = w;
			tuskSize = s;
		}
		public String toString() {
			return ("The walrus is :" + weight + " weight and " + tuskSize + " tusksize.");
		}
	}

	public static void doStuff(Walrus w, int x) {
		w.weight = w.weight - 100;
		x = x - 5;
		System.out.println("Inside the doStuff function, we pring x's value: " + x);
	}

	public static void main(String[] args) {
		Walrus w = new Walrus(3500, 10.5);
		int x = 9;
		System.out.println("Originally x is: " + x);
		doStuff(w, x);
		System.out.println(w);
		System.out.println("After running doStuff function, x is now: " + x);
	}
}