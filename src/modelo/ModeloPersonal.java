/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ControladorBaseDatos;
import entidades.BaseDatosResultados;
import entidades.Personal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

/**
 *
 * @author vek
 */
public class ModeloPersonal {
    private ControladorBaseDatos cbd;
    Connection con = null;

    ConfiBaseDatos confibasedatos = new ConfiBaseDatos("root", "pass","bd_avicola");
   
    public ModeloPersonal() {
        this.cbd = new ControladorBaseDatos();
    }
    
    public int insertPersonal(String codigo,String nombre,String apellido,String fecha,String tipo){
           
        try {
            this.cbd.conectar();
        
            String sql = "INSERT INTO personal(codpersonal,nombre,apellido,fecha,tipo) values(?,?,?,?,?)";
            PreparedStatement st = cbd.objconexion().prepareStatement(sql);
            st.setString (1, codigo);
            st.setString (2, nombre);
            st.setString (3, apellido);
            st.setString (4, fecha);
            st.setString (5, tipo);
            
            st.execute();
            this.cbd.desconectar();
            
            return BaseDatosResultados.EXITO_GUARDAR;
        } catch (Exception e) {
            return BaseDatosResultados.FALLO_GUARDAR;
        }
    }
    
    public ArrayList selectPersonal(){
        ArrayList lista = new ArrayList();
        try {
            this.cbd.conectar();
            String sql = "select * from personal";
            String datos[] = new String[5];
            Statement st = cbd.objconexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            System.out.println(rs.getFetchSize());
            while(rs.next()){
                String codigo_p = rs.getString("codpersonal");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String fecha = rs.getString("fecha");
                String tipo = rs.getString("tipo");
                Personal tempersonal = new Personal(codigo_p,nombre,apellido,fecha,tipo);
                lista.add(tempersonal);
            }
            return lista;
            
        } catch (SQLException e) {
            System.out.println("ModeloPersonal Error: "+e);
            return null;
        }

    }
    public static void main(String[] args) {
        ModeloPersonal m = new ModeloPersonal();
        m.selectPersonal();
    }
    

}
