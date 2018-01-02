
/**
 * Created by Réka on 2017. 12. 27..
 */

import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.List;

public class RotateTransform extends PApplet {
    private float angle = 0;

    public static void main(String[] args) {
        PApplet.main(RotateTransform.class);
    }

    @Override
    public void settings() {
        size(1280, 720);
    }

    @Override
    public void setup() {
    }

    @Override
    public void draw() {
        background(200f);
        translate(width / 2, height / 2);   // move (0, 0) to the center of the window
        float unit = width / 2 / 10;        // calculate the length of a unit in pixels
        scale(unit, -unit);                 //scale(x unit, y unit)

        pushMatrix(); // saves the current transformation

        // TODO 1: comment out
        rotate(angle);      //rotates the object with angle
        angle += 0.01f;     //which increases with 0.01f all the time

        drawOrdinaryShape();    //calls the function called drawOrdinaryShape(), which is specified later

        // P point:
        PVector P = new PVector(1, 0);      //P point is at (1, 0)

        // TODO 2: rotate P point with @angle here

        float x0 = P.x; // change these
        float y0 = P.y; // change these

        stroke(0xffff0000);     //has a red stroke
        strokeWeight(0.05f);    //the stroke is 0.05f thick
        line(0, 0, x0, y0);     //draws a line from (0,0) to P point

        popMatrix();            // resets the previous transformation (removes rotation)

        drawCoord(unit);        //calls the function called drawCoord() (the unit is 'unit'), which is specified later
    }

    /**
     * Draws a random shape
     */
    private void drawOrdinaryShape() {
        List<PVector> points = new ArrayList<>();
        points.add(new PVector(-1, 2));
        points.add(new PVector(5, 4));
        points.add(new PVector(3, 0));
        points.add(new PVector(4, -3));
        points.add(new PVector(0, -2));
        points.add(new PVector(-4, -3));
        points.add(new PVector(-2, 0));
        points.add(new PVector(-3, 3));
        points.add(new PVector(-2, 4));
        points.add(new PVector(0, 3));

        noStroke();         //this random shape has no stroke
        fill(0, 210, 255);  //this random shape is coloured blue

        beginShape();
        for (PVector point : points) {
            // TODO 3: rotate every point with @angle here, hint coming next week

            float x0 = point.x; // change these
            float y0 = point.y; // change these

            curveVertex(x0, y0);
        }
        endShape();
    }

    /**
     * Draws the coordinate axes
     * Up and Right are the positive directions
     *
     * @param unit
     */

    private void drawCoord(float unit) {
        stroke(0);

        // coordinate axis
        strokeWeight(0.01f);                    //it has a stroke
        color(0);                               //colour is black
        line(-width / 2, 0, width / 2, 0);      //draws the two lines
        line(0, -height / 2, 0, height / 2);

        // arrows
        float side = 0.2f;
        fill(0f);       //also black
        noStroke();
        triangle(0, height / unit / 2, side, height / unit / 2 - side, -side, height / unit / 2 - side);    //triangles to the end
        triangle(width / unit / 2, 0, width / unit / 2 - side, -side, width / unit / 2 - side, side);

        // mark numbers
        fill(255f);
        stroke(0);
        strokeWeight(0.05f);
        for (int x = 0; x <= width / unit / 2; x++) {
            point(x, 0);
            point(-x, 0);
        }
        for (int y = 1; y <= height / unit / 2; y++) {
            point(0, y);
            point(0, -y);
        }
    }

    private void rotateByMyself(){
        for (int i = 0; i < 5; i++) {

        }
    }
}
