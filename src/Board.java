import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Board extends JPanel {
    private final Color BACKGROUND = new Color(13, 90, 166);
    private boolean turn;

    private int win;
    public static Piece[][] pieces = new Piece[7][6];
    public Board(){
        setBackground(BACKGROUND);
        turn = true;
        win = 0;
        for(int c=0;c<pieces.length;c++){
            for(int r=0;r<pieces[0].length;r++){
                pieces[c][r] = new Piece(" ");
            }
        }
        this.setFocusable(true);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                int mX = e.getX();
                int count = 0;
                String np;
                for(int x = 0;x*100<700;x++){
                    if(x*100<mX && mX<=x*100+100){
                        count = x;

                        if(turn) np = "red";
                        else np = "yellow";

                        //int r=0;
                        for(int r=0;r<pieces[0].length;r++){
                            if(pieces[count][r].getColor()==0){
                                pieces[count][r].setColor(np);
                                break;
                            }
                            //r++;
                        }
                        //r=0;
                    }
                }
                turn = !turn;
                win = checkWin();
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int c=0;c<pieces.length;c++){
            for(int r=0;r<pieces[0].length;r++){
                if(pieces[c][r].getColor() == 0){
                    g.setColor(new Color(255, 255, 255));
                }
                else if(pieces[c][r].getColor() == 1){
                    g.setColor(new Color(192, 2, 2));
                }
                else if(pieces[c][r].getColor() == 2){
                    g.setColor(new Color(232, 186, 66));
                }
                g.fillOval(c*100+10, 510-r*100+10, 80,80);
            }
        }
        repaint();

    }
    public int checkWin(){
        for(int c=0;c<pieces.length-3;c++){
            for(int r=0;r<pieces[0].length-3;r++){
                if(pieces[c][r].getColor() != 0) {
                    if (pieces[c][r].getColor() == pieces[c + 1][r].getColor()
                            && pieces[c][r].getColor() == pieces[c + 2][r].getColor()
                            && pieces[c][r].getColor() == pieces[c + 3][r].getColor()) {
                        return pieces[c][r].getColor();
                    }
                    if (pieces[c][r].getColor() == pieces[c][r + 1].getColor()
                            && pieces[c][r].getColor() == pieces[c][r + 2].getColor()
                            && pieces[c][r].getColor() == pieces[c][r + 3].getColor()) {
                        return pieces[c][r].getColor();
                    }
                    if (pieces[c][r].getColor() == pieces[c + 1][r + 1].getColor()
                            && pieces[c][r].getColor() == pieces[c + 2][r + 2].getColor()
                            && pieces[c][r].getColor() == pieces[c + 3][r + 3].getColor()) {
                        return pieces[c][r].getColor();
                    }
                }
            }
            for(int r=pieces[0].length-1; r>=3;r--){
                if(pieces[c][r].getColor() != 0) {
                    if (pieces[c][r].getColor() == pieces[c + 1][r - 1].getColor()
                            && pieces[c][r].getColor() == pieces[c + 2][r - 2].getColor()
                            && pieces[c][r].getColor() == pieces[c + 3][r - 3].getColor()) {
                        return pieces[c][r].getColor();
                    }
                }
            }
        }
        return 0;
    }
    public void clearBoard(){
        for(int c = 0;c<pieces.length;c++){
            for(int r = 0;r<pieces[0].length;r++){
                pieces[c][r].setColor(" ");
            }
        }
    }
    public int getWin(){ return win; }
}
