package edu.unbosque.Workshop4;

import edu.unbosque.persistence.Archivo;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet( name="charge", value="/charge")
public class UploadServlet extends HttpServlet {


    Archivo file = new Archivo();
    ArrayList <lista> list2 = new ArrayList<>();

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return "Default.file";
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        Cookie [] cookie= request.getCookies();
        PrintWriter out = response.getWriter();
        String cook="";
        for (int i=0 ; i<cookie.length; i++){
            if (cookie[i].getValue() != "") {
                cook = cookie[i].getValue();
            }
        }

        Part foto= request.getPart("file");

        String name = request.getParameter("userName");

        String comentarios = request.getParameter("comentarios");
        String pattern = "MM-dd-yyyy";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());


        lista info = new lista();
        info.setName(cook);
        info.setComentario(comentarios);
        info.setDate(date);

        //
        char[] chars = "abcdefghijklmnopqrstuvwxyz123456789".toCharArray();
        StringBuilder sb = new StringBuilder(10);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        info.setImagename(output);
        list2.add(info);
        file.writeFile(list2);

        String cargarCamino = getServletContext().getRealPath("") + File.separator + "imagen";
        File uploadDir = new File(cargarCamino);

        if (!uploadDir.exists())
            uploadDir.mkdir();

        try {
            String fileName = "";

                fileName = getFileName(foto);
                foto.write(cargarCamino + File.separator + fileName);
                System.out.println();


            request.setAttribute("message", "File " + fileName + " has uploaded successfully!");
        } catch (FileNotFoundException fne) {
            request.setAttribute("message", "There was an error: " + fne.getMessage());
        }

            response.sendRedirect("./table.jsp");
            out.close();

    }
}



