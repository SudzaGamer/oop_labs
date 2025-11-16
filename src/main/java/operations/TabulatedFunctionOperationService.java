package operations;

import functions.Point;
import functions.TabulatedFunction;

public class TabulatedFunctionOperationService {
    public static Point[] asPoints(TabulatedFunction tabulatedFunction) {
        int size = tabulatedFunction.getCount();
        Point[] points = new Point[size];

        int i = 0;
        for (Point p : tabulatedFunction) {
            points[i] = p;
            i++;
        }
        return points;
    }
}
