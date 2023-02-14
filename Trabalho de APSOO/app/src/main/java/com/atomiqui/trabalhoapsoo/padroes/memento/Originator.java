package com.atomiqui.trabalhoapsoo.padroes.memento;

import android.os.Parcelable;
import android.view.View;

import com.atomiqui.trabalhoapsoo.fragment.EscalarFragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Originator implements Serializable {
    private List<View> state;

    private static Originator instancia = new Originator ();

    private Originator () {}

    public static synchronized Originator obterInstancia () {
        return instancia;
    }

    public void setState(List<View> state) {
        this.state = state;
    }

    public Memento saveToMemento(String name, String message) {
        return new Memento(state, name, message);
    }

    public void restoreFromMemento(Memento memento) {
        state = memento.getSavedState();
    }

    public static class Memento {
        private final List<View> state = new ArrayList<> ();
        private final String name;
        private final String annotation;

        private Memento(List<View> stateToSave, String name, String annotation) {
            for (View item:stateToSave) {
                state.add (item);
            }
            this.name = name;
            this.annotation = annotation;
        }

        public List<View> getSavedState() {
            return state;
        }
        public String getName() {return name;}
        public String getAnnotation() {return annotation;}
    }
}
