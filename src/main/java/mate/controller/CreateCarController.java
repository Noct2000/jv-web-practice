package mate.controller;

import mate.lib.Injector;
import mate.model.Manufacturer;
import mate.service.CarService;
import mate.service.ManufacturerService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CreateCarController extends HttpServlet {
    private static final String CAR_CREATE_FORM = "/WEB-INF/views/carCreateForm.jsp";
    private static final String ROOT_PACKAGE = "mate";
    private static final String MANUFACTURERS_ATTRIBUTE = "manufacturers";
    private CarService carService;
    private ManufacturerService manufacturerService;

    @Override
    public void init() {
        Injector injector = Injector.getInstance(ROOT_PACKAGE);
        carService = (CarService) injector
                .getInstance(CarService.class);
        manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        req.setAttribute(MANUFACTURERS_ATTRIBUTE, manufacturers);
        req.getRequestDispatcher(CAR_CREATE_FORM).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
