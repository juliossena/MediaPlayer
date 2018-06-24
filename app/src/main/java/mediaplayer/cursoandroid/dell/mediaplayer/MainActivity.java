package mediaplayer.cursoandroid.dell.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button botao;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = (Button) findViewById(R.id.botao_id);
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.musica);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    pausarMusica();
                } else {
                    tocarMusica();
                }
            }
        });

    }

    private void tocarMusica() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
            botao.setText("Pausar");
        }
    }

    private void pausarMusica() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            botao.setText("Tocar");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
