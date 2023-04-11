package com.example.exercicio1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/processa_vaga")
public class ProcessaVagaServelet extends HttpServlet {

    private DateTimeFormatter formatter;

    @Override
    public void init() throws ServletException {
      formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // i) obter essas informacoes do formulario;
        String name = request.getParameter("name");

        String data = request.getParameter("data_nasc");
        LocalDate dataNasc = LocalDate.parse(data,formatter);

        String idioma = request.getParameter("idioma");

        String[] habilities = request.getParameterValues("hability");

        // ii) adicionar informacoes a requisicao;
        request.setAttribute("attr_name", name);
        request.setAttribute("attr_data", dataNasc);
        request.setAttribute("attr_idioma", idioma);
        request.setAttribute("attr_habilities", habilities );

        //iii) encaminhar essas informacoes para quem melhor sabe o que fazer com elas;
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("sucess.jsp");
        requestDispatcher.forward(request,response);
    }
}
