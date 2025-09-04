package shop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	public long insert(Product p) throws SQLException {
	    String seqSql = "SELECT products_seq.NEXTVAL FROM dual";
	    String insSql = "INSERT INTO products(id, name, price, quantity) VALUES (?,?,?,?)";
	    try (Connection conn = DBUtil.getConnection()) {
	        conn.setAutoCommit(false);

	        long newId;
	        try (PreparedStatement psSeq = conn.prepareStatement(seqSql);
	             ResultSet rs = psSeq.executeQuery()) {
	            rs.next();
	            newId = rs.getLong(1);
	        }

	        try (PreparedStatement ps = conn.prepareStatement(insSql)) {
	            ps.setLong(1, newId);
	            ps.setString(2, p.getName());
	            ps.setInt(3, p.getPrice());
	            ps.setInt(4, p.getQuantity());
	            ps.executeUpdate();
	        }

	        conn.commit();
	        p.setId(newId);
	        return newId;
	    }
	}

	public List<Product> findAll() throws SQLException {
		String sql = "SELECT id, name, price, quantity FROM products ORDER BY id DESC";
		List<Product> list = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				list.add(
						new Product(rs.getLong("id"), rs.getString("name"), rs.getInt("price"), rs.getInt("quantity")));
			}
		}
		return list;
	}

	public Product findById(long id) throws SQLException {
		String sql = "SELECT id, name, price, quantity FROM products WHERE id=?";
		try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setLong(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return new Product(rs.getLong("id"), rs.getString("name"), rs.getInt("price"),
							rs.getInt("quantity"));
				}
			}
		}
		return null;
	}
	
	public List<Product> searchByKeyword(String keyword) throws SQLException {
	    String sql = "SELECT id, name, price, quantity " +
	                 "FROM products " +
	                 "WHERE LOWER(name) LIKE LOWER(?) " +
	                 "ORDER BY id DESC";
	    List<Product> list = new ArrayList<>();
	    try (Connection conn = DBUtil.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setString(1, "%" + keyword + "%");
	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                list.add(new Product(
	                    rs.getLong("id"),
	                    rs.getString("name"),
	                    rs.getInt("price"),
	                    rs.getInt("quantity")
	                ));
	            }
	        }
	    }
	    return list;
	}

	public boolean update(Product p) throws SQLException {
		String sql = "UPDATE products SET name=?, price=?, quantity=? WHERE id=?";
		try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, p.getName());
			ps.setInt(2, p.getPrice());
			ps.setInt(3, p.getQuantity());
			ps.setLong(4, p.getId());
			return ps.executeUpdate() == 1;
		}
	}

	public boolean delete(long id) throws SQLException {
		String sql = "DELETE FROM products WHERE id=?";
		try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setLong(1, id);
			return ps.executeUpdate() == 1;
		}
	}
}