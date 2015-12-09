package com.zhou.util;

import com.sun.deploy.net.HttpRequest;
import com.zhou.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;

/**
 * Created by icepoint1999 on 12/7/15.
 */
public class BaseUtil extends HttpServlet{




    public static ModelAndView BaseView(){

        return new ModelAndView("application");
    }

    public static Model BaseModel(Model model,String path){

        model.addAttribute("RelativeUrl",path);

        return model;

    }

    public static User current_user(){

HttpSession httpSession=new HttpSession() {
    public long getCreationTime() {
        return 0;
    }

    public String getId() {
        return null;
    }

    public long getLastAccessedTime() {
        return 0;
    }

    public ServletContext getServletContext() {
        return null;
    }

    public void setMaxInactiveInterval(int i) {

    }

    public int getMaxInactiveInterval() {
        return 0;
    }

    public HttpSessionContext getSessionContext() {
        return null;
    }

    public Object getAttribute(String s) {
        return null;
    }

    public Object getValue(String s) {
        return null;
    }

    public Enumeration<String> getAttributeNames() {
        return null;
    }

    public String[] getValueNames() {
        return new String[0];
    }

    public void setAttribute(String s, Object o) {

    }

    public void putValue(String s, Object o) {

    }

    public void removeAttribute(String s) {

    }

    public void removeValue(String s) {

    }

    public void invalidate() {

    }

    public boolean isNew() {
        return false;
    }
};
  return     (User)httpSession.getAttribute("user");

    }
}
