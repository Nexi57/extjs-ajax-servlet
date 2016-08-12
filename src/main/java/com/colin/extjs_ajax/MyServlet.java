/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.colin.extjs_ajax;

import com.colin.list.ListIncrement;
import com.colin.list.ListUtils;
import static com.colin.list.ListUtils.arrayFromString;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author colin.dassonville
 */
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MyServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // Get Json object as a String {"arrayItems" : "1-2-3-4-5-6"}
        String arrayJson = request.getParameter("arrayDatas");
        
        Gson gson = new Gson();
        JsonObject jsonToReturn = new JsonObject();
        
        JsonElement jelement = new JsonParser().parse(arrayJson);
        // Create JSON Object from JSON String
        JsonObject jobject = gson.fromJson(arrayJson, JsonObject.class);
        // Extract array elements from JSON object
        String arrayItems = jobject.get("arrayItems").getAsString();
        
        String incrementedString = null;
        if(arrayItems != null && !arrayItems.trim().equals("")) {
            List <Integer> listToIncrement = new ArrayList<Integer>();
            boolean error = false;
            try {
                // Split items and fill an ArrayList
                listToIncrement = ListUtils.arrayFromString(arrayItems);
            } catch (NumberFormatException e) {
                error = true;
                jsonToReturn.addProperty("success", false);
                jsonToReturn.addProperty("message", "Please use integer only !");
            }

            if(!error) {
                List <Integer> incremetentedList = ListIncrement.incList(listToIncrement);
                incrementedString = ListUtils.integerArrayToString(incremetentedList);
                jsonToReturn.addProperty("success", true);
                jsonToReturn.addProperty("message", "This is your incremented array : " + incrementedString);
            }
        } else {
            incrementedString = ListUtils.integerArrayToString(ListIncrement.incList());
            jsonToReturn.addProperty("success", true);
            jsonToReturn.addProperty("message", "This is a random array : " + incrementedString);
        }
        
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
       
        out.println(jsonToReturn.toString());
        out.close();
    }
}
