package breakout;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

public class Block extends Region {

  private final int BLOCKWIDTH= 20 ;
  private final int BLOCKHEIGHT = 50;
  private int xpos;
  private int ypos;
  private String blockName;
  private ImageView myBlock;
  private int numberOfHitsLeft;
  public Block(int x, int y){
    myBlock = new ImageView();
    myBlock.setFitWidth(BLOCKHEIGHT);
    myBlock.setFitHeight(BLOCKWIDTH);
    int xpos = x;
    int ypos = y;
    myBlock.setX(xpos);
    myBlock.setY(ypos);
    getChildren().addAll(myBlock);
  }
  public Block(){

  }
  public void update(){

  }
  public void calcNewBallBounce(BouncingBall currBall) {
    if(currBall.getBall().getCenterX() < xpos ||currBall.getBall().getCenterX() > xpos +  BLOCKWIDTH)
      currBall.setMyXSpeed(currBall.getMyXSpeed()*-1);
    else
      currBall.setMyYSpeed(currBall.getMyYSpeed()*-1);
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
