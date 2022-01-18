package breakout;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Node;

import static javafx.scene.input.KeyCode.*;
import static javafx.scene.input.MouseButton.*;


public class Bumpers extends Region {

  private final String RESOURCE_PATH = "/";
  private final String LEFT_IMAGE = RESOURCE_PATH + "Left-Bumper.png";
  private final String RIGHT_IMAGE = RESOURCE_PATH + "Right-Bumper.png";
  private ImageView myLeftBumper;
  private ImageView myRightBumper;
  private Rectangle leftShape;
  private Rectangle rightShape;
  private static final int PADDLE_SPEED = 20;
  private static double myLeftBumperMaterial = 1.0;
  private static double myRightBumperMaterial = 1.0;
  private double leftMaterialCounter = 0.0;
  private double rightMaterialCounter = 0.0;

  public Bumpers(){
    Image left = new Image(getClass().getResourceAsStream(LEFT_IMAGE));
    Image right = new Image(getClass().getResourceAsStream(RIGHT_IMAGE));
    myLeftBumper = new ImageView(left);
    myLeftBumper.setFitHeight(100);
    myLeftBumper.setFitWidth(30);
    myLeftBumper.setX(10);
    myLeftBumper.setY(300);
    leftShape = new Rectangle();
    leftShape.setY(myLeftBumper.getY());
    leftShape.setX(40);
    leftShape.setWidth(2);
    leftShape.setHeight(100);
    leftShape.setFill(Color.DARKRED);

    myRightBumper = new ImageView(right);
    myRightBumper.setFitHeight(100);
    myRightBumper.setFitWidth(30);
    myRightBumper.setX(875);
    myLeftBumper.setY(300);
    rightShape = new Rectangle();
    rightShape.setY(myRightBumper.getY());
    rightShape.setX(874);
    rightShape.setWidth(2);
    rightShape.setHeight(100);
    rightShape.setFill(Color.DARKRED);


    getChildren().addAll(myLeftBumper);
    getChildren().addAll(myRightBumper);
    getChildren().addAll(leftShape);
    getChildren().addAll(rightShape);
  }

  public void handleLeftPaddleKeys(KeyCode code) {
      if (code.equals(W)) {
        if (myLeftBumper.getY() > -50)
          myLeftBumper.setY(myLeftBumper.getY() - PADDLE_SPEED);
        else
          myLeftBumper.setY(550);
        leftShape.setY(myLeftBumper.getY());
      }
      if(code.equals(S)) {
        if (myLeftBumper.getY() < 550)
          myLeftBumper.setY(myLeftBumper.getY() + PADDLE_SPEED);
        else
          myLeftBumper.setY(-50);
        leftShape.setY(myLeftBumper.getY());
      }
      if(code.equals(D)){
        leftMaterialCounter = ((leftMaterialCounter + 1.0)%4.0);
        myLeftBumperMaterial = Math.pow(1.75,leftMaterialCounter-1.0);
        if(leftMaterialCounter==0.0)
          leftShape.setFill(Color.DARKBLUE);
        else if(leftMaterialCounter == 1.0)
          leftShape.setFill(Color.DARKRED);
        else if (leftMaterialCounter == 2.0)
          leftShape.setFill(Color.DARKORANGE);
        else
          leftShape.setFill(Color.GREEN);
      }
    }

  public void handleRightPaddle(double scrolled){
    if ((myRightBumper.getY() - scrolled/5) > -50 &&  (myRightBumper.getY() - scrolled/5)<550){
        myRightBumper.setY(myRightBumper.getY() - scrolled/3);
    }else if(scrolled>0){
      myRightBumper.setY(545);
    }else{
        myRightBumper.setY(-5);
    }
    rightShape.setY(myRightBumper.getY());
  }

  public void handleMousePress(MouseButton button) {

    if (button.equals(PRIMARY)) {
      rightMaterialCounter = ((rightMaterialCounter + 1.0) % 4.0);
      myRightBumperMaterial = Math.pow(1.75, rightMaterialCounter-1.0);

      if (rightMaterialCounter== 0.0){
        rightShape.setFill(Color.DARKBLUE);
      } else if(rightMaterialCounter == 1.0) {
        rightShape.setFill(Color.DARKRED);
      } else if (rightMaterialCounter == 2.0) {
        rightShape.setFill(Color.DARKORANGE);
      } else {
        rightShape.setFill(Color.GREEN);
      }
    }
  }

  public ImageView getMyLeftBumper() {
    return myLeftBumper;
  }

  public void setMyLeftBumper(ImageView myLeftBumper) {
    this.myLeftBumper = myLeftBumper;
  }

  public ImageView getMyRightBumper() {
    return myRightBumper;
  }

  public void setMyRightBumper(ImageView myRightBumper) {
    this.myRightBumper = myRightBumper;
  }

  public Rectangle getLeftShape() {
    return leftShape;
  }

  public void setLeftShape(Rectangle leftShape) {
    this.leftShape = leftShape;
  }

  public Rectangle getRightShape() {
    return rightShape;
  }

  public void setRightShape(Rectangle rightShape) {
    this.rightShape = rightShape;
  }

  public static double getMyLeftBumperMaterial() {
    return myLeftBumperMaterial;
  }

  public static void setMyLeftBumperMaterial(double myLeftBumperMaterial) {
    Bumpers.myLeftBumperMaterial = myLeftBumperMaterial;
  }

  public static double getMyRightBumperMaterial() {
    return myRightBumperMaterial;
  }

  public static void setMyRightBumperMaterial(double myRightBumperMaterial) {
    Bumpers.myRightBumperMaterial = myRightBumperMaterial;
  }

  public double getLeftMaterialCounter() {
    return leftMaterialCounter;
  }

  public void setLeftMaterialCounter(double leftMaterialCounter) {
    this.leftMaterialCounter = leftMaterialCounter;
  }

  public double getRightMaterialCounter() {
    return rightMaterialCounter;
  }

  public void setRightMaterialCounter(double rightMaterialCounter) {
    this.rightMaterialCounter = rightMaterialCounter;
  }
}
