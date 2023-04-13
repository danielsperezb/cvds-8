package edu.eci.cvds.servlet;

import edu.eci.cvds.servlet.Todo;
import edu.eci.cvds.servlet.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.ws.rs.NotFoundException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Optional;

//********** Para indicar en qué URL el servlet interceptará las peticiones GET, agregue al método la anotación**********
@WebServlet(
        urlPatterns = "/SampleServlet2" // Url que quiere que sea del servidor
)
public class SampleServlet2  extends HttpServlet {
    static final long serialVersionUID = 35L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = resp.getWriter();
        String message = "";
        try{
            Optional<String> optId = Optional.ofNullable(req.getParameter("id") );
            Todo todo = Service.getTodo( Integer.parseInt(optId.get()) );
            resp.setStatus(HttpServletResponse.SC_OK);

            ArrayList<Todo> todoList = new ArrayList<>();
            todoList.add(todo);
            message =Service.todosToHTMLTable(todoList);
        }
        catch( MalformedURLException malformedURLException){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            message = Service.getHTMLError(resp.getStatus(),"error interno en el servidor");
        }
        catch( NumberFormatException numberFormatException){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            message = Service.getHTMLError(resp.getStatus(),"requerimiento inválido");
        }
        catch ( FileNotFoundException fileNotFoundException){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            message = Service.getHTMLError(resp.getStatus(),"no existe un item con el identificador dado.");
        }
        catch(Exception exception){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            message = Service.getHTMLError(resp.getStatus(),"requerimiento inválido");
        }
        finally {
            responseWriter.write(message);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = resp.getWriter();
        String message = "";
        try{
            Optional<String> optId = Optional.ofNullable(req.getParameter("id") );
            Todo todo = Service.getTodo( Integer.parseInt(optId.get()) );
            resp.setStatus(HttpServletResponse.SC_OK);

            ArrayList<Todo> todoList = new ArrayList<>();
            todoList.add(todo);
            message =Service.todosToHTMLTable(todoList);
        }
        catch( MalformedURLException malformedURLException){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            message = Service.getHTMLError(resp.getStatus(),"error interno en el servidor");
        }
        catch( NumberFormatException numberFormatException){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            message = Service.getHTMLError(resp.getStatus(),"requerimiento inválido");
        }
        catch ( FileNotFoundException fileNotFoundException){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            message = Service.getHTMLError(resp.getStatus(),"no existe un item con el identificador dado.");
        }
        catch(Exception exception){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            message = Service.getHTMLError(resp.getStatus(),"requerimiento inválido");
        }
        finally {
            responseWriter.write(message);
        }
    }
}