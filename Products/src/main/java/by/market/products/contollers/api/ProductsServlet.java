package by.market.products.contollers.api;

import by.market.products.core.DTO.ProductCreateDTO;
import by.market.products.storages.entity.Product;
import by.market.products.storages.entity.ProductBuilder;
import by.market.products.services.ProductsService;
import by.market.products.services.api.IProductsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductsServlet", urlPatterns = "/addProduct")
public class ProductsServlet extends HttpServlet {

    private final IProductsService service;

    public ProductsServlet() {
        this.service = ProductsService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("products", service.get());
        req.getRequestDispatcher("view/main.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

                String name = req.getParameter("name");
                double price = Double.parseDouble(req.getParameter("price"));
                int sale = 0;
                if (!req.getParameter("sale").isBlank()){
                    sale = Integer.parseInt(req.getParameter("sale"));
                }
                String description = req.getParameter("description");

        ProductCreateDTO product = new ProductCreateDTO(name, price, sale, description);

        service.validate(product);
        req.setAttribute("added", "Product added");
//        resp.sendRedirect(req.getContextPath() + "/addProduct.jsp");
        resp.setStatus(201);
        req.getRequestDispatcher("view/addProduct.jsp").forward(req, resp);

    }
}
