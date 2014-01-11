package dijkstra;

import java.util.ArrayList;

public class Dijkstra {

	public static PreviousInterface dijkstra(GraphInterface g, VertexInterface r) {
		return dijkstra(g, r, new ASet(), new Pi(), new Previous());
	}

	private static PreviousInterface dijkstra(GraphInterface g,
			VertexInterface r, ASetInterface a, PiInterface pi,
			PreviousInterface previous) {

		ArrayList<VertexInterface> allVertices = g.vertices();
		int n = allVertices.size();

		a.addElement(r);

		for (VertexInterface x : allVertices)
			pi.setValue(x, Integer.MAX_VALUE);
		pi.setValue(r, 0);

		VertexInterface pivot = r;
		int piPivot = 0;

		for (int i = 0; i < n; i++) {
			ArrayList<VertexInterface> pivotSuccessors = g.followers(pivot);
			for (VertexInterface y : pivotSuccessors) {
				if (!a.isInA(y)) {
					int newPi = piPivot + g.weight(pivot, y);
					if (newPi < pi.getValue(y)) {
						pi.setValue(y, newPi);
						previous.setValue(y, pivot);
					}
				}
			}
				VertexInterface newPivot = null;
				int piNewPivot = Integer.MAX_VALUE;
				for (VertexInterface v : allVertices) {
					if (!a.isInA(v)) {
						int piV = pi.getValue(v);
						if (piV < piNewPivot) {
							newPivot = v;
							piNewPivot = piV;
						}
					}
				}
					if (newPivot == null)
						return previous;

					pivot = newPivot;
					piPivot = piNewPivot;
					a.addElement(pivot);

				}
				return previous;

			}
		
}
