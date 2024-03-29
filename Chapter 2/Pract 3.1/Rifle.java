
public class Rifle extends Pistol {
    private final int shootPerSec;
    
    public Rifle(){
        super(30);
        this.shootPerSec = 30;
    }
    public Rifle(int ammo){
        super(ammo);
        this.shootPerSec = ammo / 2;
    }
    public Rifle(int ammo, int shootPerSec){
        super(ammo);
        if(shootPerSec > 0){
            this.shootPerSec = shootPerSec;
        } else throw new IllegalArgumentException(shootPerSec + " is not a possible variable");
    }
    @Override
    public void shoot(){
        for(int i = 0; i<shootPerSec; i++){
            System.out.println("Bax");
        }
    }
    public void shoot(int secs){
        for(int i = 0; i < this.shootPerSec * secs; i++) super.shoot();
    }
    
}
