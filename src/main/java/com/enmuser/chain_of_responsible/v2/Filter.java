package com.enmuser.chain_of_responsible.v2;

/**
 * @description:
 * @author: enmuser
 * @time: 2020/6/25 17:37
 */
public interface Filter {

    boolean doFilter(Request request, Response response, FilterChain filterChain);
}
