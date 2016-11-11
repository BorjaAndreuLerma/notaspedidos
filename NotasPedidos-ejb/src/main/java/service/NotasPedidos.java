/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.mycompany.NotasPedido;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author alumno
 */
@Stateless
public class NotasPedidos implements NotasPedidosLocal {

    private static ArrayList<NotasPedido> listaNotas = new ArrayList<>();
    private static int lastId = 6;
    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:ii");
    String fecha="2016-10-1 20:45";
    Date fecha2= (Date) formatoFecha.parse(fecha);
    static{
        listaNotas.add(new NotasPedido(1,20, formatoFecha.parse(fecha)));
        listaNotas.add(new NotasPedido(2,21));
        listaNotas.add(new NotasPedido(3,32));
        listaNotas.add(new NotasPedido(4,20));
        listaNotas.add(new NotasPedido(5,12));
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
