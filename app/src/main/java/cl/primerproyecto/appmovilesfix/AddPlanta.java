package cl.primerproyecto.appmovilesfix;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlanta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plantita);

        Button btnguardar = findViewById(R.id.btnguardar);

        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText txtnombre = findViewById(R.id.txtnombre);
                EditText f_asignada = findViewById(R.id.fechaasignada);
                EditText h_asignada = findViewById(R.id.horaasignada);
                EditText u_regado = findViewById(R.id.ultimoregado);

                String nombre = txtnombre.getText().toString().trim();
                String fe_asignada = f_asignada.getText().toString().trim();
                String hor_asignada = h_asignada.getText().toString().trim();
                String ult_regado = u_regado.getText().toString().trim();

                Planta rest = new Planta(nombre, fe_asignada, hor_asignada, ult_regado);

                if (nombre.length() == 0) {
                    Toast.makeText(AddPlanta.this, "debes de ingresar un nombre", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (fe_asignada.length() == 0) {
                    Toast.makeText(AddPlanta.this, "debes de ingresar una fecha asignada", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (hor_asignada.length() == 0) {
                    Toast.makeText(AddPlanta.this, "debes de ingresar una hora asignada", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent();

                intent.putExtra("Planta", rest);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}