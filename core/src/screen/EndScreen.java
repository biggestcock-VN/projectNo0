package screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import entity.TestAGV;
import game.MyGdxGame;

public class EndScreen implements Screen {

    private Viewport viewport;
    private Stage stage;

    private Game game;

    public EndScreen(Game game){
        this.game = game;
        viewport = new FitViewport(1352, 728, new OrthographicCamera());
        stage = new Stage(viewport, ((MyGdxGame) game).batch);

        Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);

        Table table = new Table();
        table.center();
        table.setFillParent(true);

        Label gameOverLabel = new Label("GAME OVER", font);
        Label playAgainLabel = new Label("Press R to Play Again", font);
        Label rankLabel = new Label("your rank is "+ (TestAGV.counter + 1), font);
        TestAGV.counter = 0;
        table.add(gameOverLabel).expandX();
        table.row();
        table.add(rankLabel).expandX().padTop(10f);
        table.row();
        table.add(playAgainLabel).expandX().padTop(20f);
        
        stage.addActor(table);
    }

    
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
        if(Gdx.input.isKeyPressed(Input.Keys.R)) {
            game.setScreen(new GameScreen((MyGdxGame) game));
            dispose();
        }
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {

	   stage.dispose();
		
	}
	
}