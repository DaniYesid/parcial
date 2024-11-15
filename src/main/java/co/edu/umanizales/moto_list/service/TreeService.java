package co.edu.umanizales.moto_list.service;

import co.edu.umanizales.moto_list.model.ABB;
import co.edu.umanizales.moto_list.model.Node;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class TreeService {
    private ABB ABB;
    private Node node;

    @PostConstruct
    public void init() {
        ABB = new ABB();
    }
    public Node vermoto() {

            return ABB.getRoot();



    }

}
