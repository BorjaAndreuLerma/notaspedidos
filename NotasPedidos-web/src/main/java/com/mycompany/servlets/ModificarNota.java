/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlets;

import com.mycompany.NotasPedido;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.NotasPedidosLocal;

/**
 *
 * @author alumno
 */
public class ModificarNota extends HttpServlet {

    @EJB
    private NotasPedidosLocal notasPedidos;
    
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");

        if (accion != null && accion.equals("editar")) {
            
            //1. Recuperamos el id de la persona seleccionada
            String ids = request.getParameter("id");
            if (ids != null) {
                //2. Creamos el objeto persona a recuperar
                int id = Integer.valueOf(ids);
                NotasPedido nota= new NotasPedido();
                nota.setId(id);
                try{              
                    nota = this.notasPedidos.encontrarPorId(nota);
                }catch(Exception e){
                    e.printStackTrace();
                }

                
                request.setAttribute("nota", nota);
                request.getRequestDispatcher("/modificarNota.jsp").forward(request, response);
            }
        }else if  (accion != null && accion.equals("modificar")) {      

            try {      
                
                int id = Integer.parseInt(request.getParameter("id"));
                int numMesa = Integer.parseInt(request.getParameter("numMesa"));
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                String[] fechaBorr =  request.getParameterValues("fecha");
                Date fecha = formatoFecha.parse(fechaBorr[0]);
                String hora = request.getParameter("hora");
                double cuenta = Double.parseDouble(request.getParameter("cuenta"));
                
                NotasPedido nota = new NotasPedido();
                int idFin = Integer.valueOf(id);
                nota.setId(idFin);
                nota.setNum_mesa(numMesa);
                nota.setFecha(fecha);
                nota.setHora(hora);
                nota.setCuenta(cuenta);
                
                try {
                    this.notasPedidos.modNota(nota);
                } catch (Exception e) {
                    //Informamos cualquier error
                    e.printStackTrace();
                }
                
                // Volvemos a cargar la lista de personas
                ArrayList<NotasPedido> lista = notasPedidos.ListadoNotas();
                request.setAttribute("notas", lista);
                
                request.getRequestDispatcher("/listaNotas.jsp").forward(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(ModificarNota.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
