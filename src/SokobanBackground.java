import javax.swing.JFrame;

public class SokobanBackground extends JFrame {

    private final int offset = 300;


    private void initUI() {
        
        Frame Board = new Frame();
        add(Board);
        setTitle("SM-Sokoban");
        setSize(Board.getWidth() + 2 * offset,
                Board.getHeight() + 2 * offset);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    public SokobanBackground() {

        initUI();
    }

    public static void main(String[] args) {

            SokobanBackground board = new SokobanBackground();
            board.setVisible(true);
        
    }
}

