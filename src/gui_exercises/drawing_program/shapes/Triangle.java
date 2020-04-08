package gui_exercises.drawing_program.shapes;

import java.awt.Graphics;

public class Triangle extends Figure {
    @Override
    public void draw(Graphics g) {
        // TODO fix this mess (store more points to make life easier)
        g.drawLine(x1,y2,x2,y2);
        g.drawLine(x2,y2,x2/2,y1);
        g.drawLine(x1,y2,x2/2,y2);
    }
}