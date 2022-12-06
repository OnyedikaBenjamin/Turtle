package turtle;


public class Pen {
    private PenPosition penPosition = PenPosition.UP;

    public PenPosition getPosition(){
        return penPosition;
    }

    public void setPosition(PenPosition currentPosition){
        penPosition = currentPosition;
    }
}
