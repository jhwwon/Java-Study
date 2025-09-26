package shop;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
	private final ProductDAO dao = new ProductDAO();

	public long addProduct(String name, int price, int qty) throws SQLException {
		Product p = new Product(name, price, qty);
		return dao.insert(p);
	}

	public List<Product> list() throws SQLException {
		return dao.findAll();
	}

	public Product get(long id) throws SQLException {
		return dao.findById(id);
	}
	
	public List<Product> search(String keyword) throws SQLException {
	    return dao.searchByKeyword(keyword);
	}

	public boolean update(long id, String name, int price, int qty) throws SQLException {
		return dao.update(new Product(id, name, price, qty));
	}

	public boolean remove(long id) throws SQLException {
		return dao.delete(id);
	}
}