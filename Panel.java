import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Panel extends JPanel {
    private Model mod;
    private BufferedImage canvas;
    Panel(int width,int height, int n, Model mod) {
        this.mod = mod;
        canvas = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        fillcanvas(Color.BLACK);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(canvas, null, null);
    }
    public void update() {
        Particle[][] matrix = mod.getStatus();
        for(int j=0;j<matrix.length;j++) {
            for(int i=0; i<matrix[j].length;i++) {
                if(matrix[j][i] == null) {
                    canvas.setRGB(j,i,Color.BLACK.getRGB());
                } else {
                    canvas.setRGB(j,i,matrix[j][i].getColor().getRGB());
                }
            }
        }
        
        repaint();
    }
    public void fillcanvas(Color color) {
        for(int y=0;y<canvas.getHeight();y++) {
            for(int x=0;x<canvas.getWidth();x++) {
                canvas.setRGB(x,y,color.getRGB());
            }
        }
        repaint();
    }

}