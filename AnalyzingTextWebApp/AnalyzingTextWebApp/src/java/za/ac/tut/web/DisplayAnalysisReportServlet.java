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
public class DisplayAnalysisReportServlet extends HttpServlet {
    @EJB TextFacadeLocal tfl;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Text text = tfl.displayTheLongenstMessage();
        
        request.setAttribute("text", text);
        
        RequestDispatcher disp = request.getRequestDispatcher("longest_text_analysis_outcome.jsp");
        disp.forward(request, response);
    }


}
