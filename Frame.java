import javax.swing.JFrame;
import javax.swing.JSlider;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.util.Timer;
import java.util.TimerTask;

public class Frame extends JFrame implements ActionListener{
    Timer modelthread;
    Timer viewthread;
    Model mod;
    Panel panel;
    JButton button;
    JSlider slider;
    Frame(String title,int width,int height, int n, Model mod) {
        setDefaultCloseOperation(3);
        pack();
        setBounds(0,0,width+15,height+38);
        setResizable(false);
        this.mod = mod;
        panel = new Panel(width,height,n,mod);
        button = new JButton("Start");
        button.setBounds(0, 0, 100,50);
        button.addActionListener(this);
        slider = new JSlider(10,100,10);
        panel.add(button);
        panel.add(slider);
        add(panel);
    }

    public static void main(String[] args) {
        int n = 20000;
        int width = 500;
        int height = 500;  
        Model mod = new Model(n,width,height);
        Frame frame = new Frame("Brownsk Rörelse",width,height, n, mod);
        frame.setVisible(true);

    }
	public void actionPerformed(ActionEvent e) {
        if(modelthread == null) {
            button.setText("Stop");
            modelthread = new Timer();
            viewthread = new Timer();
            modelthread.schedule(new TimerTask() {
                public void run() {
                    mod.update((float) 0.8);
            } 
            }, 0,11-slider.getValue()/10);
            viewthread.schedule(new TimerTask() {
                public void run() {
                    panel.update();
                }
            }, 0,17);
        } else {
            button.setText("Start");
            modelthread.cancel();
            viewthread.cancel();
            modelthread = null;
            viewthread = null;
        }
		
	}
}