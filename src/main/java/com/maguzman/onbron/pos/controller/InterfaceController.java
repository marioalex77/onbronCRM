package com.maguzman.onbron.pos.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by maguzman on 18/05/2017.
 */
public interface InterfaceController<TObject> {
    ModelAndView listar(ModelAndView model);
    ModelAndView guardar(TObject object, BindingResult result);
    ModelAndView mostrarFormulario(ModelAndView model);
    ModelAndView borrar(HttpServletRequest request);
    ModelAndView editar(HttpServletRequest request);
    ModelAndView mostrar(HttpServletRequest request);
}
