/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ma.projet.entities.Commande;
import ma.projet.entities.LigneCommandeProduit;
import ma.projet.entities.LigneCommandeProduitPK;
import ma.projet.services.CommandeService;
import ma.projet.services.LigneCommandeProduitService;

/**
 *
 * @author Lachgar
 */
@WebServlet(name = "CommandeController", urlPatterns = {"/CommandeController"})
public class CommandeController extends HttpServlet {

    private CommandeService cs;
    private LigneCommandeProduitService ps;
    

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        cs = new CommandeService();
        ps = new LigneCommandeProduitService();
       

    }

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
           
        if (request.getParameter("op") != null) {
             String op = request.getParameter("op");
            if (op.equals("delete")) {

                ps.delete(ps.getById(Integer.parseInt(request.getParameter("id"))));
            }
                if (op.equals("update")) {
                  Integer produitIdStr = Integer.parseInt(request.getParameter("selectedProduit"));
                  String dateStr = request.getParameter("date");
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate localDate = LocalDate.parse(dateStr, dateFormatter);
                    Date date = java.sql.Date.valueOf(localDate);
                    
                    LigneCommandeProduit commandeProduit =ps.getById(Integer.parseInt(request.getParameter("id")));
                    LigneCommandeProduitPK lpk=commandeProduit.getId();
                    Commande cmd=cs.getById(lpk.getCommande());
                    cmd.setDate(date);
                    cs.update(cmd);
                    lpk.setProduit(produitIdStr);
                   Integer quan = Integer.parseInt(request.getParameter("quantite"));
                   Double total = Double.parseDouble(request.getParameter("total"));
                   commandeProduit.setId(lpk);
                   commandeProduit.setQuantite(quan);
                   commandeProduit.setTolat(total);
                   
                   
                   ps.update(commandeProduit);
                   
                   

                }

            } else {

                String dateStr = request.getParameter("date");
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate localDate = LocalDate.parse(dateStr, dateFormatter);
                Date date = java.sql.Date.valueOf(localDate);
                Commande c = new Commande(date);
                cs.create(c);

                Integer produitIdStr = Integer.parseInt(request.getParameter("selectedProduit"));

                Integer quan = Integer.parseInt(request.getParameter("quantite"));
                Double total = Double.parseDouble(request.getParameter("total"));
                LigneCommandeProduitPK lpk = new LigneCommandeProduitPK(produitIdStr, c.getId());
                LigneCommandeProduit commandeProduit = new LigneCommandeProduit(lpk, quan, total);
                ps.create(commandeProduit);

            }
            response.sendRedirect("Commande.jsp");

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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
