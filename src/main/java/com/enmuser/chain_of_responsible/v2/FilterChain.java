package com.enmuser.chain_of_responsible.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: enmuser
 * @time: 2020/6/25 17:39
 */
public class FilterChain implements Filter{

    private List<Filter> filters = new ArrayList<>();

    int index = 0;
    public FilterChain addFilter(Filter filter){
        filters.add(filter);
        return this;
    }


    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        if(index == filters.size()) return true;
        Filter filter = filters.get(index);
        index++;
        return filter.doFilter(request,response,filterChain);
    }
}
