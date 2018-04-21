package imageforgerydetection;

import java.util.ArrayList;

public class Rocchio {

    private double initialTreshold;
    private double a;
    private double b;

    public void setInitialTreshold(double initialTreshold) {
        this.initialTreshold = initialTreshold;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double generateNewTreshold(ArrayList<UserFeedback> userFeedbacks) {
        int sigmaX = 0;
        int sigmaY = 0;
        int totalDetectedLine = 0;
        for (UserFeedback userFeedback: userFeedbacks
             ) {
            sigmaX += userFeedback.getX();
            sigmaY += userFeedback.getY();
            totalDetectedLine += (userFeedback.getX() + userFeedback.getY());
        }
        return (this.initialTreshold + (double)(a * sigmaX / totalDetectedLine) - (double)(b * sigmaY / totalDetectedLine));
    }
}
