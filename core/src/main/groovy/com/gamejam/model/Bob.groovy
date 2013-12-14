package com.gamejam.model

import com.badlogic.gdx.math.Vector2

/**
 * Created by 
 * Matthew Fitzpatrick 
 * on 14-Dec-2013
 * at 4:04 PM
 */
class Bob {
    Vector2 position;
    int currentLine;

    public Bob(int currentLine) {
        this.position = new Vector2();
        this.setCurrentLine(currentLine);
    }

    public void setCurrentLine(int newLine) {
        System.out.println("Setting New BobLine: " + newLine);
        this.currentLine = newLine;
        updatePosition();
    }

    private void updatePosition() {
        switch (currentLine) {
            case 1:
                position.set(LinePosHelper.LINE_0.getLinePosition(0).x, (LinePosHelper.LINE_0.getLinePosition(0).y + 84).toFloat());
                break;
            case 2:
                position.set(LinePosHelper.LINE_1.getLinePosition(0).x, (LinePosHelper.LINE_1.getLinePosition(0).y + 84).toFloat());
                break;
            case 3:
                position.set(LinePosHelper.LINE_2.getLinePosition(0).x, (LinePosHelper.LINE_2.getLinePosition(0).y + 84).toFloat());
                break;
            case 4:
                position.set(LinePosHelper.LINE_3.getLinePosition(0).x, (LinePosHelper.LINE_3.getLinePosition(0).y + 84).toFloat());
                break;
            case 5:
                position.set(LinePosHelper.LINE_4.getLinePosition(0).x, (LinePosHelper.LINE_4.getLinePosition(0).y + 84).toFloat());
                break;
        }
    }

    public int getCurrentLine() {
        return this.currentLine;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

}