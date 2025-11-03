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

@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MovieDao movieDao = new MovieDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("detail".equals(action)) {
                showMovieDetail(request, response);
            } else if ("edit".equals(action)) {
                showEditForm(request, response);
            } else if ("delete".equals(action)) {
                deleteMovie(request, response);
            } else {
                listMovies(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showMovieDetail(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Movie movie = movieDao.findMovieById(id);
        request.setAttribute("movie", movie);
        request.getRequestDispatcher("MoviePage.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Movie existingMovie = movieDao.findMovieById(id);
        request.setAttribute("movie", existingMovie);
        request.getRequestDispatcher("MovieForm.jsp").forward(request, response);
    }

    private void deleteMovie(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        movieDao.deleteMovieById(id);
        response.sendRedirect("HomeServlet");
    }

    private void listMovies(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Movie> listMovies = movieDao.findAllMovies();
        request.setAttribute("listMovies", listMovies);
        request.getRequestDispatcher("MovieList.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
