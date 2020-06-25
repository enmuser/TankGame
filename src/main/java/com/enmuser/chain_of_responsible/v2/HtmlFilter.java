package com.enmuser.chain_of_responsible.v2;

/**
 * @description:
 * @author: enmuser
 * @time: 2020/6/25 17:46
 */
public class HtmlFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        request.str +=  " Step1-request->HtmlFilter()";
        filterChain.doFilter(request,response,filterChain);
        response.str += "Step1-response->HtmlFilter()";
        return true;
    }
}
