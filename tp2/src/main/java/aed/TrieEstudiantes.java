package aed;
import java.util.ArrayList;

public class TrieEstudiantes {

    NodoEstudianteTrie raiz;

    public TrieEstudiantes() {
        raiz = new NodoEstudianteTrie();
    }

    public NodoEstudianteTrie insertarEstudiante(String LU) {
        int n = LU.length();

        NodoEstudianteTrie actual = raiz;

        for (int i = 0; i < n; i++) {
            int indice = LU.charAt(i) - '/';

            if (actual.hijo[indice] == null) {
                actual.hijo[indice] = new NodoEstudianteTrie();
            }
            actual.hijo[indice].padre = actual;
            actual = actual.hijo[indice];
            actual.letra = String.valueOf(LU.charAt(i));
        }
        actual.estudiante = new Estudiante(LU);
        actual.esFinalPalabra = true;
        actual.estudiante.materiasCursando = 0;
        return actual;
    }

    public NodoEstudianteTrie buscarEstudiante(String LU) {
        NodoEstudianteTrie actual = raiz;
        for (int i = 0; i < LU.length(); i++) {
            int indice = LU.charAt(i) - '/';
            if (actual.hijo[indice] == null) {
                return null;
            }
            actual = actual.hijo[indice];
        }
        return actual;
    }
}
