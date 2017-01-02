/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author vek
 */
public class Galpon {
    private String id;
    private String numero_g;

    public Galpon() {
    }

    public Galpon(String id, String numero_g) {
        this.id = id;
        this.numero_g = numero_g;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumero_g() {
        return numero_g;
    }

    public void setNumero_g(String numero_g) {
        this.numero_g = numero_g;
    }
    
    
}
