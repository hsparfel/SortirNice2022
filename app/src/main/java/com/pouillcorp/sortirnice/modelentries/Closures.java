package com.pouillcorp.sortirnice.modelentries;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root
public class Closures {

    @ElementList(name="closure", required=false, inline = true)
    private List<Closure> listClosure;

    public List<Closure> getListClosure() {
        return listClosure;
    }
}
