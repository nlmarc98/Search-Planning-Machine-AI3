/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVMRspmlPrim;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author madel
 */
public class MarcVerwoertMadeliefRennspiesAIAssignement1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
     
        long startTime = System.currentTimeMillis();

        Vertex a = new Vertex('a');
        Vertex b = new Vertex('b');
        Vertex c = new Vertex('c');
        Vertex d = new Vertex('d');
        Vertex e = new Vertex('e');
        Vertex f = new Vertex('f');
        Vertex g = new Vertex('g');
        Vertex h = new Vertex('h');
        Vertex i = new Vertex('i');
        Vertex j = new Vertex('j'); //added
        Vertex k = new Vertex('k'); //added

        Edge ab = new Edge(a, b, 4);
        Edge ah = new Edge(a, h, 8);
        Edge bc = new Edge(b, c, 8);
        Edge bh = new Edge(b, h, 11);
        Edge cd = new Edge(c, d, 7);
        Edge cf = new Edge(c, f, 4);
        Edge ci = new Edge(c, i, 2);
        Edge de = new Edge(d, e, 9);
        Edge df = new Edge(d, f, 14);
        Edge ef = new Edge(e, f, 10);
        Edge fg = new Edge(f, g, 2);
        Edge gh = new Edge(g, h, 1);
        Edge gi = new Edge(g, i, 6);
        Edge hi = new Edge(h, i, 7);
        Edge cj = new Edge(c, j, 8);//added
        Edge je = new Edge(j, e, 4);//added
        Edge dk = new Edge(d, k, 7);//added
        Edge fk = new Edge(f, k, 6);//added
        Edge kj = new Edge(k, j, 5);//added

        ArrayList<Vertex> graph
                = new ArrayList<>();

        graph.add(a);
        graph.add(b);
        graph.add(c);
        graph.add(d);
        graph.add(e);
        graph.add(f);
        graph.add(g);
        graph.add(h);
        graph.add(i);
 //       graph.add(j);//added
        //     graph.add(k);//added

        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(ab);
        edges.add(ah);
        edges.add(bc);
        edges.add(bh);
        edges.add(cd);
        edges.add(cf);
        edges.add(ci);
        edges.add(de);
        edges.add(df);
        edges.add(ef);
        edges.add(fg);
        edges.add(gh);
        edges.add(gi);
        edges.add(hi);
//        edges.add(cj);//added
//        edges.add(je);//added
//       edges.add(dk);//added
//        edges.add(fk);//added
//        edges.add(kj);//added

        Vertex root = e;
        PrimsAlgorithm prims = new PrimsAlgorithm();
        prims.primsAlgorithm(graph, edges, root);

        graph.stream().forEach((v) -> {
            if (v.parent != null) {
                System.out.println("vertex " + v + " is connected to " + v.parent + " with weight " + prims.getWeight(v.parent, v, edges));
            } else {
                System.out.println("vertex " + v + " is connected to " + v.parent);
            }
        });

        long endTime = System.currentTimeMillis();
        System.out.println("run time is: " + (endTime-startTime) + " milliseconds");

    }

}
