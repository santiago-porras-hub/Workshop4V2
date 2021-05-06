package edu.unbosque.Workshop4;

import com.google.gson.Gson;
import edu.unbosque.persistence.Archivo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet( name="update", value="/update")
public class TablaServlet extends HttpServlet {

    Archivo file = new Archivo();
    ArrayList<lista> info = new ArrayList<>();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        info = file.readFile();

        String authorsJsonString = new Gson().toJson(info);
        PrintWriter out = response.getWriter();
        out.print(authorsJsonString);
        out.flush();
    }
}
