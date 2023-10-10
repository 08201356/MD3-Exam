package service;

import model.NhanVien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO implements INhanVienDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    private static final String INSERT_USERS_SQL = "INSERT INTO employee (name, email, address, phoneNumber, salary, department) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from employee";
    private static final String DELETE_USERS_SQL = "delete from employee where id = ?;";
    private static final String UPDATE_USERS_SQL = "update employee set name = ?,email= ?, address =?, phoneNumber =?, salary =?, department =? where id = ?;";
    public NhanVienDAO(){
    }
    protected Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public void add(NhanVien nhanVien) throws SQLException{
        System.out.println(INSERT_USERS_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = getConnection().prepareStatement(INSERT_USERS_SQL)){
            preparedStatement.setString(1, nhanVien.getName());
            preparedStatement.setString(2, nhanVien.getEmail());
            preparedStatement.setString(3, nhanVien.getAddress());
            preparedStatement.setInt(4, nhanVien.getPhoneNumber());
            preparedStatement.setInt(5, nhanVien.getSalary());
            preparedStatement.setString(6, nhanVien.getDepartment());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    public NhanVien findById(int nvId) {
        NhanVien nhanVien = null;
        try ( Connection connection = getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);){
            preparedStatement.setInt(1, nvId);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                Integer phoneNumber = rs.getInt("phoneNumber");
                Integer salary = rs.getInt("salary");
                String department = rs.getString("department");
                nhanVien = new NhanVien(name, email, address, phoneNumber, salary, department);
            }
        } catch (SQLException e){
            printSQLException(e);
        }
        return nhanVien;
    }
    public List<NhanVien> findAll(){
        List<NhanVien> nhanVien = new ArrayList<>();
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);){
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                Integer phoneNumber = rs.getInt("phoneNumber");
                Integer salary = rs.getInt("salary");
                String department = rs.getString("department");
                nhanVien.add(new NhanVien(name, email, address, phoneNumber, salary, department));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return nhanVien;
    }
    public boolean delete(int nvId) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, nvId);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    public boolean update(NhanVien nhanVien) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);){
            statement.setString(1, nhanVien.getName());
            statement.setString(2, nhanVien.getEmail());
            statement.setString(3, nhanVien.getAddress());
            statement.setInt(4,nhanVien.getPhoneNumber());
            statement.setInt(5,nhanVien.getSalary());
            statement.setString(6, nhanVien.getDepartment());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
