<%-- 
    Document   : longest_text_analysis_outcome
    Created on : Apr 26, 2026, 6:01:34 PM
    Author     : Innocent Mohoerane
--%>

<%@page import="za.ac.tut.model.entity.Text"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Longest text analysis outcome Page</title>
    </head>
    <body>
        <h1>Longest text analysis outcome!</h1>
        <%
            Text text = (Text)request.getAttribute("text");
            Long id = text.getId();
            String message = text.getShrtMessage();

            Integer msgLength = text.getShrtLength();
            Integer totNumVowels = text.getTotNumVowels();
            Integer totNumConsa = text.getTotNumConsonants();

            String uniqueletters = text.getUniqueLetters().get(0);
            String nonUniqueletters = text.getNonUniqueLetters().get(0);
            
        %>
        
        <p>
            Below is the longest text message analysis:
        </p>
        
        <p>
            <b>Text Message</b>: <%=message%><br>
            <b>Message Length</b>: <%=msgLength%><br>
            <b>Total Number of Vowels</b>: <%=totNumVowels%><br>
            <b>Total Number of consonants</b>: <%=totNumConsa%><br>
            <b>Unique Letters</b>: <%=uniqueletters%><br>
            <b>Non Unique Letters</b>: <%=nonUniqueletters%><br>
        </p>
        
        
        
        
        <ol>
            <li><a href="menu.html">Menu Page</a></li>
            <li><a href="index.html">Home Page</a></li>
        </ol>
    </body>
</html>
