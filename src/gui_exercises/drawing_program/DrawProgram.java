package gui_exercises.drawing_program;

import gui_exercises.drawing_program.shapes.*;
import gui_exercises.drawing_program.shapes.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DrawProgram extends JFrame {

    JMenuBar menuBar;
    JMenu menu, submenu;
    JMenuItem menuItem;
    JRadioButtonMenuItem rbMenuItem;
    JCheckBoxMenuItem cbMenuItem;
    DrawingPanel drawingPanel;
//    private JLayeredPane layeredPane;

    public DrawProgram() throws HeadlessException {
        // MENU===
        //Where the GUI is created:


        //Create the menu bar.
        menuBar = new JMenuBar();

        //Build the first menu.
        menu = new JMenu("Draw...");
        menuBar.add(menu);



        //a submenu
        submenu = new JMenu("Shapes");

        //a group of radio button menu items
        ButtonGroup shapesGroup = new ButtonGroup();
        rbMenuItem = new JRadioButtonMenuItem("Rectangle");
        rbMenuItem.setSelected(true);
        shapesGroup.add(rbMenuItem);
        submenu.add(rbMenuItem);

        rbMenuItem = new JRadioButtonMenuItem("Oval/Circle");
        shapesGroup.add(rbMenuItem);
        submenu.add(rbMenuItem);
        rbMenuItem = new JRadioButtonMenuItem("Line");
        shapesGroup.add(rbMenuItem);
        submenu.add(rbMenuItem);

        menu.add(submenu);

        this.setJMenuBar(menuBar);
        // END MENU===
        drawingPanel = new DrawingPanel(menu);
        drawingPanel.setBounds(0,0,300,200);
        getContentPane().add(drawingPanel);
    }

    public static void main(String[] args) {
        DrawProgram drawProgram = new DrawProgram();
        drawProgram.setSize(500,500);
        drawProgram.setVisible(true);
        drawProgram.setDefaultCloseOperation(EXIT_ON_CLOSE);
        System.out.println(drawProgram.getJMenuBar().getMenu(0).getItem(0).getText());
    }


}

class DrawingPanel extends JPanel implements MouseListener{
    ArrayList<Figure> figures = new ArrayList<>();
    Figure figure = new Oval();
    JMenu mainMenu;

    public DrawingPanel(JMenu mainMenu){
        this.addMouseListener(this);
        this.mainMenu = mainMenu;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        g.drawString("A text!",30,30);
        for (Figure f : figures) {
            f.draw(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        JMenu shapes = (JMenu) mainMenu.getItem(0);
        if (shapes.getItem(0).isSelected()) {
            figure = new Rectangle();
        } else if (shapes.getItem(1).isSelected()) {
            figure = new Oval();
        } else if (shapes.getItem(2).isSelected()) {
            figure = new Line();
        }

        figure.x1 = e.getX();
        figure.y1 = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        figure.x2 = e.getX();
        figure.y2 = e.getY();
        figures.add(figure);
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}