package breakout;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ScoreBoard extends Region {
  private int player1Score = 0;
  private int player2Score = 0;
  private int lives= 3;
  private Text player1Display;
  private Text player2Display;
  private Text lifeDisplay;
  private Font font = Font.font("Impact", FontWeight.BOLD, 18);
  private ImageView heart;

  public ScoreBoard(){
    player1Display = new Text("P1 Score: "+player1Score);
    player2Display = new Text("P2 Score: "+ player2Score);
    lifeDisplay = new Text("x" +lives);

    player1Display.setX(60);
    player1Display.setY(585);
    player1Display.setFill(Color.BLACK);
    player1Display.setFont(font);

    player2Display.setX(760);
    player2Display.setY(585);
    player2Display.setFont(font);
    player2Display.setFill(Color.BLACK);

    Image heartpic = new Image(getClass().getResourceAsStream("/Heart.png"));
    heart = new ImageView(heartpic);
    heart.setX(65);
    heart.setY(0);
    heart.setFitHeight(25);
    heart.setFitWidth(25);

    lifeDisplay.setX(90);
    lifeDisplay.setY(20);
    lifeDisplay.setFill(Color.BLACK);
    lifeDisplay.setFont(font);

    getChildren().addAll(lifeDisplay);
    getChildren().addAll(player1Display);
    getChildren().addAll(player2Display);
    getChildren().addAll(heart);
  }

  public void update(){
    lifeDisplay.setText("x" +lives);
    player1Display.setText("P2 Score: "+ player1Score);
    player2Display.setText("P2 Score: "+ player2Score);;
  }

  public void setPlayer1Score(int x){
    player1Score = x;
  }
  public int getPlayer1Score(){
    return player1Score;
  }
  public void setPlayer2Score(int x){
    player2Score = x;
  }
  public int getPlayer2Score(){
    return player2Score;
  }
  public void setLives(int x){
    lives = x;
  }

  public int getLives() {
    return lives;
  }




}
