package by.market.products.contollers.ui;

import by.market.products.services.ProductsService;
import by.market.products.services.api.IProductsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UiProductsServlet", urlPatterns = "/")
public class UiProductsServlet extends HttpServlet {

    private final IProductsService service = ProductsService.getInstance();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("products", service.get());
        req.getRequestDispatcher("/view/main.jsp").forward(req, resp);


    }


}
