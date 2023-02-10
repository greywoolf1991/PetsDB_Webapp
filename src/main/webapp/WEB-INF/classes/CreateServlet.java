import DATABASE.Pet;
import DATABASE.PetsDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            String type = req.getParameter("type");
            Pet pet = new Pet(type, name);
            PetsDB.insert(pet);
            resp.sendRedirect(req.getContextPath()+"/index");
        }
        catch (Exception ex) {
            getServletContext().getRequestDispatcher("/create.jsp").forward(req, resp);
        }
    }
}