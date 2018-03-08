/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVMRspmlPrim;

/**
 *
 * @author madel
 */
public class Vertex {
    char id;
    int key = 100000;
    Vertex parent;

    @Override
    public String toString() {
        return "Vertex " + this.id;
    }

 

    public void setParent(Vertex parent) {
        this.parent = parent;
    }
  
    public Vertex(char id){
        this.id = id;
    }

    public void setKey(int k){
        this.key = k;
    }

    public void setId(char id) {
        this.id = id;
    }
}
