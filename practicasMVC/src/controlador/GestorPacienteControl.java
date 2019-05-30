/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.*;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

public class GestorPacienteControl implements ActionListener {

Modelo.GestorPaciente pacientesModelo;
vista.ConsPacientesInternalFrame consultarPacienteVista;

public GestorPacienteControl(vista.ConsPacientesInternalFrame consultarPacienteVista)
    {
        this.consultarPacienteVista=consultarPacienteVista;
        pacientesModelo=new Modelo.GestorPaciente();
    }

@Override
public void actionPerformed(ActionEvent e){

DefaultTableModel tmodelo;
String valor=consultarPacienteVista.txtValor.getText();
int parametro=0;

if(consultarPacienteVista.rdbIdentifiacion.isSelected()){
    parametro=1;
}
if(consultarPacienteVista.rdbNombres.isSelected()){
    parametro=2;
}
if(consultarPacienteVista.rdbApellidos.isSelected()){
    parametro=3;
}
if(consultarPacienteVista.rdbGenero.isSelected()){
    parametro=4;
}
LinkedList<Modelo.Paciente>
pacientes=pacientesModelo.getPacientebyParametro(parametro, valor);
String registro[]=new String[5];
String []Titulos = {"Identificacion","Nombre","Apellidos","Fecha Nacimiento","Genero"};
tmodelo=new DefaultTableModel();
tmodelo.setColumnIdentifiers(Titulos);

for(Modelo.Paciente p:pacientes){
    registro[0]=p.getIdentificacion();
    registro[1]=p.getNombres();
    registro[2]=p.getApellidos();
    registro[3]=p.getFechaNacimiento();
    registro[4]=p.getGenero();
    tmodelo.addRow(registro);
}
consultarPacienteVista.tblDatos.setModel(tmodelo);
}
}
/*El paquete controlador finalmente queda conformado por dos clases paciente control que
recoge la información queda conformado por dos clases paciente control que recoge
la información de cada paciente ingresado por el usuario en la vista y lo registra en
el modelo y la clase GestorPaciente control que se encarga de recibir de la vista y lo
registra en el modelo y la clase GestorPacienteControl que se encarga de recibir de la
vista los parámetros de búsqueda, consultar en el modelo los pacientes que cumplen con
esos parámetros y regresar a la vista los resultados obtenidos,*/
