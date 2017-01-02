/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.BaseDatosResultados;
import entidades.Personal;
import java.util.ArrayList;
import modelo.ModeloPersonal;


/**
 *
 * @author vek
 */
public class ControladorPersonal {
    private ControladorBaseDatos bd;
    private ModeloPersonal mpersonal;
    
    public ControladorPersonal() {
        this.bd = new ControladorBaseDatos();
        this.mpersonal = new ModeloPersonal();
    }

    public int guardarPersonal(Personal personal){
       this.bd.conectar();
        
       int resultado = this.mpersonal.insertPersonal(personal.getCod_p(),personal.getNombre(),personal.getApellido(),personal.getFecha_i(),personal.getTipo());

        if(resultado == BaseDatosResultados.EXITO_GUARDAR){
            return BaseDatosResultados.EXITO_GUARDAR;
        }else{
            return BaseDatosResultados.FALLO_GUARDAR;
        }
    }
    
    public ArrayList mostrarPersonal(){
        if(mpersonal.selectPersonal() != null){
            ArrayList infopersonal = new ArrayList();
            infopersonal = mpersonal.selectPersonal();
            return infopersonal;
        }
        else{
            return null;
        }
    }
    public int modificarPersonal(Personal personal){
        this.bd.conectar();
        
        int resultado = this.mpersonal.updatePersonal(personal.getCod_p(),personal.getNombre(),personal.getApellido(),personal.getFecha_i(),personal.getTipo());
        
        if(resultado == BaseDatosResultados.EXITO_GUARDAR){
            return BaseDatosResultados.EXITO_GUARDAR;
        }else{
            return BaseDatosResultados.FALLO_GUARDAR;
        }
    }
    
    public int eliminarPersonal(Personal personal){
        this.bd.conectar();
        int resultado = this.mpersonal.deletePersonal(personal.getCod_p());
        System.out.println("Controlador tiene el: "+personal.getCod_p());
        if(resultado == BaseDatosResultados.EXITO_GUARDAR){
            return BaseDatosResultados.EXITO_GUARDAR;
        }else{
            return BaseDatosResultados.FALLO_GUARDAR;
        }
    }
    
    
    
    
    
}
