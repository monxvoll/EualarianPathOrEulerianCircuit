package view;

import controller.EulerianController;
import model.EulerianMethods;

public class Main {
    public static void main(String[] args) {

        EulerianMethods model = new EulerianMethods();

        EulerianController controller = new EulerianController(model);

        EulerianView view = new EulerianView(controller);

        view.start();
    }
}
