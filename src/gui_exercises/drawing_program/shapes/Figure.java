package gui_exercises.drawing_program.shapes;

import java.awt.Graphics;

public abstract class Figure {
    public int x1, y1, x2, y2;
    protected int[] correctedCoords;

    private int[] correctCoordsForDrawSingle(int i1, int i2) {
        if ((i2-i1) > 0) {
            return new int[] {i1, i2-i1};
        }
        return new int[] {i2, i1-i2};
    }

    public void correctCoordsForDraw() {
        correctedCoords = new int[] {correctCoordsForDrawSingle(x1, x2)[0],
                correctCoordsForDrawSingle(y1, y2)[0],
                correctCoordsForDrawSingle(x1, x2)[1],
                correctCoordsForDrawSingle(y1, y2)[1]};
    }

    public abstract void draw(Graphics g);
}
