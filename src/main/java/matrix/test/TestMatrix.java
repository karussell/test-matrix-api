package matrix.test;

import com.graphhopper.api.GHMRequest;
import com.graphhopper.api.GraphHopperMatrixWeb;
import com.graphhopper.api.MatrixResponse;
import com.graphhopper.util.shapes.GHPoint;

public class TestMatrix {
    public static void main(String[] args) {
        GraphHopperMatrixWeb matrix = new GraphHopperMatrixWeb();
        matrix.setKey("YOUR KEY");

        GHMRequest req = new GHMRequest();
        req.addPoint(new GHPoint(51.534377, -0.087891));
        req.addPoint(new GHPoint(51.467697, -0.090637));
        req.addPoint(new GHPoint(51.521241, -0.171833));

        req.addOutArray("times");
        req.addOutArray("distances");

        MatrixResponse resp = matrix.route(req);
        if (resp.hasErrors())
            throw new RuntimeException("problem for request " + req);

        long time = resp.getTime(0, 1);
        System.out.println("from 0 to 1 it takes " + time / 1000.0f + "sec");
        double distance = resp.getDistance(0, 1);
        System.out.println("from 0 to 1 it takes " + distance / 1000.0f + "km");
    }
}
