package gui_exercises.drawing_program.shapes;

import java.awt.Graphics;

public class Triangle extends Figure {
    @Override
    public void draw(Graphics g) {
        // TODO add freehand triangle
        g.drawLine(x1,y1,x2,y1);
        g.drawLine(x1,y1,x1,y2);
        g.drawLine(x1,y2,x2,y1);
    }
}