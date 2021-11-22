package cl.primerproyecto.appmovilesfix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetallePlanta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_planta);

        TextView nombreplanta = findViewById(R.id.txtnombreplanta);

        Planta rest = (Planta)getIntent().getSerializableExtra("Planta");

        nombreplanta.setText(rest.getNombre());

        /*
            Button btnpaginaweb = (Button) findViewById(R.id.btnpaginaweb);
            btnpaginaweb.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + rest.getPaginaweb()));
                startActivity(intent);
                }
            });
            */





    }
}