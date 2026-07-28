/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
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
public class AddTextServlet extends HttpServlet {
    @EJB TextFacadeLocal tfl;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = request.getParameter("shrtMsg");
        
        Integer msgLength = tfl.shrtMessageLength(message);
        Integer totNumVowels = tfl.totalNumVowels(message);
        Integer totNumConsa = tfl.totalNumConsonants(message);
        
        String uniqueletters = tfl.nonRepeatingLetters(message);
        String nonUniqueletters = tfl.repeatingLetters(message);
        
        request.setAttribute("message", message);
        request.setAttribute("msgLength", msgLength);
        request.setAttribute("totNumVowels", totNumVowels);
        request.setAttribute("uniqueletters",uniqueletters );
        request.setAttribute("totNumConsa", totNumConsa);
        request.setAttribute("nonUniqueletters",nonUniqueletters );
        
        //Text text = createText(message, msgLength,totNumVowels, totNumConsa, uniqueletters, nonUniqueletters);
       // tfl.create(text);
        
        RequestDispatcher disp = request.getRequestDispatcher("text_analysis_outcome.jsp");
        disp.forward(request, response);
    }

//    private Text createText(String message, Integer msgLength, Integer totNumVowels, Integer totNumConsa, String uniqueletters, String nonUniqueletters) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
