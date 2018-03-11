/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.recipebok.util;

/**
 *
 * @author hajo
 */
public class ExceptionHandler {

    public static String getMessage(Throwable re) {
        while (re.getCause() != null) {
            re = re.getCause();
            return re.getMessage();
        }
        return "Unknown";
    }
}

