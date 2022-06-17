package com.example.demoweb1706;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import javax.annotation.Resource;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    @Resource(name = "jdbc/chinook")
    DataSource ds;
    private ArtistDAO artistDAO;

    public void init() {
        try {
//            Context ctx = new InitialContext();
//            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/chinook");
            Connection connection = ds.getConnection();
            artistDAO = new ArtistDAO(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
//        } catch (NamingException e) {
//            throw new RuntimeException(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArtistBean artistBean = new ArtistBean();
        artistBean.setArtists(artistDAO.findAll());
        request.setAttribute("ab", artistBean);
        request.getRequestDispatcher("/artists.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String artistName = request.getParameter("artistName");
        ArtistBean artistBean = new ArtistBean();
        artistBean.setCurrent(new Artist(0, artistName));
        request.setAttribute("ab", artistBean);
        request.getRequestDispatcher("/artists.jsp").forward(request, response);

    }

    public void destroy() {
    }
}