package cl.primerproyecto.appmovilesfix;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<Planta> adapter;
    ArrayList<Planta> listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listado = new ArrayList<Planta>();

        ListView lista_plantas = findViewById(R.id.lst_plantas);
        this.adapter = new ArrayAdapter<Planta>(this, android.R.layout.simple_list_item_1);
        lista_plantas.setAdapter(adapter);

                ActivityResultLauncher<Intent> launchActivity = registerForActivityResult(
                        new ActivityResultContracts.StartActivityForResult(),
                        new ActivityResultCallback<ActivityResult>() {
                            @Override
                            public void onActivityResult(ActivityResult result) {
                                if (result.getResultCode() == Activity.RESULT_OK) {
                                    Intent data = result.getData();
                                    Log.i("DATA", data.toString());
                                    Planta rest = (Planta)data.getSerializableExtra("Planta");

                                    listado.add(rest);
                                    adapter.add(rest);
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        });

                lista_plantas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(MainActivity.this, DetallePlanta.class);
                        Planta rest = listado.get(position);
                        intent.putExtra("Planta", rest);
                        startActivity(intent);

                    }
                });

        Button btnagregar = findViewById(R.id.btnagregar);
        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, AddPlanta.class);
                launchActivity.launch(intent);
            }
        });
    }
}