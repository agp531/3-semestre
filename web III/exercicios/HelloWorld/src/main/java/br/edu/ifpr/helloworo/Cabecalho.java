package br.edu.ifpr.helloworo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cabecalhos")
public class Cabecalho extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String host = request.getHeader("host");
        String user = request.getHeader("user-agent");
        String language = request.getHeader("accept-language");
        String encoding = request.getHeader("accept-encoding");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> HOST: " + host + "</h1>");
        out.println("<h1> USER AGENT: " + user + "</h1>");
        out.println("<h1> LANGUAGE: " + language + "</h1>");
        out.println("<h1> ENCODING: " + encoding + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
