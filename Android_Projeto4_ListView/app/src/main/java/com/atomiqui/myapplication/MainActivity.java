package com.atomiqui.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listView_locais;
    private String[] locais = {
            "Abadia de Goiás (GO)",
            "Abadia dos Dourados (MG)",
            "Abadiânia (GO)",
            "Abaeté (MG)",
            "Abaetetuba (PA)",
            "Abaiara (CE)",
            "Abaíra (BA)",
            "Abaré (BA)"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView_locais = findViewById(R.id.ListView_locais);

        // Adaptador para lista:
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                locais
        );

        listView_locais.setAdapter(adapter);

        // Clique na lista
        listView_locais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String itemSelecionado = listView_locais.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), itemSelecionado, Toast.LENGTH_SHORT).show();
            }
        });
    }
}