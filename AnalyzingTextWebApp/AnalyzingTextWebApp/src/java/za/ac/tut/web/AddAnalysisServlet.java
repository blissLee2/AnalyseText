/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.model.bl.TextFacadeLocal;
import za.ac.tut.model.entity.Text;

/**
 *
 * @author Innocent Mohoerane
 */
public class AddAnalysisServlet extends HttpServlet {
    @EJB TextFacadeLocal tfl;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = (String)request.getParameter("message");

            Integer msgLength = Integer.parseInt(request.getParameter("msgLength"));
            Integer totNumVowels = Integer.parseInt(request.getParameter("totNumVowels"));
            Integer totNumConsa = Integer.parseInt(request.getParameter("totNumConsa"));

            String uniqueletters = (String)request.getParameter("uniqueletters");
            String nonUniqueletters = (String)request.getParameter("nonUniqueletters");
        
        Text text = createText(message, msgLength,totNumVowels, totNumConsa, uniqueletters, nonUniqueletters);
        tfl.create(text);
        
        RequestDispatcher disp = request.getRequestDispatcher("add_analysis_outcome.jsp");
        disp.forward(request, response);
    }
        private Text createText(String message, Integer msgLength, Integer totNumVowels, Integer totNumConsa, String uniqueletters, String nonUniqueletters) {
            Text text = new Text();
            List<String> listUni = new ArrayList<>();
            List<String> listNonUni = new ArrayList<>();
            
            listUni.add(uniqueletters);
            listNonUni.add(nonUniqueletters);
            
            text.setShrtMessage(message);
            text.setShrtLength(msgLength);
            text.setTotNumVowels(totNumVowels);
            text.setTotNumConsonants(totNumConsa);
            text.setUniqueLetters(listUni);
            text.setNonUniqueLetters(listNonUni);
            text.setCreationDate(new Date());
            
            return text;
       
        }

}
