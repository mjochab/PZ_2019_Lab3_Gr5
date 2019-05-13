package sample;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Generate_PDF_Wypozyczenia {


    public static void main(String [] args){

        try{

            String file_name="C:\\Users\\Tommy\\IdeaProjects\\Projekt\\Raport_wypozyczen.pdf";
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(file_name));
            document.open();

           // DBConnection obJDBConnection = new DBConnection();
           // Connection connection = obJDBConnection.getConnection();

            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");


            PreparedStatement ps = null;
            ResultSet rs = null;

            String query="SELECT * FROM wypozyczenie";
            ps=connection.prepareStatement(query);
            rs=ps.executeQuery();

            while(rs.next()){
                Paragraph para = new Paragraph(rs.getString("wypozyczenie_id")+ " "+rs.getString("klient_id")+ " "+rs.getString("pracownik_id")+ " "+rs.getString("samochod_id")+ " "+rs.getString("data_od")+ " "+rs.getString("data_do"));
                document.add(para);
                document.add(new Paragraph(" "));
            }

            document.close();

        }
        catch (Exception e){
            System.err.println(e);
        }
    }

}
