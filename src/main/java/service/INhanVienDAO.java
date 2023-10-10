package service;

import java.sql.SQLException;
import java.util.List;
import model.NhanVien;
public interface INhanVienDAO {
    public NhanVien findById(int nvId);
    public List<NhanVien> findAll() throws SQLException;
    public void add (NhanVien nhanVien) throws SQLException;
    public boolean update (NhanVien nhanVien) throws SQLException;
    public boolean delete (int nvId) throws SQLException;
}
