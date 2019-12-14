package com.xfc.structure.linklist;


import org.junit.Test;

import static org.junit.Assert.*;

public class UnidirectionalLinkListTest {


    @Test
    public void add() {
        UnidirectionalLinkList unidirectionalLinkList = new UnidirectionalLinkList();
        unidirectionalLinkList.add("1");
        unidirectionalLinkList.add("4");
        unidirectionalLinkList.add("13");
        unidirectionalLinkList.add("2");
        unidirectionalLinkList.add("4");
        unidirectionalLinkList.add("76");
        unidirectionalLinkList.add("432");

        UnidirectionalLinkList.Node node = unidirectionalLinkList.getHead();

        while ((node = node.getNext())!=null){
            System.out.println(node);
        }

    }
}
