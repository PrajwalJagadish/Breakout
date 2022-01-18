package breakout;

import javafx.geometry.Bounds;
import javafx.scene.effect.Light.Point;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

public class WallBlock extends Block{


  private final int BLOCKWIDTH= 100 ;
  private final int BLOCKHEIGHT = 100;
  private int xpos;
  private int ypos;
  private String blockName;
  private ImageView myBlock;
  private int numberOfHitsLeft = 10000;
  private final String WALL = "/"+ "WallBlock.png";



  public WallBlock(int x, int y) {
    Image wallImage = new Image(getClass().getResourceAsStream(WALL));
    myBlock = new ImageView(wallImage);
    myBlock.setFitWidth(BLOCKWIDTH);
    myBlock.setFitHeight(BLOCKHEIGHT);
    int xpos = x;
    int ypos = y;
    myBlock.setX(xpos);
    myBlock.setY(ypos);
    getChildren().addAll(myBlock);
  }

  public void calcNewBallBounce(BouncingBall ball) {
    Bounds ballBounds = ball.getBoundsInParent();
    Bounds brickBounds = myBlock.getBoundsInParent();
    if(brickBounds.getMaxY() >= ballBounds.getMaxY() && brickBounds.getMinY() <= ballBounds.getMinY()){
      System.out.println("test");
      ball.setMyXSpeed(ball.getMyXSpeed()*-1);
    }
    else{
      ball.setMyYSpeed(ball.getMyYSpeed()*-1);
      System.out.println("test");
    }
    numberOfHitsLeft--;
  }
  public void update() {
    if(numberOfHitsLeft <=0)
      getChildren().remove(myBlock);
  }

  public int getBLOCKWIDTH() {
    return BLOCKWIDTH;
  }

  public int getBLOCKHEIGHT() {
    return BLOCKHEIGHT;
  }

  public int getXpos() {
    return xpos;
  }

  public void setXpos(int xpos) {
    this.xpos = xpos;
  }

  public int getYpos() {
    return ypos;
  }

  public void setYpos(int ypos) {
    this.ypos = ypos;
  }

  public String getBlockName() {
    return blockName;
  }

  public void setBlockName(String blockName) {
    this.blockName = blockName;
  }

  public ImageView getMyBlock() {
    return myBlock;
  }

  public int getNumberofHitsLeft(){
    return numberOfHitsLeft;
  }
}


