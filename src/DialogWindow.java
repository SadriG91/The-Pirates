import javax.swing.*;
import java.awt.*;

public class DialogWindow {
    public static void Sea(String name, String lastHarbor, String destination, int currentWeight, int cruiseSpeed,
                           int x1, int y1,
                           int x2, int y2,
                           int x3, int y3,
                           int x4, int y4,
                           int x5, int y5,
                           int x6, int y6,
                           int x7, int y7,
                           int x8, int y8,
                           int x9, int y9,
                           int x10, int y10) {

        JFrame frame = new JFrame("SeaInfo");
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400, 1200);
        JLabel[][] sea = new JLabel[100][100];
        for (int i = 0; i < 100; i++){
            for (int j = 0; j < 100; j++){
                sea[i][j] = new JLabel();
                sea[i][j].setBackground(Color.BLUE);
                sea[i][j].setOpaque(true);
                panel1.add(sea[i][j]);
            }
        }
        JLabel l1 = new JLabel(name);
        JLabel l2 = new JLabel(lastHarbor);
        JLabel l3 = new JLabel(destination);
        JLabel l4 = new JLabel("weight"+currentWeight);
        JLabel l5 = new JLabel("speed"+cruiseSpeed);
        l1.setFont(new Font("Serif", Font.BOLD, 18));
        l2.setFont(new Font("Serif", Font.BOLD, 18));
        l3.setFont(new Font("Serif", Font.BOLD, 18));
        l4.setFont(new Font("Serif", Font.BOLD, 18));
        l5.setFont(new Font("Serif", Font.BOLD, 18));
        panel2.add(l1); panel2.add(l2); panel2.add(l3);
        panel2.add(l4); panel2.add(l5);
        panel2.setLayout(new GridLayout(30,1));
        panel1.setBounds(0, 0, 1200, 1200);
        panel1.setLayout(new GridLayout(100, 100));

        frame.add(panel1, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.EAST);
     
        sea[0][0].setBackground(Color.BLACK);
        sea[0][1].setBackground(Color.BLACK);
        sea[1][1].setBackground(Color.BLACK);
        sea[1][0].setBackground(Color.BLACK);

        sea[98][0].setBackground(Color.BLACK);
        sea[99][0].setBackground(Color.BLACK);
        sea[98][1].setBackground(Color.BLACK);
        sea[99][1].setBackground(Color.BLACK);

        sea[0][98].setBackground(Color.BLACK);
        sea[0][99].setBackground(Color.BLACK);
        sea[1][98].setBackground(Color.BLACK);
        sea[1][99].setBackground(Color.BLACK);

        sea[98][98].setBackground(Color.BLACK);
        sea[98][99].setBackground(Color.BLACK);
        sea[99][98].setBackground(Color.BLACK);
        sea[99][99].setBackground(Color.BLACK);

        sea[49][49].setBackground(Color.BLACK);
        sea[49][50].setBackground(Color.BLACK);
        sea[50][49].setBackground(Color.BLACK);
        sea[50][50].setBackground(Color.BLACK);

        
        sea[x1][y1].setBackground(Color.RED);
        sea[x2][y2].setBackground(Color.YELLOW);
        sea[x3][y3].setBackground(Color.YELLOW);
        sea[x4][x4].setBackground(Color.YELLOW);
        sea[x5][y5].setBackground(Color.YELLOW);
        sea[x6][y6].setBackground(Color.YELLOW);
        sea[x7][y7].setBackground(Color.YELLOW);
        sea[x8][y8].setBackground(Color.YELLOW);
        sea[x9][y9].setBackground(Color.YELLOW);
        sea[x10][y10].setBackground(Color.YELLOW);            

        frame.setVisible(true);
    }    
}