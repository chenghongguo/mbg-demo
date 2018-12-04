package com.hongguo.mbg.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: chenghongguo
 * @date: 2018-12-04
 * @description:
 */
public class Configuration {

    private List<Context> contexts;

    public Configuration() {
        this.contexts = new ArrayList<>();
    }

    public void addContext(Context context) {
        contexts.add(context);
    }

    public List<Context> getContexts() {
        return this.contexts;
    }

}
