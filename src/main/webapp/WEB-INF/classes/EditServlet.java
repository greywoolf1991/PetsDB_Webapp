import DATABASE.Pet;
import DATABASE.PetsDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Pet pet = PetsDB.selectOne(id);
            if (pet!=null) {
                req.setAttribute("pet", pet);
                getServletContext().getRequestDispatcher("/edit.jsp").forward(req, resp);
            }
            else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(req, resp);
            }
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String type = req.getParameter("type");
            Pet pet = new Pet(id, type, name);
            PetsDB.update(pet);
            resp.sendRedirect(req.getContextPath()+"/index");
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(req, resp);
        }
    }
}