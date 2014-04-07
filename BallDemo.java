import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private Random aleatorio;
   
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int nbolas)
    {
        int ground = 400;   // position of the ground line
        ArrayList <BouncingBall> bolas = new ArrayList <>();
        myCanvas.setVisible(true);
        

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        for(int i=0; i < nbolas; i++){
            aleatorio = new Random();
            int red = aleatorio.nextInt(250);
            int blue = aleatorio.nextInt(250);
            int green = aleatorio.nextInt(250);
            int x = aleatorio.nextInt(250);
            int y = aleatorio.nextInt(250);
            
            add.bolas(250);
            
        
        
        }
        
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();
        
        

        // make them bounce
        
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
}
