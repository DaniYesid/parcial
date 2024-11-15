package co.edu.umanizales.moto_list.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Node {
private Moto data;
private Node left;
private Node right;
private int cont;

public Node(Moto data) {
    this.data = data;
    this.cont = 1;
}

public boolean isLeaf() {
    if (left == null && right == null) {
        return true;
    } else {
        return false;
    }
}

public boolean isComplete(){
    if(Math.pow(2, this.getHeight())-1 == cont){
        return true;
    }
    else{
        return false;
    }
}



    public void add(Moto moto) {
        if (moto.getPlaca() < this.getData().getPlaca()) {
            if (getLeft() == null) {
                setLeft(new Node(moto));
            } else {
                getLeft().add(moto);
            }
        } else {
            if (getRight() == null) {
                setRight(new Node(moto));
            } else {
                getRight().add(moto);
            }
        }
        cont++;
    }

    public void postOrder(List<Integer> listado){
        if(getLeft() != null){
            getLeft().postOrder(listado);
        }
        if(getRight() != null){
            getRight().postOrder(listado);
        }
        listado.add(getData().getPlaca());
}


    public int count() {

        return 1 + (this.getLeft() != null ? this.getLeft().count() : 0) +
                (this.getRight() != null ? this.getRight().count() : 0);

    }

    public int getHeight() {
        if (isLeaf()) {
            return 1;
        } else {
            int altizq = 1, altder = 1;
            if (this.left != null) {
                altizq = left.getHeight();
            }
            if (this.right != null) {
                altder = right.getHeight();
            }
            return altizq > altder ? altizq+1 : altder+1;
        }
    }

    public boolean hasMoto(){
        return getLeft() != null || getRight() != null;

    }

    public void prune(){
        if(getLeft()!= null && getLeft().hasMoto()){
            getLeft().prune();
        }
        else{
            setLeft(null);
        }
        if(getRight() != null && getRight().hasMoto()){
            getRight().prune();
        }
        else {
            setRight(null);

        }
        cont = count();
    }


    public String validateIdExist(Moto moto) {
        if (moto.getPlaca() == this.data.getPlaca()) {
            return "El id ya existe";
        }

        if (moto.getPlaca() < this.data.getPlaca() && this.left != null) {
            return this.left.validateIdExist(moto);
        }

        if (moto.getPlaca() > this.data.getPlaca() && this.right != null) {
            return this.right.validateIdExist(moto);
        }
        return "Se agregó el id";
    }

    public void inOrder(List<Integer> listado){
        if(getLeft() != null){
            getLeft().inOrder(listado);
        }

        listado.add(getData().getPlaca());

        if(getRight() != null){
            getRight().inOrder(listado);
        }
    }

    public void preOrder(List<Integer> listado){
        if(getLeft() != null){
            listado.add(getData().getPlaca());
        }
        getLeft().preOrder(listado);

        if(getRight() != null){
            getRight().preOrder(listado);
        }
    }



} // Fin

