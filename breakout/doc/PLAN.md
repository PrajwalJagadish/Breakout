# Breakout Plan
### NAME: Prajwal Jagadish




## Interesting Breakout Variants

 * Idea #1: I was imagining a pong/breakout hybrid game where there are two players in a pong style stage
but there is a wall of blocks in the middle. The idea would be there were at least two balls bouncing at the goal is 
to score points by breaking through the wall and score onto your opponents backboard. Different powerups would help you're 
chances or help your opponent. For different levels, I could implement different styles of walls in the middle
as well as faster ball travel times to make the game go faster/chaotic.3 levels for a best of 3 matchup

 * Idea #2: A top down scrolling break out style game where blocks come down from the top and you must break them before
they hit the ground (galaga style)

## Paddle Ideas

 * Different bounce angles

 * Maybe allow for a button that lets you change the "material of the paddle", ie rubber, brick, plastic. This would allow
for different coeffiecients of bounce so that you could change how fast you want the ball 


## Block Ideas

 * Idea #1 : Most basic block would take multiple hits to be broken. It the 2 player version it could be that both players
must hit it to get it to break but only the 2nd person to hit it would get the points for that particular block.

 * Idea #2: Blocks that would phase in and out so that you would have to hit the block at the right time to break it.

 * Idea #3: TNT block that would destroy a 3x3 grid of blocks. 
 
## Power-up Ideas

 * Idea #1: Multi ball - release 5 or 6 balls from where the block is broken

 * Idea #2: Defensive shield where you would need to miss the ball with your paddle multiple times before it gets counted
against you(preserves your score/HP)

 * Idea #3: Machine gun Paddle, turns your paddle into a machine gun to fire a stream of balls at any particular angle so
that they all hit a block and start bouncing everywhere. 
 

## Cheat Key Ideas

 * Idea #1 : For the galaga style game : it would clear out every block currently on the screen

 * Idea #2: Give the Defensive shield immediatly 

 * Idea #3: Restock how many lives you have

 * Idea #4: Make the paddle 2x as long


## Level Descriptions

 * Idea #1 Classic block wall in the middle
Number meaning number of hits to break and P means 1 hit power up\
3 2 2 1 1 1 2 2 3 \
3 2 2 1 1 1 2 2 3\
3 2 2 P 1 P 2 2 3 \
3 2 2 1 1 1 2 2 3 \
3 2 2 1 P 1 2 2 3\
   3 2 2 1 1 1 2 2 3\
   3 2 2 1 P 1 2 2 3\
   3 2 2 1 1 1 2 2 3\
   3 2 2 1 P 1 2 2 3\
   3 2 2 1 P 1 2 2 3\
   3 2 P 1 1 1 2 P 3\
   3 2 2 1 1 1 2 2 3\
   3 2 2 P P P 2 2 3\
   3 2 2 1 1 1 2 2 3\
   3 2 2 1 P 1 2 2 3

 * Idea #2 : I couldn't really draw this out because its a little complex to draw it scrolling down but for the galaga I would take inspiration
from the alien ship formations like [this](https://www.etsy.com/listing/124760709/galaga-level-1-cross-stitch-pattern)

   * Idea #3: A star shape level like this` in the middle of the screen:\
                       @@                                                         
                      @@@@                                                        
                     @@@@@@                                                       
            @@@@@@@@@@@@@@@@@@@@@@@@                                              
               @@@@@@@@@@@@@@@@@@                                                 
                   @@@@@@@@@@,                                                    
                  @@@@@@@@@@@@                                                    
                 @@@@@@  @@@@@@                                                   
                 @@@         @@                                                   
      where the outside has special triangle blocks that would bounce it at an angle rather than directly opposite.

## Class Ideas

 * Idea #1: Block class: One method would be when the block is hit it would call a method that would add cracks to the image

 * Idea #2: Scoring class: Would keep track of the score and the health of the player. Would have a method thats called
when the block is broken or the ball is missed that would update the score.

 * Idea #3: Ball class that would represent the balls and contain information about them. One method would change the speed of the 
ball and the angle the ball. 

 * Idea #4: Paddle class. One method would be called to change the material of the paddle and the other to interact with
the ball

