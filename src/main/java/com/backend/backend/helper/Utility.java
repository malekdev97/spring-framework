package com.backend.backend.helper;

import jakarta.servlet.http.HttpServletRequest;

public class Utility {
    public static String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString(); // this will return the current URL
        return siteURL.replace(request.getServletPath(), ""); // this will remove the servlet path from the URL and return the base URL
    }
}
