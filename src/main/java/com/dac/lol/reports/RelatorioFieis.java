package com.dac.lol.reports;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

@WebServlet(name = "RelatorioFieis", urlPatterns = {"/RelatorioFieis"})
public class RelatorioFieis extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

    } // Fechamento do processRequest

// Outros métodos escondidos
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = null;
        try {
// Conexão com o banco
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_lol",
                    "dac", "dac");

// Caminho contextualizado do relatório compilado
            String jasper = request.getContextPath()
                    + "/Fieis.jasper";
// Host onde o servlet esta executando
            String host = "http://" + request.getServerName()
                    + ":" + request.getServerPort();
// URL para acesso ao relatório
            URL jasperURL = new URL(host + jasper);
// Parâmetros do relatório
            HashMap params = new HashMap();
// Geração do relatório
            byte[] bytes = JasperRunManager.runReportToPdf(
                    jasperURL.openStream(), params, con);

            if (bytes != null) {
// A página será mostrada em PDF
                response.setContentType("application/pdf");
// Envia o PDF para o Cliente
                OutputStream ops = response.getOutputStream();
                ops.write(bytes);

            }
        } // Fechamento do try
        catch (ClassNotFoundException e) {
            request.setAttribute("mensagem", "Driver BD não encontrado : "
                    + e.getMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("mensagem", "Erro de conexão ou query: "
                    + e.getMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        } catch (JRException e) {
            request.setAttribute("mensagem", "Erro no Jasper : "
                    + e.getMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                }
            }

        }

    }
} // Fechamento da classe
