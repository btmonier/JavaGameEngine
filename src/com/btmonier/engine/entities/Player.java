package com.btmonier.engine.entities;

import com.btmonier.engine.Game;
import com.btmonier.engine.graphics.Assets;
import java.awt.*;

public class Player extends Mob {

    private Game game;

    public Player(Game game, float x, float y) {
        super(x, y, Mob.DEFAULT_MOB_WIDTH, Mob.DEFAULT_MOB_HEIGHT);
        this.game = game;
    }

    @Override
    public void tick() {
        getInput();
        move();
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if (game.getKeyManager().up) {
            yMove = -speed;
        }
        if (game.getKeyManager().down) {
            yMove = speed;
        }
        if (game.getKeyManager().left) {
            xMove = -speed;
        }
        if (game.getKeyManager().right) {
            xMove = speed;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.scout, (int) x, (int) y, width, height, null);
    }
}
