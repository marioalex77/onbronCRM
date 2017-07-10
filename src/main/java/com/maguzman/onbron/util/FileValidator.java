package com.maguzman.onbron.util;

import com.maguzman.onbron.beans.Producto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

/**
 * Created by maguzman on 18/5/2017.
 */
@Component
public class FileValidator implements Validator{

    @Override
    public boolean supports(Class<?> aClass) {
        return Producto.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Producto file = (Producto) o;
        if(file.getFile()!=null){
            if(file.getFile().getSize()==0){
                errors.rejectValue("file","missing.file");
            }
        }
    }
}
