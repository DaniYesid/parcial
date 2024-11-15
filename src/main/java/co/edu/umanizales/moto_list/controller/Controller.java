package co.edu.umanizales.moto_list.controller;

import co.edu.umanizales.moto_list.model.*;
import co.edu.umanizales.moto_list.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tree")
public class Controller {
    @Autowired
    private TreeService treeService;

    @GetMapping()
    public Node abb() {
        return treeService.vermoto();
    }

    @PostMapping("/add")
    public String add(@RequestBody Moto moto) {
        treeService.getABB().add(moto);
        return"Se agrego melo";
    }
    @GetMapping("/preorder")
    public List<Integer> postOrder(){
        return treeService.getABB().postOrder();
  }

    @GetMapping("/count")
    public int count(){
        return treeService.getABB().count();
    }

    @GetMapping("/height")
    public int calculateHeight(){
        return treeService.getABB().calculateHeight();
    }

    @GetMapping("/prune")
    public String prune(){
        treeService.getABB().prune();
        return "Se podo";
    }

    @GetMapping("/isleaf")
    public String leaf(){
        return treeService.getABB().leaf();
    }

    @GetMapping("/valexi")
    public String val(@RequestBody Moto moto){
        return treeService.getABB().valExi(moto);
    }

    @GetMapping("/inorder")
    public List<Integer> inorder(){
        return treeService.getABB().inOrder();
    }

}








