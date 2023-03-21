package br.edu.ifpr.helloworo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
    @WebServlet("/requisicao")
    public class Requisicao extends HttpServlet {
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String method = request.getMethod();
            String uri = request.getRequestURI();
            String protocol = request.getProtocol();
            String remoteAdrr = request.getRemoteAddr();

            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1> Method: " + method + "</h1>");
            out.println("<h1> Uri: " + uri + "</h1>");
            out.println("<h1> Protocol: " + protocol + "</h1>");
            out.println("<h1> Remote-Adress: " + remoteAdrr + "</h1>");
            out.println("</body></html>");
        }

        public void destroy() {
        }
    }
