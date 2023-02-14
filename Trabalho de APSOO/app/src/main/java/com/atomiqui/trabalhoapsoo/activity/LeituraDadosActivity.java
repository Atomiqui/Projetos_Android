package com.atomiqui.trabalhoapsoo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.atomiqui.trabalhoapsoo.R;
import com.atomiqui.trabalhoapsoo.objetos.Jogador;
import com.atomiqui.trabalhoapsoo.padroes.memento.Originator;
import com.google.android.material.textfield.TextInputEditText;

public class LeituraDadosActivity extends AppCompatActivity {

    private TextInputEditText textInputNome, textInputAnnotation;
    private String name, annotation;
    private Button buttonSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_leitura_dados);

        textInputNome = findViewById (R.id.textInputNome);
        textInputAnnotation = findViewById (R.id.textInputAnnotation);
        buttonSalvar = findViewById (R.id.buttonSalvar);

        listenerSalvar();
    }

    private void listenerSalvar() {
        buttonSalvar.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                salvaDados (view);
            }
        });
    }

    private void salvaDados (View view) {

        if (getDados (view)) { return; }

        MainActivity.savedStates.add(Originator.obterInstancia ().saveToMemento(this.name, this.annotation));

        finish ();
    }

    private boolean getDados(View view) {
        this.name = textInputNome.getText ().toString ();
        if (this.name.equals ("")) {
            Toast.makeText (view.getContext (), "Preencha o campo 'Nome'!", Toast.LENGTH_SHORT).show ();
            return true;
        }

        this.annotation = textInputAnnotation.getText ().toString ();
        if (this.annotation.equals ("")) {
            this.annotation = "";
        }

        return false;
    }
}