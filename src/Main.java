import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(700, 640);
        Board board = new Board();
        frame.add(board);
        frame.setVisible(true);
        while(true){
            int win = board.checkWin();
            if(win == 1){
                int select = JOptionPane.showConfirmDialog(null, "Red Wins\nPlay Again?");
                if(select == JOptionPane.YES_OPTION){
                    board.clearBoard();
                }
                if(select == JOptionPane.NO_OPTION){
                    System.exit(0);
                }
                if(select == JOptionPane.CANCEL_OPTION){
                    JOptionPane.showMessageDialog(null, "coward");
                }
            }
            if(win == 2){
                int select = JOptionPane.showConfirmDialog(null, "Yellow Wins\nPlay Again?");
                if(select == JOptionPane.YES_OPTION){
                    board.clearBoard();
                }
                if(select == JOptionPane.NO_OPTION){
                    System.exit(0);
                }
                if(select == JOptionPane.CANCEL_OPTION){
                    JOptionPane.showMessageDialog(null, "coward");
                }
            }
        }
    }
}