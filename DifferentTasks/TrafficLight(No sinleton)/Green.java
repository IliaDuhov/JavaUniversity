public class Green implements Colourable{
    public String toString(){
        return "Green";
    }
    @Override
    public Red nextColour(){
        return new Red();
    }
}