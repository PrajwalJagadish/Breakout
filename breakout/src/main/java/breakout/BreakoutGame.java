package breakout;
import static javafx.scene.input.KeyCode.*;

import java.lang.reflect.AnnotatedArrayType;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import java.util.*;

public class BreakoutGame {

    private Bounds bounds;
    private ArrayList<BouncingBall> myBalls = new ArrayList<BouncingBall>();
    private ArrayList<Block> currLevelBlocks = new ArrayList<Block>();
    private int[] dimensions;
    private Bumpers bumperPair;
    private ScoreBoard display;
    private Group root;

    public Scene setupGame(int width, int height, Paint background) {
        root = new Group();

        BouncingBall leftBall = new BouncingBall( 6, -60, -60, 500, 200, false);
        BouncingBall rightBall = new BouncingBall(6, -80, -80, 550, 275, false);
        myBalls.add(leftBall);
        myBalls.add(rightBall);

        dimensions = new int[]{width, height};
        bumperPair = new Bumpers();
        display= new ScoreBoard();
        WallBlock wall = new WallBlock(400,275);
        currLevelBlocks.add(wall);

        root.getChildren().add(display);
        root.getChildren().add(bumperPair);
        root.getChildren().addAll(myBalls);
        root.getChildren().addAll(currLevelBlocks);
        Scene scene = new Scene(root, width, height, background);
        scene.setOnKeyPressed(e -> keyPressDistribution(e.getCode()));
        scene.setOnScroll(x->bumperPair.handleRightPaddle(x.getDeltaY()));
        scene.setOnMousePressed(k->bumperPair.handleMousePress(k.getButton()));
        return scene;
    }

    public void keyPressDistribution(KeyCode code){
        ArrayList<KeyCode> leftPaddleKey = new ArrayList<KeyCode>();

        leftPaddleKey.add(W);
        leftPaddleKey.add(S);
        leftPaddleKey.add(D);
        if (leftPaddleKey.contains(code))
            bumperPair.handleLeftPaddleKeys(code);

    }


    public void step (double elapsedTime){
        List<BouncingBall> ballsToRemove = new ArrayList<BouncingBall>();
        for (BouncingBall currBall : myBalls){
            currBall.updatePosition(elapsedTime, dimensions, display);
            if(currBall.getDestroyed())
                ballsToRemove.add(currBall);
            if(isIntersecting(bumperPair.getMyLeftBumper(), currBall.getBall())){

                currBall.setMyXSpeed(-1* currBall.getMyXSpeed() * bumperPair.getMyLeftBumperMaterial());
                currBall.setMyYSpeed(currBall.getMyYSpeed() * bumperPair.getMyLeftBumperMaterial());
                currBall.setLastHit("left");

            }else if(isIntersecting(bumperPair.getMyRightBumper(), currBall.getBall())){
                currBall.setMyXSpeed( currBall.getMyXSpeed()*-1* bumperPair.getMyRightBumperMaterial());
                currBall.setMyYSpeed(currBall.getMyXSpeed()*bumperPair.getMyRightBumperMaterial());
                currBall.setLastHit("right");
            }else{
                List<Block> blocksToRemove = new ArrayList<Block>();
                for(Block checkBlock: currLevelBlocks){
                    if(isIntersecting(checkBlock.getMyBlock(), currBall.getBall()))
                        checkBlock.calcNewBallBounce(currBall);
                    checkBlock.update();

                    if(checkBlock.getNumberofHitsLeft() <= 0){
                        blocksToRemove.add(checkBlock);
                    }
                }
                currLevelBlocks.removeAll(blocksToRemove);
            }
            myBalls.remove(ballsToRemove);
        }
        display.update();
    }

    private boolean isIntersecting (ImageView a, Circle b) {
        return b.getBoundsInParent().intersects(a.getBoundsInParent());
    }
    private boolean isIntersecting (Circle a, Circle b) {
        return b.getBoundsInParent().intersects(a.getBoundsInParent());
    }
    private boolean isIntersecting (ImageView a, ImageView b) {
        return b.getBoundsInParent().intersects(a.getBoundsInParent());
    }



}
