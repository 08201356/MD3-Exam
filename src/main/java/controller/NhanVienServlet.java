package controller;

import model.NhanVien;
import service.NhanVienDAO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="NhanVienServlet", urlPatterns = "/nhanvien")
public class NhanVienServlet extends HttpServlet {
    private NhanVienDAO nhanVienDAO;
    public void init(){
        nhanVienDAO = new NhanVienDAO();
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        try {
            switch (action){
                case "create":
                    create(req, resp);
                    break;
                case "edit":
                    update(req, resp);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(req, resp);
                    break;
                case "edit":
                    showEditForm(req, resp);
                    break;
                case "delete":
                    delete(req, resp);
                    break;
                default:
                    list(req, resp);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void create (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
        int salary = Integer.parseInt(request.getParameter("salary"));
        String department = request.getParameter("department");
        NhanVien nhanVien = new NhanVien(name,email,address, phoneNumber, salary, department);
        nhanVienDAO.add(nhanVien);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(request, response);
    }
    private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
        int nvId = Integer.parseInt(request.getParameter("nvId"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
        int salary = Integer.parseInt(request.getParameter("salary"));
        String department = request.getParameter("department");
        NhanVien nhanVien = new NhanVien(nvId, name,email,address, phoneNumber, salary, department);
        nhanVienDAO.update(nhanVien);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        dispatcher.forward(request, response);
    }
    private void delete (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
        int nvId = Integer.parseInt(request.getParameter("nvId"));
        nhanVienDAO.delete(nvId);
        List<NhanVien> nhanVien = nhanVienDAO.findAll();
        request.setAttribute("list",nhanVien);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }
    private void list(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
        List<NhanVien> nhanVien = nhanVienDAO.findAll();
        request.setAttribute("list",nhanVien);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int nvId = Integer.parseInt(request.getParameter("nvId"));
        NhanVien nhanVien = nhanVienDAO.findById(nvId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        request.setAttribute("nhanVien", nhanVien);
        dispatcher.forward(request, response);
    }
}
