public class Piece{
    private int color;

    public Piece(String c){
        if(c.equals(" ")) color = 0;
        if(c.equals("red")) color = 1;
        if(c.equals("yellow")) color = 2;
    }
    public int getColor(){ return color; }
    public void setColor(String c){
        if(c.equals(" ")) color = 0;
        if(c.equals("red")) color = 1;
        if(c.equals("yellow")) color = 2;
    }
}
