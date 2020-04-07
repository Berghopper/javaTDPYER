package gui_exercises.drawing_program;

import gui_exercises.drawing_program.shapes.*;
import gui_exercises.drawing_program.shapes.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class DrawProgram extends JFrame implements MouseListener {

    ArrayList<Figure> figures = new ArrayList<>();
    Figure figure = new Oval();

    public DrawProgram() throws HeadlessException {
        addMouseListener(this);
    }

    public static void main(String[] args) {
        DrawProgram drawProgram = new DrawProgram();
        drawProgram.setSize(500,500);
        drawProgram.setVisible(true);
        drawProgram.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Figure f : figures) {
            f.draw(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        figure = new Rectangle();
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
