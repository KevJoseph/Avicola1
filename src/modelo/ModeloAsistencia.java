/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ControladorBaseDatos;
import entidades.Asistencia;
import entidades.Personal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author vek
 */
public class ModeloAsistencia implements DatabaseModelOperations{
    ControladorBaseDatos bd;

    public ModeloAsistencia() {
        this.bd = new ControladorBaseDatos();
    }

    @Override
    public int insert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList select() {
        ArrayList lista = new ArrayList();
        try {
        this.bd.conectar();
        String sql = "Select * from asistencias";
        Statement st = this.bd.objconexion().createStatement();
        ResultSet rs = st.executeQuery(sql);
              
            while(rs.next()){
                String id= rs.getString("id");
                String idpersonal = rs.getString("idpersonal");
                String codpersonal = rs.getString("codpersonal");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String idgalpon = rs.getString("idgalpon");
                String estado = rs.getString("estado");
                String hora_extra = rs.getString("hora_extra");
                String fecha = rs.getString("fecha");
                Asistencia tempasis = new Asistencia(id,codpersonal,nombre,apellido,idgalpon,estado,hora_extra,fecha);
                lista.add(tempasis);
                
            }
            this.bd.desconectar();
            System.out.println("[+]ModelAsistencia Select... OK");
            return lista;
          
        } catch (Exception e) {
            System.out.println("[-] Error en ModeloAsisencia,method:select");
            return null;
        }
   
    }

    @Override
    public int update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int proc_asis(){
        try {
            this.bd.conectar();
            String sql = "call proc_asis()";
            CallableStatement cs = this.bd.objconexion().prepareCall(sql);
            cs.execute();
            System.out.println("Procedure Store Model... OK");
            this.bd.desconectar();
            return 1;
        } catch (Exception e) {
            System.out.println("ProcedureStore Model... Error");
            return 0;
        }
    }
}
