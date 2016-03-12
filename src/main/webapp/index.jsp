<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Language Translation and Text-to-Speech</title>
		
    </head>
    <body>
        <div align="center">
            <form action ="LanguageTranslationServlet" method="post">
                <input type="text" name="inputText">
                <input type="SUBMIT" value="Convert" />
            </form>
        </div>
    </body>
</html>