/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Endereco;

public class ManterEnderecoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        } else {
            if (acao.equals("confirmarIncluir")) {
                confirmarIncluir(request, response);
            } else {
                if (acao.equals("prepararExcluir")) {
                    prepararExcluir(request, response);
                } else {
                    if (acao.equals("confirmarExcluir")) {
                        confirmarExcluir(request, response);
                    } else {
                        if (acao.equals("prepararEditar")) {
                            prepararEditar(request, response);
                        } else {
                            if (acao.equals("confirmarEditar")) {
                                confirmarEditar(request, response);
                            }
                        }
                    }
                }
            }
        }
    }

    public void prepararIncluir(HttpServletRequest request, HttpServletResponse response) {
        try {
             String tipoLogin = request.getParameter("tipoLogin");
            request.setAttribute("tipoLogin", tipoLogin);
            
            request.setAttribute("operacao", "Incluir");
            //request.setAttribute("administradores", Endereco.obterEndereco());
            RequestDispatcher view = request.getRequestDispatcher("/manterEndereco.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
            //} catch (ClassNotFoundException ex) {
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {

        int codEndereco = Integer.parseInt(request.getParameter("txtCodEndereco"));
        String cep = request.getParameter("txtCepEndereco");
        String logradouro = request.getParameter("txtLogradouro");
        String cidade = request.getParameter("txtCidade");
        String uf = request.getParameter("txtUfEndereco");
        String numeroLogradouro = request.getParameter("txtNumeroLogradouro");
        String complementoLogradouro = request.getParameter("txtComplementoLogradouro");
        String bairro = request.getParameter("txtBairro");

         String tipoLogin = request.getParameter("tipoLogin");
            request.setAttribute("tipoLogin", tipoLogin);
        try {
            Endereco endereco = new Endereco(codEndereco, cep, logradouro, cidade, uf, numeroLogradouro, complementoLogradouro, bairro);
            endereco.gravar();

            RequestDispatcher view = request.getRequestDispatcher("PesquisaEnderecoController");
            view.forward(request, response);
        } catch (IOException ex) {
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (ServletException ex) {
        }
    }

    public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) {
        try {
             String tipoLogin = request.getParameter("tipoLogin");
            request.setAttribute("tipoLogin", tipoLogin);
            
            request.setAttribute("operacao", "Excluir");
            request.setAttribute("enderecos", Endereco.obterEnderecos());
            int codEndereco = Integer.parseInt(request.getParameter("codEndereco"));
            Endereco endereco = Endereco.obterEndereco(codEndereco);
            request.setAttribute("endereco", endereco);
            RequestDispatcher view = request.getRequestDispatcher("/manterEndereco.jsp");
            view.forward(request, response);

        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }

    }

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException {
        int codEndereco = Integer.parseInt(request.getParameter("txtCodEndereco"));
        String cep = request.getParameter("txtCepEndereco");
        String logradouro = request.getParameter("txtLogradouro");
        String cidade = request.getParameter("txtCidade");
        String uf = request.getParameter("txtUfEndereco");
        String numeroLogradouro = request.getParameter("txtNumeroLogradouro");
        String complementoLogradouro = request.getParameter("txtComplementoLogradouro");
        String bairro = request.getParameter("txtBairro");

         String tipoLogin = request.getParameter("tipoLogin");
            request.setAttribute("tipoLogin", tipoLogin);
        try {

            Endereco endereco = new Endereco(codEndereco, cep, logradouro, cidade, uf, numeroLogradouro, complementoLogradouro, bairro);
            endereco.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaEnderecoController");
            view.forward(request, response);
        } catch (IOException ex) {
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (ServletException ex) {
        }
    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) {
        try {
             String tipoLogin = request.getParameter("tipoLogin");
            request.setAttribute("tipoLogin", tipoLogin);
            
            request.setAttribute("operacao", "Editar");
            request.setAttribute("enderecos", Endereco.obterEnderecos());
            int codEndereco = Integer.parseInt(request.getParameter("codEndereco"));
            Endereco endereco = Endereco.obterEndereco(codEndereco);
            request.setAttribute("endereco", endereco);
            RequestDispatcher view = request.getRequestDispatcher("/manterEndereco.jsp");
            view.forward(request, response);

        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }

    }

    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException {
        int codEndereco = Integer.parseInt(request.getParameter("txtCodEndereco"));
        String cep = request.getParameter("txtCepEndereco");
        String logradouro = request.getParameter("txtLogradouro");
        String cidade = request.getParameter("txtCidade");
        String uf = request.getParameter("txtUfEndereco");
        String numeroLogradouro = request.getParameter("txtNumeroLogradouro");
        String complementoLogradouro = request.getParameter("txtComplementoLogradouro");
        String bairro = request.getParameter("txtBairro");

         String tipoLogin = request.getParameter("tipoLogin");
            request.setAttribute("tipoLogin", tipoLogin);
            
        try {
            Endereco endereco = new Endereco(codEndereco, cep, logradouro, cidade, uf, numeroLogradouro, complementoLogradouro, bairro);
            endereco.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaEnderecoController");
            view.forward(request, response);
        } catch (IOException ex) {
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (ServletException ex) {
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterEnderecoController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterEnderecoController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
