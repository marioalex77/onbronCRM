package com.maguzman.onbron.pos.controller;

import com.maguzman.onbron.beans.Documento;
import com.maguzman.onbron.beans.Producto;
import com.maguzman.onbron.service.ProductoService;
import com.maguzman.onbron.util.FileValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * Created by maguzman on 18/5/2017.
 */
@Controller
public class ProductoController extends GenericController implements InterfaceController<Producto>{
    private static final Logger logger = LogManager.getLogger(ProductoController.class);

    @Autowired
    ProductoService productoService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    FileValidator filevalidator;

    @InitBinder("producto")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(filevalidator);
    }

    //Listar Productos
    @RequestMapping(value="/producto", method = RequestMethod.GET)
    public ModelAndView listar(ModelAndView model) {
        logger.debug("listar() : Productos");
        List<Producto> listaProductos= productoService.buscarTodos();
        model.addObject("productos", listaProductos);
        model.setViewName("/products/products");
        return model;
    }


    @RequestMapping(value="/producto/agregar", method = RequestMethod.GET)
    public ModelAndView mostrarFormulario(ModelAndView model) {
        logger.debug("mostrarFormulario() Producto");
        Producto producto = new Producto();
        model.addObject("producto", producto);
        model.setViewName("/products/add_product");
        return model;
    }

    @RequestMapping(value = "/producto", method = RequestMethod.POST)
    public ModelAndView guardar(@Valid @ModelAttribute("producto") Producto producto,
                                BindingResult result){
        if(result.hasErrors()){
            ModelAndView model =  new ModelAndView("/products/add_product");
            model.addObject("producto", producto);
            return model;
        }
        else{

            guardarProducto(producto);
            return new ModelAndView("redirect:/producto");
        }
    }


    public ModelAndView borrar(HttpServletRequest request) {
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));
        logger.debug("borrar() Categoria {}",idProducto);
        productoService.borrar(idProducto);
        return new ModelAndView("redirect:/producto");
    }

    public ModelAndView editar(HttpServletRequest request) {
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));
        Producto producto = productoService.buscarPorClave(idProducto);
        logger.debug("Editar producto {}",producto);
        ModelAndView model = new ModelAndView("/products/add_product");
        model.addObject("producto", producto);
        return model;
    }

    public ModelAndView mostrar(HttpServletRequest request) {
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));
        Producto producto = productoService.buscarPorClave(idProducto);
        logger.debug("Mostrar producto {}",producto);
        ModelAndView model = new ModelAndView("/products/show_product");
        model.addObject("producto", producto);
        return model;
    }

    @ModelAttribute("loggedinuser")
    public String UsuarioLogeado(){
        return super.UsuarioLogeado();
    }

    public void guardarProducto(Producto producto) {
        Documento documento = new Documento();
        MultipartFile multipartFile = producto.getFile();
        documento.setNombre(multipartFile.getOriginalFilename());
        documento.setDescripcion(producto.getFileDescripcion());
        documento.setTipo(multipartFile.getContentType());
        try {
            documento.setDocumento(multipartFile.getBytes());
        }catch(IOException e){
            logger.error("Error al guardar archivo",e.getMessage());
        }
        producto.setDocumento(documento);
        if(producto.getIdProducto()==0){
            productoService.salvar(producto);
        }else{
            productoService.actualizar(producto);
        }
    }
}
