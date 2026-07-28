<%-- 
    Document   : text_analysis_outcome
    Created on : Apr 26, 2026, 4:32:30 PM
    Author     : Innocent Mohoerane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>text_analysis_outcome Page</title>
    </head>
    <body>
        <h1>Text analysis outcome!</h1>
        <%
            String message = (String)request.getAttribute("message");

            Integer msgLength = (Integer)request.getAttribute("msgLength");
            Integer totNumVowels = (Integer)request.getAttribute("totNumVowels");
            Integer totNumConsa = (Integer)request.getAttribute("totNumConsa");

            String uniqueletters = (String)request.getAttribute("uniqueletters");
            String nonUniqueletters = (String)request.getAttribute("nonUniqueletters");
            
        %>
        
        <p>
            Below is the text message analysis:
        </p>
        
        <p>
            <b>Text Message</b>: <%=message%><br>
            <b>Message Length</b>: <%=msgLength%><br>
            <b>Total Number of Vowels</b>: <%=totNumVowels%><br>
            <b>Total Number of consonants</b>: <%=totNumConsa%><br>
            <b>Unique Letters</b>: <%=uniqueletters%><br>
            <b>Non Unique Letters</b>: <%=nonUniqueletters%><br>
        </p>
        
        <p>
            Click the button to add the analysis to the database:
        </p>
        <form action="AddAnalysisServlet.do" method="POST">
            <table>
                <tr>
                    <td><input type="hidden" name="message" value="<%=message%>"></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="msgLength" value="<%=msgLength%>"></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="totNumVowels" value="<%=totNumVowels%>"></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="totNumConsa" value="<%=totNumConsa%>"></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="uniqueletters" value="<%=uniqueletters%>"></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="nonUniqueletters" value="<%=nonUniqueletters%>"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="ADD ANALYSIS"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
