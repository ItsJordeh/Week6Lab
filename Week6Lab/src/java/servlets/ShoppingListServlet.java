package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
public class ShoppingListServlet extends HttpServlet {
    
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        HttpSession session = request.getSession();
        
        if(session.getAttribute("username") == null){
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                    .forward(request, response);
        }
        else
        {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String action = request.getParameter("action");
        String name = request.getParameter("username");
        String item = request.getParameter("item");
        switch(action){
            case "register":
                
                if(name != "")
                {
                session.setAttribute("username", name);
                
                }else{
                    request.setAttribute("error", "Please enter a valid name");
                }
                
                break;
                
            case "add":
                ArrayList<String> items;
                if(session.getAttribute("itemsList")==null){
                    items = new ArrayList<String>();
                }else{
                    items = (ArrayList<String>) session.getAttribute("itemsList");
                }
                if(item != "" && !items.contains(item)){
                    items.add(request.getParameter("item"));
                    session.setAttribute("itemsList", items);
                }else if(items.contains(item)){
                    request.setAttribute("error", "Your list already contains that item");
                }
                else{
                    request.setAttribute("error", "Please enter a valid item name");
                }
                break;
                
            case "delete":
                
                String itemToDelete = request.getParameter("radioList");
                
                if(session.getAttribute("itemsList")==null){
                    items = new ArrayList<String>();
                }else{
                    items = (ArrayList<String>) session.getAttribute("itemsList");
                }
                
                items.remove(items.indexOf(itemToDelete));
                
                session.setAttribute("itemsList", items);
                
                
                break;
                
            case "logout":
                session.invalidate();
                break;
            default:
                
                break;
        }
        
        doGet(request, response);

    }

}