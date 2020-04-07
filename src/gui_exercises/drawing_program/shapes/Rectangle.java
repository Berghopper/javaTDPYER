package gui_exercises.drawing_program.shapes;

import java.awt.Graphics;

public class Rectangle extends Figure {
    @Override
    public void draw(Graphics g) {
        correctCoordsForDraw();
        g.drawRect(correctedCoords[0],correctedCoords[1],correctedCoords[2],correctedCoords[3]);
    }
}
