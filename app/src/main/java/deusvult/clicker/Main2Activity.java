package deusvult.clicker;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView counter, txt;
    Button replaybtn;
    boolean replayon = false;
    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        replaybtn=findViewById(R.id.buttonid);
        counter=findViewById(R.id.counterid);
        txt=findViewById(R.id.timerid);


        timer = new CountDownTimer(5000, 1000) {
            public void onTick(long millisUntilFinished) {
                txt.setText("seconds for replay: " + millisUntilFinished / 1000);
            }
            public void onFinish() {
                txt.setText("push button for replay");
                replayon = true;
            }
        }.start();


        Intent intent = getIntent();
        int n = intent.getIntExtra("score", 0) - 1;


        if( n == -1 ) counter.setText( "You're still too weak for this game" );
        if( n <= 10 && n!=-1 ) counter.setText( "Your result is " + n + " ( bad )" );
        if( n > 10 ) counter.setText( "Your result is " + n + " ( good )" );
        replaybtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if( replayon == true )
                    startActivity(new Intent(Main2Activity.this, MainActivity.class));
            }
        });
    }
}