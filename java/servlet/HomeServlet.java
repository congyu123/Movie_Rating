package servlet;

import dao.MovieDao;
import entity.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MovieDao movieDao = new MovieDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Movie> popularMovies = movieDao.findMoviesByCategoryWithLimit("热门");
            List<Movie> newMovies = movieDao.findMoviesByCategoryWithLimit("新增");

            request.setAttribute("popularMovies", popularMovies);
            request.setAttribute("newMovies", newMovies);

            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
