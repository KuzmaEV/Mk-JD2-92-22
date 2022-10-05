package by.market.products.contollers.web.servlets.api;

import by.market.products.core.DTO.ProductCreateDTO;
import by.market.products.storages.entity.Product;
import by.market.products.storages.entity.ProductBuilder;
import by.market.products.services.ProductsService;
import by.market.products.services.api.IProductsService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ProductsServlet", urlPatterns = "/addProduct")
public class ProductsServlet extends HttpServlet {

    private final IProductsService service;
    private final ObjectMapper mapper;

    public ProductsServlet() {

        this.service = ProductsService.getInstance();
        this.mapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        List<Product> products = service.get();
        PrintWriter writer = resp.getWriter();

        writer.write(this.mapper.writeValueAsString(products));

//        req.setAttribute("products", service.get());
//        req.getRequestDispatcher("view/main.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        ProductCreateDTO createDTO = this.mapper.readValue(req.getInputStream(), ProductCreateDTO.class); // чтобы с параметров перейти на боди

//                String name = req.getParameter("name");
//                double price = Double.parseDouble(req.getParameter("price"));
//                int sale = 0;
//                if (!req.getParameter("sale").isBlank()){
//                    sale = Integer.parseInt(req.getParameter("sale"));
//                }
//                String description = req.getParameter("description");

//        ProductCreateDTO product = new ProductCreateDTO(name, price, sale, description);

        service.validate(createDTO);
        req.setAttribute("added", "Product added");
//        resp.sendRedirect(req.getContextPath() + "/addProduct.jsp");
        resp.setStatus(201);
        req.getRequestDispatcher("view/addProduct.jsp").forward(req, resp);

    }
}
