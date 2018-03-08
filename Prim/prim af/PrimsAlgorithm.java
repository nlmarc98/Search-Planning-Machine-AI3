/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVMRspmlPrim;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author madel
 */
public class PrimsAlgorithm {

    public void primsAlgorithm(ArrayList<Vertex> G, ArrayList<Edge> w, Vertex r) {
        G.get(G.indexOf(r)).key = 0;
        Comparator<Vertex> comparator = new VertexComparator();
        PriorityQueue<Vertex> Q = new PriorityQueue<>(20, comparator);
        Q.addAll(G);
        Vertex u;
        while (!Q.isEmpty()) {
            u = Q.poll();
            ArrayList<Vertex> adj = getAdjacent(u, w);
            for (Vertex v : adj) {
                int weight = getWeight(u, v, w);
              if (Q.contains(v) && v.key > weight) {
                    Q.remove(v);
                    v.setParent(u);
                    v.setKey(weight);
                    Q.add(v);
                }
            }
        }
    }

    private ArrayList getAdjacent(Vertex u, ArrayList<Edge> edges) {
        ArrayList<Vertex> adj = new ArrayList<>();
        edges.stream().forEach((edge) -> {
            if (edge.from.equals(u)) {
                adj.add(edge.to);
            } else if (edge.to.equals(u)) {
                adj.add(edge.from);
            }
        });
        return adj;
    }

    public int getWeight(Vertex u, Vertex v, ArrayList<Edge> edges) {
        for (Edge edge : edges) {
            if ((edge.from.equals(u) && edge.to.equals(v)) || (edge.to.equals(u) && edge.from.equals(v))) {
                return edge.weight;
            }
        }
        return 100000;
    }
}
