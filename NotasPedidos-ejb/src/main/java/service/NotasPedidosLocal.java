/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.mycompany.NotasPedido;
import java.util.Date;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author alumno
 */
@Local
public interface NotasPedidosLocal {

    ArrayList ListadoNotas();

    boolean addNota(NotasPedido nota);

    boolean modNota(NotasPedido nota);

    NotasPedido encontrarPorFecha(Date fecha);

    boolean eliminarNota(NotasPedido nota);

    NotasPedido encontrarPorId(NotasPedido nota);

    
    
}
