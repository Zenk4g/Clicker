package deusvult.clicker;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    RelativeLayout clickbtn;
    TextView count, time;
    Button startbtn;
    int n = 0;
    boolean timerisover = true;
    CountDownTimer timer;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count=findViewById(R.id.counterid);
        time=findViewById(R.id.timerid);
        clickbtn=findViewById(R.id.clickid);
        startbtn=findViewById(R.id.startbtnid);




        timer = new CountDownTimer(7000, 1000) {
            public void onTick(long millisUntilFinished) {
                time.setText("seconds remaining: " + millisUntilFinished / 1000);
            }
            public void onFinish() {
                timerisover = true;
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("score", n);
                startActivity(intent);
            }
        };

        startbtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                count.setText("0");
                startbtn.setVisibility(View.GONE);
                timerisover = false;
                timer.start();
                clickbtn.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v) {
                        count.setText("" + n++);
                    }
                });
            }
        });

    }
}
