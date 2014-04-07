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
            Random aleatorio = new Random();
            int red = aleatorio.nextInt(250);
            int blue = aleatorio.nextInt(250);
            int green = aleatorio.nextInt(250);
            int x = aleatorio.nextInt(240);
            int y = aleatorio.nextInt(400);
            int sizeRadio = aleatorio.nextInt(100);

            BouncingBall ball = new BouncingBall(x,y, sizeRadio,new Color(blue,red,green), ground, myCanvas);
            bolas.add(ball);
            ball.draw();

        }
            // make them bounce
            boolean finished =  false;
            while(!finished) {
                myCanvas.wait(50);
                for(BouncingBall pelota : bolas){
                    pelota.move();
                    
                    // stop once ball has travelled a certain distance on x axis
                    if(pelota.getXPosition() >= 550 ) {
                        finished = true;
                    }
                }
            }
        
    }
}
