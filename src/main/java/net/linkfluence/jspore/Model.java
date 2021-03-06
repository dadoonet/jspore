/*
 */
package net.linkfluence.jspore;

import com.google.common.base.Strings;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Nicolas Yzet <nyzet@linkfluence.net>
 */
public class Model {

    public URL baseUrl;
    public String version;
    public String name;
    
    public final Map<String, Method> routes;

    public Model() {
        routes = new HashMap<String, Method>();
    }
    
    public void addMethod(Method method){
        routes.put(method.name, method);
    }
    
    /**
     * Check spore model validity.
     * To be valid a Model must have a base url and at least one route.
     * 
     * @return true if valid false otherwise.
     */
    public boolean isValid(){
        return (baseUrl != null) && (routes.size() > 0);
    }
    
    /**
     * merge this model with a m model. Every non-null/empty properties of m existing in this
     * will be overrided.
     * 
     * @param m 
     */
    public void merge(Model m){
        if(m.baseUrl != null){
            this.baseUrl = m.baseUrl;
        }
        
        if(!Strings.isNullOrEmpty(m.version)){
            this.version = m.version;
        }
        if(!Strings.isNullOrEmpty(name)){
            this.name = m.name;
        }
        
        for(Entry<String, Method> e : m.routes.entrySet()){
            this.routes.put(e.getKey(), e.getValue());
        }
    }
    
    public Method getMethod(String name){
        return routes.get(name);
    }
}
