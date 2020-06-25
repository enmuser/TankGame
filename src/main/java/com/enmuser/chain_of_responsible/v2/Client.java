package com.enmuser.chain_of_responsible.v2;

/**
 * @description:
 * @author: enmuser
 * @time: 2020/6/25 17:54
 */
public class Client {

    public static void main(String[] args) {
        Request request = new Request();
        request.str = "request: ";
        Response response = new Response();
        response.str = "response: ";

        FilterChain chain = new FilterChain();
        chain.addFilter(new HtmlFilter()).addFilter(new SensitiveFilter());
        chain.doFilter(request, response, chain);
        System.out.println(request.str);
        System.out.println(response.str);
    }
}
