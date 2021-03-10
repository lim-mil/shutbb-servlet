package com.limyel.utils.response;

public class Response404 {
    public static void main(String[] args) {
        Response200 response = new Response200();
        System.out.println(response.makeJson());
    }
}
