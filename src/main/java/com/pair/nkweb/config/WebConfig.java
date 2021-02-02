package com.pair.nkweb.config;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;

import javax.servlet.*;
import java.util.EnumSet;

public class WebConfig implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext context) throws ServletException {

        Class[] rootContext = new Class[] {com.pair.nkweb.config.RootConfig.class, Root2Config.class};
        Class[] servletContext = new Class[] {com.pair.nkweb.config.ServletConfig.class};

        AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();

        rootAppContext.register(rootContext);

        ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);

        context.addListener(listener);


        AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();

        servletAppContext.register(servletContext);

        FrameworkServlet dispatcherServlet = new DispatcherServlet(servletAppContext);

        ServletRegistration.Dynamic registration = context.addServlet("dispatcher", dispatcherServlet);

        registration.setLoadOnStartup(1);
        registration.addMapping(new String[] {"/"});
        registration.setAsyncSupported(true);

        //MultipartConfigElement multipartConfigElement = new MultipartConfigElement("/home/pair/picture/nkweb/");
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement("C:/summernote_image/");

        registration.setMultipartConfig(multipartConfigElement);

        registerCharacterEncodingFilter(context);

    }


    private void registerCharacterEncodingFilter(ServletContext servletContext){
        FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("characterEncodingFilter", new CharacterEncodingFilter());

        characterEncodingFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
        characterEncodingFilter.setInitParameter("encoding", "UTF-8");
        characterEncodingFilter.setInitParameter("forceEncoding", "true");

    }




}
