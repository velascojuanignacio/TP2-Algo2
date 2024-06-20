package aed;

import java.util.ArrayList;

public class TrieMaterias {

    NodoMateria raiz;
    int cantidadDeMaterias;

    public TrieMaterias() {
        raiz = new NodoMateria();
        cantidadDeMaterias = 0;
    }

    public NodoMateria insertarEnTrie(String word) {
        int n = word.length();

        NodoMateria actual = raiz;

        for (int i = 0; i < n; i++) {

            int index = word.charAt(i);// - 'a'; <- esto se bugea, resolver despues

            if (actual.hijo[index] == null) {
                actual.hijo[index] = new NodoMateria();
            }

            actual.hijo[index].padre = actual;
            actual = actual.hijo[index];
            actual.letra = String.valueOf(word.charAt(i));
        }

        actual.esFinalPalabra = true;
        return actual;
    }

    public NodoMateria devolverHojaMateria(String word) {

        int n = word.length();

        NodoMateria head = raiz;
        for (int i = 0; i < n; i++) {
            int index = word.charAt(i);// - 'a'; <- esto se bugea, resolver despues

            if (head.hijo[index] == null) return null;
            head = head.hijo[index];
        }

        return head;
    }

    public void borrarMateria(NodoMateria tailMateria) {
        /*
        Ejemplo: Para la materia ALGO1, actual.letra es "O" y hijo.letra es "1"
         */
        String palabraEliminada = "";
        NodoMateria actual = tailMateria.padre;
        NodoMateria hijo = tailMateria;
        if(hijo.hijo == null) {
            while (actual.padre != null & actual.esFinalPalabra) {
                palabraEliminada = hijo.letra + palabraEliminada;
                hijo = actual;
                actual = actual.padre;
            }
            actual.hijo[hijo.letra.charAt(0)] = null; //Ej llegas a actual = raiz e hijo.letra = "A"
            // y pones que actual.hijo[indice] = null en lugar de hijo.
        }

    }

    public String[] devolverTodasLasMaterias(NodoMateria nodo, String prefijo, ArrayList<String> resultado){

        if (nodo == null) {
            return resultado.toArray(new String[0]);
        }

        if (nodo.esFinalPalabra) {
            resultado.add(prefijo.toString());
        }

        for (int i = 0; i < nodo.hijo.length; i++) {
            if (nodo.hijo[i] != null) {
                devolverTodasLasMaterias(nodo.hijo[i], prefijo + (char) (i), resultado);
            }
        }
        return resultado.toArray(new String[0]);
    }

}
