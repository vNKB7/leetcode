package brand_new;

public class _223_Rectangle_Area {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		return (int) ((C - A) * (D - B) + (G - E) * (H - F) - ((long) Math.min(
				C, G) - Math.max(A, E) > 0 ? ((long) Math.min(C, G) - Math.max(
				A, E)) : 0)
				* ((long) Math.min(D, H) - Math.max(B, F) > 0 ? ((long) Math
						.min(D, H) - Math.max(B, F)) : 0));
	}

	public static void main(String[] args) {
		System.out.println(new _223_Rectangle_Area().computeArea(-1500000001,
				0, -1500000000, 1, 1500000000, 0, 1500000001, 1));
	}

}
