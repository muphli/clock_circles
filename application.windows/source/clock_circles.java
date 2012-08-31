import processing.core.*; 
import processing.xml.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class clock_circles extends PApplet {

final float marginOrientationPoints = 50.0f;

final float widthHoursCircle = 235.0f;
final float heightHoursCircle = 235.0f;

final float widthMinutesCircle = 155.0f;
final float heightMinutesCircle = 155.0f;

final float widthSecondsCircle = 75.0f;
final float heightSecondsCircle = 75.0f;

final int colorHours = color(186, 193, 34);
final int colorMinutes = color(199, 0, 56);
final int colorSeconds = color(208, 231, 255);

final int colorOrientation = color(255, 255, 255);
final int colorBackground = color(0, 0, 0);

final int stroke = 5;

PFont font;


public void setup(){
  size(500, 500);
  smooth();
  font = loadFont("Lobster-48.vlw");
  textFont(font, 26);
}

public void draw(){
  background(colorBackground);
  strokeWeight(stroke);
  drawText();
  drawOrientationPoints();
  drawSecondsCircle();
  drawMinutesCircle();
  drawHoursCircle();
}

public void drawText(){
  String text;
  if (hour() > 12){
    text = "p.m.";
  }
  else text = "a.m.";
  text(text, width/2 + 3, height/2 + 5);
  textAlign(CENTER);
  fill(255, 255, 255);
  noFill();
}

public void drawOrientationPoints(){
  stroke(colorOrientation);
  //clock-wise
  point(width/2, height/2 - heightHoursCircle/2 - marginOrientationPoints);
  point(width/2 + widthHoursCircle/2 + marginOrientationPoints, height/2);
  point(width/2, height/2 + heightHoursCircle/2 + marginOrientationPoints);
  point(width/2 - widthHoursCircle/2 - marginOrientationPoints, height/2);
}

public void drawSecondsCircle(){
  stroke(colorSeconds);
  float secondsValue = (second()/60.0f + 1);
  arc(width/2, height/2, widthSecondsCircle, heightSecondsCircle, TWO_PI - PI/2, TWO_PI * (secondsValue) - PI/2);
}

public void drawMinutesCircle(){
  stroke(colorMinutes);
  float minutesValue = (minute()/60.0f + 1);
  arc(width/2, height/2, widthMinutesCircle, heightMinutesCircle, TWO_PI - PI/2, TWO_PI * (minutesValue) - PI/2);
}

public void drawHoursCircle(){
  stroke(colorHours);
  float hoursValue = (((hour()%12.0f)/12.0f) + 1);
  arc(width/2, height/2, widthHoursCircle, heightHoursCircle, TWO_PI - PI/2, TWO_PI * (hoursValue) - PI/2);
}
  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#FFFFFF", "clock_circles" });
  }
}
