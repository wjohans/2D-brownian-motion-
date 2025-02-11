import java.lang.Math;
import java.awt.Color;
public class Particle {
    private float x;
    private float y;
    private int xbound;
    private int ybound;
    private boolean moving;
    private Color color;
    Particle(float x, float y, int xbound, int ybound) {
        this.x = x;
        this.y = y;
        this.xbound = xbound-1;
        this.ybound = ybound-1;
        this.moving = true;
        this.color = Color.WHITE;
    }
    Particle(int xbound, int ybound) {
        x = (float) Math.random()*(xbound-1);
        y = (float) Math.random()*(ybound-1);
        this.xbound = xbound-1;
        this.ybound = ybound-1;
        this.moving = true;
        this.color = Color.WHITE;
    }
    public void move(float L) {
        if(moving) {
            float xchange = (float) (L*Math.cos(Math.random()*2*Math.PI));
            float ychange = (float) (L*Math.sin(Math.random()*2*Math.PI));
            if(x+xchange<1) {
                x=1;
                stopmoving();
            } else if(x+xchange>xbound-1) {
                x=xbound-1;
                stopmoving();
            } if(y+ychange<1) {
                y=1;
                stopmoving();
            } else if(y+ychange>ybound-1) {
                y=ybound-1;
                stopmoving();
            } else {
                x += xchange;
                y += ychange;
            }
        }
    }
    public float[] getPos() {
        float[] pos = {x,y};
        return pos;
    }
    public boolean isMoving() {
        return moving;
    }
    public void stopmoving() {
        moving = false;
        color = Color.RED;
    }
    public Color getColor() {
        return color;
    }
    
}
