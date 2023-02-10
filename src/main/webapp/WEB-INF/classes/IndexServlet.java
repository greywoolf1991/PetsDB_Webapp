import DATABASE.Pet;
import DATABASE.PetsDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Pet> pets = PetsDB.select();
        req.setAttribute("pets", pets);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}