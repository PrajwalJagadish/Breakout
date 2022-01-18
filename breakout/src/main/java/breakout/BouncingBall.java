package breakout;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import java.math.*;
import javafx.scene.Node;


public class BouncingBall extends Block {
    private String myColor;
    private int mySize;
    private double myXSpeed;
    private double myYSpeed;
    private double[] initialConditions;
    private String lastHit = "init ";
    private Circle ball;
    private boolean mainBall;
    private boolean destroyed = false;

    public BouncingBall(int radius, String color){
        mySize = radius;
        ball = new Circle(radius, Color.GRAY);
        ball.setStrokeWidth(1);
        ball.setStroke(Color.BLACK);
        ball.setCenterX(240);
        ball.setCenterY(240);
        myXSpeed = 80;
        myYSpeed = -140;
        initialConditions = new double[]{240,240,80,-140};
        getChildren().addAll(ball);
    }

    public BouncingBall(int radius, int xspeed, int yspeed, int xpos, int ypos, boolean powerup){
        mySize = radius;
        mainBall = !powerup;
        ball = new Circle(radius, Color.GRAY);
        ball.setStrokeWidth(1);
        ball.setStroke(Color.BLACK);
        ball.setCenterX(xpos);
        ball.setCenterY(ypos);
        myXSpeed = xspeed;
        myYSpeed = yspeed;
        initialConditions = new double[]{xpos, ypos, xspeed,yspeed};
        getChildren().addAll(ball);
    }
    public void updatePosition(double time, int[] bounds, ScoreBoard display) {
        ball.setCenterX(ball.getCenterX() + myXSpeed*time);
        ball.setCenterY(ball.getCenterY() - myYSpeed*time);

        boolean intersectsRight = (ball.getCenterX() + ball.getRadius() > bounds[0]);
        boolean intersectsLeft = (ball.getCenterX() - ball.getRadius() < 0);
        boolean intersectsTop = ((ball.getCenterY() + ball.getRadius())< 0);
        boolean intersectsBot = ((ball.getCenterY() - ball.getRadius()) > bounds[1]);

        if(intersectsRight || intersectsLeft){
            display.setLives(display.getLives() -1);
            reset();
        }
        if(intersectsTop || intersectsBot)
            myYSpeed = -1*myYSpeed;

        if(lastHit.equals("left"))
            ball.setFill(Color.GOLD);
        else if(lastHit.equals("right"))
            ball.setFill(Color.DARKBLUE);

    }

    public void bounce(double speedMultiplier, double newAngle){
        System.out.println("Speed Multiplier: " +speedMultiplier + " Original Speeds: "+ myXSpeed);
        myXSpeed *= speedMultiplier;
        myYSpeed *= speedMultiplier;
        double vel = Math.sqrt(Math.pow(myYSpeed,2) +  Math.pow(myXSpeed,2));
        myXSpeed = myXSpeed*Math.cos(newAngle);
        myYSpeed = myYSpeed*Math.sin(newAngle);
        System.out.println("New Speed:" + myXSpeed);
    }
    public void reset(){
        if(!mainBall){
            getChildren().removeAll(ball);
            destroyed = true;
        }

        ball.setCenterX(initialConditions[0]);
        ball.setCenterY(initialConditions[1]);
        myXSpeed = initialConditions[2];
        myYSpeed = initialConditions[3];
        lastHit = "init";
    }

    public double getMyXSpeed() {
        return myXSpeed;
    }

    public double getMyYSpeed() {
        return myYSpeed;
    }

    public String getLastHit() {
        return lastHit;
    }

    public Circle getBall() {
        return ball;
    }

    public boolean isMainBall() {
        return mainBall;
    }

    public void setMySize(int mySize) {
        this.mySize = mySize;
    }

    public void setMyXSpeed(double myXSpeed) {
        this.myXSpeed = myXSpeed;
    }

    public void setMyYSpeed(double myYSpeed) {
        this.myYSpeed = myYSpeed;
    }

    public void setLastHit(String lastHit) {
        this.lastHit = lastHit;
    }

    public void setBall(Circle ball) {
        this.ball = ball;
    }

    public void setMainBall(boolean mainBall) {
        this.mainBall = mainBall;
    }

    public boolean getDestroyed(){return destroyed;};
}
