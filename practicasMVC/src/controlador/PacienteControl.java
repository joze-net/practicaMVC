
package controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class PacienteControl implements ActionListener {
    vista.RegpacienteInternalFrame pacienteVista;
    Modelo.Paciente pacienteModelo;
    Modelo.GestorPaciente gestorpacienteModelo;

    public PacienteControl(vista.RegpacienteInternalFrame pacienteVista){
        this.pacienteVista=pacienteVista;
        gestorpacienteModelo=new Modelo.GestorPaciente();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(pacienteVista.jButton1)){
            String identificacion=pacienteVista.txtIdentificacion.getText();
            String nombres=pacienteVista.txtNombres.getText();
            String apellidos=pacienteVista.txtApellidos.getText();
            SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
            String fecha_nacimiento=formato.format(pacienteVista.dtdFechaNacimiento.getDate());
            String genero="";
                
            if(pacienteVista.rdbMasculino.isSelected()){
                genero="M";
            }
            if(pacienteVista.rdbFemenino.isSelected()){
                genero="F";
            }
            pacienteModelo=new Modelo.Paciente(identificacion,nombres,apellidos,fecha_nacimiento,genero);
            gestorpacienteModelo.RegistrarPacientes(pacienteModelo);
        }
        if(e.getSource().equals(pacienteVista.jButton2)){
            pacienteVista.txtIdentificacion.setText("");
            pacienteVista.txtNombres.setText("");
            pacienteVista.txtApellidos.setText("");
            pacienteVista.dtdFechaNacimiento.setDate(null);
            pacienteVista.rdbMasculino.setSelected(true);
            pacienteVista.rdbFemenino.setSelected(false);
            pacienteVista.txtIdentificacion.requestFocus();
        }
    }
}
/*El objetivo de esta clase es comunicarse con la vista para capturar los datos ingresados
por el usuario en el formulario de registro de clientes y posteriormente con esos datos
capturados comunicarse con el modelo para crear un objeto de la clase paciente y
registrarlo a través de la clase GestorPaciente del modelo.*/