package ro.sci.onlinelibrary.controller;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Ivett on 10/7/2017.
 */
public class GlobalControllerExceptionHandler {
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  // 409
//    @ExceptionHandler(Exception.class)
//    public ModelAndView
//    defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//        // If the exception is annotated with @ResponseStatus rethrow it and let
//        // the framework handle it - like the OrderNotFoundException example
//        // at the start of this post.
//        // AnnotationUtils is a Spring Framework utility class.
//        if (AnnotationUtils.findAnnotation
//                (e.getClass(), ResponseStatus.class) != null)
//            throw e;
//
//        // Otherwise setup and send the user to a default error-view.
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.addObject("url", req.getRequestURL());
//        mav.setViewName("error");
//        return mav;
//    }
}