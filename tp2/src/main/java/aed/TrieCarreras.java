package aed;

import java.util.ArrayList;

public class TrieCarreras {

    NodoCarrera raiz;

    public TrieCarreras() {
        raiz = new NodoCarrera();
    }

    public TrieMaterias insertarEnTrie(String word) {
        int n = word.length();

        NodoCarrera head = raiz;


        for (int i = 0; i < n; i++) {

            int index = word.charAt(i);//  - 'a'; <- esto se bugea, resolver despues

            if (head.hijo[index] == null) {
                head.hijo[index] = new NodoCarrera();
            }

            head = head.hijo[index];
            head.letra = String.valueOf(word.charAt(i));
        }

        head.esFinalPalabra = true;
        if (head.trieMaterias == null) {
            head.trieMaterias = new TrieMaterias();
        }
        return head.trieMaterias;
    }

    public NodoCarrera devolverHojaCarrera(String word) {

        int n = word.length();

        NodoCarrera head = raiz;
        for (int i = 0; i < n; i++) {
            int index = word.charAt(i);// - 'a'; <- esto se bugea, resolver despues

            if (head.hijo[index] == null) return null;
            head = head.hijo[index];
        }

        return head;
    }

    public String[] devolverTodasLasCarreras(NodoCarrera nodo, String prefijo, ArrayList<String> resultado){

        if (nodo == null) {
            return resultado.toArray(new String[0]);
        }

        if (nodo.esFinalPalabra) {
            resultado.add(prefijo.toString());
        }

        for (int i = 0; i < nodo.hijo.length; i++) {
            if (nodo.hijo[i] != null) {
                devolverTodasLasCarreras(nodo.hijo[i], prefijo + (char) (i), resultado);
            }
        }
        return resultado.toArray(new String[0]);
    }

}

