package shop;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "productServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private final ProductService service = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null || action.equals("list")) {
            // 전체 목록
            try {
                req.setAttribute("products", service.list());
            } catch (SQLException e) {
                req.setAttribute(UiHelper.FLASH_KEY, "목록 조회 실패: " + e.getMessage());
            }
            req.getRequestDispatcher("/product-list.jsp").forward(req, resp);

        } else if ("search".equals(action)) {
            // 검색
            String keyword = req.getParameter("q");
            try {
                req.setAttribute("products", service.search(keyword == null ? "" : keyword));
                req.setAttribute("q", keyword);
            } catch (SQLException e) {
                req.setAttribute(UiHelper.FLASH_KEY, "검색 실패: " + e.getMessage());
            }
            req.getRequestDispatcher("/product-list.jsp").forward(req, resp);

        } else if ("new".equals(action)) {
            // 신규 등록 폼
            req.getRequestDispatcher("/product-form.jsp").forward(req, resp);

        } else if ("edit".equals(action)) {
            // 수정 폼
            try {
                long id = Long.parseLong(req.getParameter("id"));
                req.setAttribute("product", service.get(id));
            } catch (Exception e) {
                req.setAttribute(UiHelper.FLASH_KEY, "잘못된 요청: " + e.getMessage());
            }
            req.getRequestDispatcher("/product-form.jsp").forward(req, resp);

        } else {
            // 알 수 없는 action → 목록으로 리다이렉트
            resp.sendRedirect(req.getContextPath() + "/product?action=list");
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("create".equals(action)) {
            String name = req.getParameter("name");
            int price = ValidationUtil.toIntOrDefault(req.getParameter("price"), 0);
            int qty   = ValidationUtil.toIntOrDefault(req.getParameter("quantity"), 0);
            if (ValidationUtil.isNullOrBlank(name) || price <= 0 || qty < 0) {
                req.setAttribute(UiHelper.FLASH_KEY, "유효하지 않은 입력입니다.");
                req.getRequestDispatcher("/product-form.jsp").forward(req, resp);
                return;
            }
            try {
                service.addProduct(name, price, qty);
                resp.sendRedirect(req.getContextPath() + "/product?action=list");
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        } else if ("update".equals(action)) {
            try {
                long id = Long.parseLong(req.getParameter("id"));
                String name = req.getParameter("name");
                int price = ValidationUtil.toIntOrDefault(req.getParameter("price"), 0);
                int qty   = ValidationUtil.toIntOrDefault(req.getParameter("quantity"), 0);
                service.update(id, name, price, qty);
                resp.sendRedirect(req.getContextPath() + "/product?action=list");
            } catch (Exception e) {
                throw new ServletException(e);
            }
        } else if ("delete".equals(action)) {
            try {
                long id = Long.parseLong(req.getParameter("id"));
                service.remove(id);
            } catch (Exception ignored) { }
            resp.sendRedirect(req.getContextPath() + "/product?action=list");
        } else {
            resp.sendRedirect(req.getContextPath() + "/product?action=list");
        }
    }
}
