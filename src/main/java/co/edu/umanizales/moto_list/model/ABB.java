package co.edu.umanizales.moto_list.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ABB {
    private Node root;
    private int size;

    public void add(Moto moto) {
        if (root == null) {
            root = new Node(moto);
        }
        else {
            root.add(moto);
        }
    }
    public String valExi(Moto moto) {
        return root.validateIdExist(moto);
    }

    public List<Integer> postOrder(){
        if(root ==null){
            return null;
        }
        else{
            List<Integer> listadoInicial = new ArrayList<>();
            root.postOrder(listadoInicial);
            return listadoInicial;
        }
    }

    public int count(){
        return root == null ? 0 : root.count();
    }

    public int calculateHeight(){
        return root == null ? 0 : root.getHeight();
    }

    public void prune(){
        if(root !=null){
            root.prune();
        }
    }

    public String leaf(){
        if (root == null) {
            return "No hay nada";
        }
        if (root == root){
            return "Es la raiz";
        }
        else {
            root.isLeaf();
            return "es hoja";
        }
    }

    public List<Integer> inOrder(){
        if(root ==null){
            return null;
        }
        else{
            List<Integer> listadoInicial = new ArrayList<>();
            root.inOrder(listadoInicial);
            return listadoInicial;
        }
    }

    public List<Integer> preOrder(){
        if(root ==null){
            return null;
        }
        else{
            List<Integer> listadoInicial = new ArrayList<>();
            root.preOrder(listadoInicial);
            return listadoInicial;
       }

}





}
