package servlet;

import dao.UserDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao = new UserDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "register":
                    registerUser(request, response);
                    break;
                case "login":
                    loginUser(request, response);
                    break;
                case "logout":
                    logoutUser(request, response);
                    break;
                case "updateProfile":
                    updateProfile(request, response);
                    break;
                default:
                    response.sendRedirect("index.jsp");
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String introduce = request.getParameter("introduce");

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setGender(gender);
        newUser.setEmail(email);
        newUser.setTelephone(telephone);
        newUser.setIntroduce(introduce);
        newUser.setActiveCode("default");
        newUser.setState(1);
        newUser.setRole("commonUser");
        newUser.setRegistTime(new Date());

        userDao.saveUser(newUser);
        response.sendRedirect("login.jsp");
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userDao.findUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            request.getSession().setAttribute("currentUser", user);
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("errorMessage", "用户名或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private void logoutUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect("index.jsp");
    }

    private void updateProfile(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if (currentUser != null) {
            currentUser.setGender(request.getParameter("gender"));
            currentUser.setEmail(request.getParameter("email"));
            currentUser.setTelephone(request.getParameter("telephone"));
            currentUser.setIntroduce(request.getParameter("introduce"));

            userDao.updateUser(currentUser);
            response.sendRedirect("userProfile.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
