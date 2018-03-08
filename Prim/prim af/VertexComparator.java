/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVMRspmlPrim;

import java.util.Comparator;

/**
 *
 * @author madel
 */
public class VertexComparator implements Comparator<Vertex> {

    @Override
    public int compare(Vertex o1, Vertex o2) {
        return o1.key - o2.key;
    }
}
