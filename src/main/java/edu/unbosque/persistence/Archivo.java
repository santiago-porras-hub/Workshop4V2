package edu.unbosque.persistence;

import edu.unbosque.Workshop4.lista;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo {


    public Archivo(){

    }
    private static String FILE = "C:\\Users\\santi\\Workshop4V2\\target\\info.csv";

    public ArrayList<lista> readFile() {
        ArrayList<lista> list = new ArrayList<lista>();
        BufferedReader bufferLectura = null;
        try {
            bufferLectura = new BufferedReader(new FileReader(FILE));

            String line = bufferLectura.readLine();

            while (line != null) {
                lista info = new lista();
                String[] row = line.split(",");
                if (row.length == 4) {
                    try {
                        info.setName(row[0]);
                        info.setComentario(row[1]);
                        info.setDate(row[2]);
                        info.setImagename(row[3]);
                        list.add(info);

                    } catch (NumberFormatException e) {

                    }
                }
                line = bufferLectura.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferLectura != null) {
                try {
                    bufferLectura.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }

    public void writeFile(ArrayList<lista> list) throws IOException{

        FileWriter csvWriter = new FileWriter("C:\\Users\\santi\\Workshop4V2\\target\\info.csv");

        for (lista info : list) {

            csvWriter.append("\n");
            csvWriter.append(info.getName());
            csvWriter.append(",");
            csvWriter.append(info.getComentario());
            csvWriter.append(",");
            csvWriter.append(info.getDate());
            csvWriter.append(",");
            csvWriter.append(info.getImagename());
        }
        csvWriter.flush();
        csvWriter.close();
    }
}
