
import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
 
public class GraphicInterface extends JFrame{
 
        private JFrame frame;
 
        /**
         * Launch the application.
         */
        public static void main(String[] args) {
                EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                try {
                                        GraphicInterface window = new GraphicInterface();
                                        window.frame.setVisible(true);
                                } catch (Exception e) {
                                        e.printStackTrace();
                                }
                        }
                });
        }
 
        /**
         * Create the application.
         */
        public GraphicInterface() {
                initialize();
        }
 
        /**
         * Initialize the contents of the frame.
         */
        private void initialize() {
                frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
       
        JMenu mnActions = new JMenu("Actions");
        menuBar.add(mnActions);
       
        JMenuItem mntmGnrerSudoku = new JMenuItem("G\u00E9n\u00E9rer sudoku");
        mnActions.add(mntmGnrerSudoku);
       
        JMenuItem mntmRsoudreSudoku = new JMenuItem("R\u00E9soudre sudoku");
        mnActions.add(mntmRsoudreSudoku);
       
        JMenu mnNewMenu = new JMenu("Taille");
        menuBar.add(mnNewMenu);
       
        JMenuItem mntmx = new JMenuItem("4x4");
        mnNewMenu.add(mntmx);
       
        JMenuItem mntmx_1 = new JMenuItem("9x9");
        mnNewMenu.add(mntmx_1);
       
        JMenuItem mntmx_2 = new JMenuItem("16x16");
        mnNewMenu.add(mntmx_2);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
       
        int taille = 3;
        Node[][] tabTestDiabolique =
                {
                                {new Node(5,0,0,taille),new Node(3,0,1,taille),new Node(4,0,2,taille),new Node(6,0,3,taille),new Node(7,0,4,taille),new Node(8,0,5,taille),new Node(9,0,6,taille),new Node(1,0,7,taille),new Node(2,0,8,taille)},
                                {new Node(6,1,0,taille),new Node(7,1,1,taille),new Node(2,1,2,taille),new Node(1,1,3,taille),new Node(9,1,4,taille),new Node(5,1,5,taille),new Node(3,1,6,taille),new Node(4,1,7,taille),new Node(8,1,8,taille)},
                                {new Node(1,2,0,taille),new Node(9,2,1,taille),new Node(8,2,2,taille),new Node(3,2,3,taille),new Node(4,2,4,taille),new Node(2,2,5,taille),new Node(5,2,6,taille),new Node(6,2,7,taille),new Node(7,2,8,taille)},
                                {new Node(8,3,0,taille),new Node(5,3,1,taille),new Node(9,3,2,taille),new Node(7,3,3,taille),new Node(6,3,4,taille),new Node(1,3,5,taille),new Node(4,3,6,taille),new Node(2,3,7,taille),new Node(3,3,8,taille)},
                                {new Node(4,4,0,taille),new Node(2,4,1,taille),new Node(6,4,2,taille),new Node(8,4,3,taille),new Node(5,4,4,taille),new Node(3,4,5,taille),new Node(7,4,6,taille),new Node(9,4,7,taille),new Node(1,4,8,taille)},
                                {new Node(7,5,0,taille),new Node(1,5,1,taille),new Node(3,5,2,taille),new Node(9,5,3,taille),new Node(2,5,4,taille),new Node(4,5,5,taille),new Node(8,5,6,taille),new Node(5,5,7,taille),new Node(6,5,8,taille)},
                                {new Node(9,6,0,taille),new Node(6,6,1,taille),new Node(1,6,2,taille),new Node(5,6,3,taille),new Node(3,6,4,taille),new Node(7,6,5,taille),new Node(2,6,6,taille),new Node(8,6,7,taille),new Node(4,6,8,taille)},
                                {new Node(2,7,0,taille),new Node(8,7,1,taille),new Node(7,7,2,taille),new Node(4,7,3,taille),new Node(1,7,4,taille),new Node(9,7,5,taille),new Node(6,7,6,taille),new Node(3,7,7,taille),new Node(5,7,8,taille)},
                                {new Node(3,8,0,taille),new Node(4,8,1,taille),new Node(5,8,2,taille),new Node(2,8,3,taille),new Node(8,8,4,taille),new Node(6,8,5,taille),new Node(1,8,6,taille),new Node(7,8,7,taille),new Node(9,8,8,taille)}
                };
     
        Generation s = new Generation(tabTestDiabolique, taille);
        s.generateSudoku();
        JPanel gridPanel = new JPanel(new GridLayout(taille*taille,taille));
        gridPanel.setToolTipText("");
        gridPanel.setForeground(Color.BLACK);
        gridPanel.setBackground(Color.WHITE);
        gridPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        for(int i = 0; i < taille*taille; i++){
                for(int j = 0; j < taille*taille; j++){
                        Node n = s.getNode(i, j);
                        JLabel label = new JLabel(Integer.toString(n.getValue()));
                        gridPanel.add(label);
                }
                getContentPane().setLayout(new GridBagLayout());
        }
        frame.getContentPane().add(gridPanel);
       
        }
}