package ar.com.challenge.acme.clothing.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Node {

    private boolean isRoot;
    private boolean isFamily;
    private List<Node> nodes = new ArrayList<>();
    public Product data;
    public Node parent;


}
