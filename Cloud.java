import java.awt.image.BufferedImage;

public class Cloud extends Sprite {

    final int SPEED = 10;   //Geschwindigkeit der Wolken

    public Cloud(BufferedImage[] i, double x, double y, long delay, GamePanel p) {
        super(i, x, y, delay, p);

        if((int) (Math.random()*2)>1){  //Bewegungsrichtung wird zufällig gewählt
            setHorizontalSpeed(-SPEED);
        }else{
            setHorizontalSpeed(SPEED);
        }
    }

    @Override
    public void doLogic(long delta) {    //doLogic-Methode wird überschrieben, um die Logik für
        //das Verlassen des Bildschirms zu hinterlegen (Wolken kommen beim anderen Ende wieder raus)
        super.doLogic(delta);

        //2 if-Abfragen: wird geprüft, ob die Wolke außerhalb des sichtbaren Bereichs ist und bewegen sie auf die andere Seite
        if(getHorizontalSpeed()>0 && getX()>parent.getWidth()){
            setX(-getWidth());
        }

        if(getHorizontalSpeed()<0 && (getX()+getWidth()<0)){
            setX(parent.getWidth()+getWidth());
        }
    }

    @Override
    public boolean collidedWith(Sprite s) {
        return false;
    }
}
