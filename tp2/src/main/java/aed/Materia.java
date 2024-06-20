package aed;

import java.util.ArrayList;

public class Materia {


    ArrayList<String[]> carrerasALasQuePertenece;
    ArrayList<NodoMateria> tailsDeSusCarreras;
    int[] cargosdocentes;
    int[] cupoPorCargo;
    int cupo;
    int inscriptos;

    ListaEnlazadEstudiante estudiantes;


    public Materia() {
        this.carrerasALasQuePertenece = new ArrayList<>();
        this.tailsDeSusCarreras = new ArrayList<>();//Para cuando sea necesario borrar la Materia
        this.cargosdocentes = new int[]{0,0,0,0};//AY2[3],AY1[2],JTP[1],PROF[0]
        this.cupoPorCargo = new int[]{250, 100, 20,30};
        this.cupo = 0;
        this.inscriptos = 0;
        this.estudiantes = new ListaEnlazadEstudiante();



    }


    public void agregarCargoDocente(String cargo) {
        switch (cargo) {
            case "AY2" -> cargosdocentes[3] += 1;
            case "AY1" -> cargosdocentes[2] += 1;
            case "JTP" -> cargosdocentes[1] += 1;
            case "PROF" -> cargosdocentes[0] += 1;
            default -> throw new UnsupportedOperationException("NO PUEDE PASAR ESTO");
        }
        actualizarCupo(); // O(4)
    }

    public void actualizarCupo(){
        int minimo = cargosdocentes[0] * cupoPorCargo[0];

        for (int i = 0; i < cargosdocentes.length; i++){
            if (minimo > cargosdocentes[i] * cupoPorCargo[i]){
                minimo = cargosdocentes[i] * cupoPorCargo[i];
            }
        }
        cupo = minimo;
    }

    public void desincribirEstudiantes(){
        NodoEstudiante actual = estudiantes.raiz;
        while (actual != null){
            actual.estudiante.materiasCursando -= 1;
            actual = actual.siguiente;
        }
    }

    public boolean esIgual(Materia comparacion){
        if(comparacion.carrerasALasQuePertenece.size() == carrerasALasQuePertenece.size()){
            for(int i = 0; i < carrerasALasQuePertenece.size(); i++){
                if(carrerasALasQuePertenece.get(i) != comparacion.carrerasALasQuePertenece.get(i)){
                    return false;
                }
            }
        }
        return true;
    }



}
