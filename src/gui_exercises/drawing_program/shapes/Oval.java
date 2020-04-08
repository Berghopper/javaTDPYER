package gui_exercises.drawing_program.shapes;

import java.awt.Graphics;

public class Oval extends Figure {
    @Override
    public void draw(Graphics g) {
        correctCoordsForDraw();
        g.drawOval(correctedCoords[0],correctedCoords[1],correctedCoords[2],correctedCoords[3]);
    }
}
