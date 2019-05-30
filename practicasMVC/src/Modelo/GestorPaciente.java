
package Modelo;

import java.util.*;


public class GestorPaciente {
    private static LinkedList<Paciente> pacientes;
    
    public GestorPaciente(){
        pacientes=new LinkedList<>();
    }
    public void RegistrarPacientes(Paciente paciente){
        pacientes.add(paciente);
    }
    public static LinkedList<Paciente> getPacientebyParametro(int parametro, String valor)
    {
    LinkedList<Paciente> resultado=new LinkedList<>();
    for(Paciente pac:pacientes)
    {
            switch(parametro){
                case 1: if(pac.getIdentificacion().equals(valor))
                resultado.add(pac);
                break;
                case 2: if(pac.getNombres().equals(valor))
                resultado.add(pac);
                break;
                case 3: if(pac.getApellidos().equals(valor))
                resultado.add(pac);
                break;
                case 4: if(pac.getGenero().equals(valor))
                resultado.add(pac);
                break;
            }
    }
    return resultado;
    }
}


