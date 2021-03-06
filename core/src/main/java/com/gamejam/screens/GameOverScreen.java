package com.gamejam.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.TimeUtils;
import com.gamejam.game.GameJam;


/**
 * Created by
 * Matthew Fitzpatrick
 * on 14-Dec-2013
 * at 8:10 PM
 */
public class GameOverScreen extends ArcadeScreen implements InputProcessor {
    private Image gameOver;
    long shownAtTime;
    long lagTime = 2000000000;

    protected GameOverScreen(GameJam game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();

        game.stopMusic();
//        game.setMusic(Gdx.audio.newMusic(Gdx.files.internal("AustinPowers.mp3")));
        game.loopMusic();
        game.playMusic();


        //do cool magic scene2d here
        gameOver = new Image(new Texture("gameOver.png"));
        gameOver.setPosition(275, 200);
        stage.addActor(gameOver);

        //display final Score
        Label gameOverMessage = new Label("Press Enter to Restart", getSkin());
        gameOverMessage.setPosition(350, 150);
        gameOverMessage.setFontScale(2f);
        stage.addActor(gameOverMessage);

        Label returnToMenu = new Label("Press any key to go to Main Menu ", getSkin());
        returnToMenu.setPosition(275, 100);
        returnToMenu.setFontScale(2f);
        stage.addActor(returnToMenu);
        shownAtTime = TimeUtils.nanoTime();

        Gdx.input.setInputProcessor(this);
    }


    @Override
    public void update(float delta) {

    }

    @Override

    public void draw(float delta) {

    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    protected String getName() {
        return GameOverScreen.class.getName();
    }

    @Override
    public boolean keyDown(int keycode) {
        if (TimeUtils.nanoTime() - shownAtTime > lagTime) {
            switch (keycode) {
                case Input.Keys.ENTER:
                case Input.Keys.SPACE:
                    game.setScreen(new GameScreen(game));
                    break;
                default:
                    game.setScreen(new MainMenu(game));
                    break;
            }
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
