package sg.edu.rp.c346.id22021136.songapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tvSongTitle;
    EditText etSongTitle;
    TextView tvSinger;
    EditText etSinger;
    TextView tvYear;
    EditText etYear;
    TextView tvStar;
    RadioButton RB1;
    RadioButton RB2;
    RadioButton RB3;
    RadioButton RB4;
    RadioButton RB5;
    Button btnInsert;
    Button btnShowList;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvSongTitle = findViewById(R.id.tvSongTitle);
        etSongTitle = findViewById(R.id.etSongTitle);
        tvSinger = findViewById(R.id.tvSinger);
        etSinger = findViewById(R.id.etSinger);
        tvYear = findViewById(R.id.tvYear);
        etYear = findViewById(R.id.etYear);
        tvStar = findViewById(R.id.tvStar);
        RB1 = findViewById(R.id.RB1);
        RB2 = findViewById(R.id.RB2);
        RB3 = findViewById(R.id.RB3);
        RB4 = findViewById(R.id.RB4);
        RB5 = findViewById(R.id.RB5);
        btnInsert = findViewById(R.id.btnInsert);
        btnShowList = findViewById(R.id.btnShowList);
        lv = findViewById(R.id.lv);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                db.insertSong(etSongTitle.getText().toString(), etSinger.getText().toString(), Integer.parseInt(etYear.getText().toString()));
                db.close();
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                ArrayList<Song> data = db.getSongs();
                db.close();

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    Log.d("Songs", i + ". " + data.get(i));
                    txt += i + ". " + data.get(i) + "\n";
                }

                ArrayAdapter<Song> aaSongs = new ArrayAdapter<Song>(MainActivity.this, android.R.layout.simple_list_item_1, data);
                lv.setAdapter(aaSongs);
            }
        });
    }
}
