package com.atomiqui.trabalhoapsoo.fragment;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;
import static com.atomiqui.trabalhoapsoo.fragment.EscalarAux.carregaCampo;
import static com.atomiqui.trabalhoapsoo.fragment.EscalarAux.createAlertDialog;
import static com.atomiqui.trabalhoapsoo.fragment.EscalarAux.criaRecyclerJogadores;
import static com.atomiqui.trabalhoapsoo.fragment.EscalarAux.validaShape;

import android.content.Intent;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.atomiqui.trabalhoapsoo.R;
import com.atomiqui.trabalhoapsoo.activity.LeituraDadosActivity;
import com.atomiqui.trabalhoapsoo.activity.MainActivity;
import com.atomiqui.trabalhoapsoo.activity.PerfilAcitivity;
import com.atomiqui.trabalhoapsoo.padroes.adapter.DragData;
import com.atomiqui.trabalhoapsoo.padroes.memento.Originator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EscalarFragment extends Fragment {
    private List<View> miniaturas = new ArrayList<> ();
    private Button buttonToSave, buttonLimpar;
    Originator originator = Originator.obterInstancia ();

    private static EscalarFragment instancia = new EscalarFragment ();

    private EscalarFragment () {}

    // testar se é nulo
    public static synchronized EscalarFragment obterInstancia () {
        return instancia;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_escalar, container, false);

        buttonLimpar = view.findViewById (R.id.buttonLimpar);
        limparListener(view);
        buttonToSave = view.findViewById(R.id.buttonToSave);
        saveListener();

        if(miniaturas.size() > 0) { carregaCampo (view, miniaturas); }

        criaRecyclerJogadores(view);
        dragListener(view);
        return view;
    }

    private void limparListener(View vieew) {
        buttonLimpar.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                CardView campo = vieew.findViewById(R.id.cardView);
                View image_campo = campo. findViewById(R.id.image_campo);
                campo.removeAllViewsInLayout ();
                campo.addView(image_campo);
                miniaturas.clear ();
            }
        });
    }

    @Override
    public void onDestroyView() {
        miniaturas.clear ();
        super.onDestroyView ();
    }

    private void saveListener() {
        buttonToSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(miniaturas.size() == 0) {
                    createAlertDialog(view, "Você ainda não tem jogadores escalados!", "Escale ao menos um para prosseguir.");
                    return;
                }

                Intent intent = new Intent(view.getContext (), LeituraDadosActivity.class);
                //intent.putExtra("originator", originator);
                view.getContext ().startActivity(intent);

                Toast.makeText(getContext (), "Salvo com sucesso!", Toast.LENGTH_SHORT).show ();
            }
        });
    }

    private void dragListener(View view) {
        CardView campo = view.findViewById(R.id.cardView);
        campo.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                controlActions(v, event, campo);
                return true;
            }
        });
    }

    private void controlActions(View view, DragEvent event, CardView campo) {
        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_ENTERED:
                campo.setBackgroundColor(GREEN);
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                campo.setBackgroundColor(RED);
                break;
            case DragEvent.ACTION_DRAG_ENDED:
                campo.setBackgroundColor(WHITE);
                break;
            case DragEvent.ACTION_DROP:
                final float dropX = event.getX();
                final float dropY = event.getY();
                final DragData state = (DragData) event.getLocalState();
                if(miniaturas.size () > 10) {
                    createAlertDialog(view,"Seu time já está completo!", "Clique e segure no ícone de um jogador para removelo!");
                    break;
                }
                criateShape(view, state, dropX, dropY, campo);
                break;
            default:
                break;
        }
    }

    private void criateShape(View view, DragData state, float dropX, float dropY, CardView campo) {
        final View shape = LayoutInflater.from(
                view.getContext()).inflate(R.layout.miniaturas_adapter, campo, false);
        if(validaShape(view, state, miniaturas)) {return;}

        shape.setBackgroundResource (state.item.getImage());
        shape.setX(dropX - (float) state.width / 2);
        shape.setY(dropY - (float) state.height / 2);
        shape.getLayoutParams().width = state.width;
        shape.getLayoutParams().height = state.height;
        shape.setId(state.item.getImage());             // o id do shape é o mesmo da sua imagem
        campo.addView(shape);

        miniaturas.add(shape);
        originator.setState(miniaturas);

        listenerToRemoveMiniatura(shape, state, campo);
    }

    private void listenerToRemoveMiniatura(View shape, DragData state, CardView campo) {
        shape.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                campo.removeView(shape);
                miniaturas.remove(shape);
                return true;
            }
        });
    }

    public void setGetSavedState(List<View> savedState) {
        for (View miniatura: savedState) { this.miniaturas.add(miniatura);}
    }
}