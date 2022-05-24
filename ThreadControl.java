package folder;


import javafx.animation.Timeline;


public class ThreadControl implements Runnable {

    private int x;
    Timeline animation;
    

    public ThreadControl(int a,  Timeline animation) {
        x = a;
        this.animation=animation;
    }

    @Override
    public void run() {
         animation.setRate(x);
         animation.play();

    }

}
