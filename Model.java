import java.lang.Math;
public class Model {
    private Particle[][] matrix;
    private Particle[] particles;
    Model(int n,int width,int height) {
        matrix = new Particle[height][width];
        particles = new Particle[n];
        for(int i=0;i<height;i++) {
            for(int j=0;j<width;j++) {
                matrix[i][j] = null;
            }
        }
        for(int i=0;i<n;i++) {
            Particle p = new Particle(width,height);
            float[] pos = p.getPos();
            matrix[Math.round(pos[1])][Math.round(pos[0])] = p;
            particles[i]=p;
        }
    }
    public void update(float L) {
        for(int i=0; i<particles.length;i++) {
            int[] xchange = {0,0,1,1,1,-1,-1,-1};
            int[] ychange = {-1,1,1,-1,0,1,-1,0};
            float[] pos = particles[i].getPos();
            int x = Math.round(pos[0]);
            int y = Math.round(pos[1]);
            for(int j=0;j<8;j++) {
                try {
                    if(!matrix[y+ychange[j]][x+xchange[j]].isMoving()) {
                            particles[i].stopmoving();
                    }
                } catch(Exception e) {
                }
            }
        }
        for(int i=0; i<particles.length;i++) {
            float[] prepos = particles[i].getPos();
            particles[i].move(L);
            float[] postpos = particles[i].getPos();
            matrix[Math.round(prepos[1])][Math.round(prepos[0])]=null;
            matrix[Math.round(postpos[1])][Math.round(postpos[0])]=particles[i];
        }
        

    }
    public Particle[][] getStatus() {
        return matrix;
    }
}
