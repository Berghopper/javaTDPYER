package gui_exercises.drawing_program.shapes;

import java.awt.Graphics;

public class Oval extends Figure {
    @Override
    public void draw(Graphics g) {
        g.drawOval(x1,y1,x2-x1,y2-y1);
    }
}
