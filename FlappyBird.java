import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;


public class FlappyBird extends JPanel implements ActionListener  {
    int boardWidth = 360;
    int boardHeight = 640;

//Images here :
    Image backgroundImg;
    Image birdImg;
    Image topPipeImg;
    Image bottomPipeImg;

    class Bird {
        int x = birdX;
        int y = birdY;
        int width = birdWidth;
        int height = birdHeight;
        Image img;

        Bird(Image img) {
            this.img = img;
        }
    }

    //Bird fixing acording the size
    int birdX = boardWidth/8;
    int birdY = boardHeight/2;
    int birdWidth = 34;
    int birdHeight = 24;

    Bird bird; // game logic
    int velocityY= -6;

    Timer gameLoop;

    FlappyBird() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.blue);

        // loading the images
        backgroundImg = new ImageIcon(getClass().getResource("./flappybirdbg.png")).getImage();
        birdImg = new ImageIcon(getClass().getResource("./flappybird.png")).getImage();
        topPipeImg = new ImageIcon(getClass().getResource("./toppipe.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("./bottompipe.png")).getImage();

        bird = new Bird(birdImg);

        gameLoop = new Timer(1000/60, this);
        gameLoop.start();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        System.out.println("draw");
        g.drawImage(backgroundImg, 0, 0, boardWidth, boardHeight, null); // Background 

        g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null);

    }

    public void move() {
        bird.y += velocityY;
    }

    @Override 
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }
    
}
