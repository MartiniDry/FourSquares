package tools;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Visualizer extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
//		primaryStage.setScene(new Scene(new Graph3d(), 150, 200));

		Box cube = new Box(100, 100, 100);
		cube.setMaterial(new PhongMaterial(Color.BLUE));
		cube.setTranslateX(250);
		cube.setTranslateY(150);
		cube.setTranslateZ(0);
//		cube.setRotationAxis(Rotate.X_AXIS);
//		cube.setRotate(40);
		cube.setRotationAxis(Rotate.Y_AXIS);
		cube.setRotate(20);
		cube.setRotationAxis(Rotate.Z_AXIS);
		cube.setRotate(60);

		primaryStage.setScene(new Scene(new Graph3d(cube), 500, 300));

		primaryStage.show();
	}
}