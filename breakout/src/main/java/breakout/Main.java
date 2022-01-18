package breakout;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


/**
 * Feel free to completely change this code or delete it entirely.
 *
 * @author YOUR NAME HERE
 */
public class Main extends Application {
    // useful names for constant values used
    public static final String TITLE = "Breakout Together";
    public static final int SIZE = 600;
    private BreakoutGame myGame;

    /**
     * Initialize what will be displayed.
     */
    @Override
    public void start (Stage stage) {
        myGame = new BreakoutGame();
        Scene scene = myGame.setupGame((int)(1.5*SIZE), SIZE, Color.BISQUE);
        stage.setScene(scene);
        stage.setTitle(TITLE);
        stage.show();

        Timeline animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(new KeyFrame(Duration.seconds(1.0/60), e -> myGame.step(1.0/60)));
        animation.play();
    }
}
