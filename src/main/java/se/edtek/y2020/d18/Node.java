package se.edtek.y2020.d18;

import java.util.ArrayList;
import java.util.List;

import static se.edtek.y2020.d18.Operator.ADD;

public class Node {

    private List<Node> childNodes;
    private List<Operator> operators;

    public List<Node> getChildNodes() {
        return childNodes;
    }

    public List<Operator> getOperators() {
        return operators;
    }

    public Node() {
        childNodes = new ArrayList<>();
        operators = new ArrayList<>();
    }

    private void addChild(Node node) {
        childNodes.add(node);
    }

    private void addOperator(Operator operator) {
        operators.add(operator);
    }

    public static Node of(String s) {

        Node node = new Node();

        List<String> splits = new Splitter().split(s);

        if (splits.size() == 1 && s.startsWith("(")) {
            splits = new Splitter().split(s.substring(1, s.length() - 1));
        }

        if (splits.size() == 1) {
            return new SimpleNode(Long.parseLong(s.trim()));
        } else {

            node.addChild(Node.of(splits.get(0)));

            for (int i = 1; i < splits.size(); i++) {

                if (splits.get(i).startsWith("+")) {
                    node.addOperator(ADD);
                } else if (splits.get(i).startsWith("*")) {
                    node.addOperator(Operator.MULTIPLY);
                } else {
                    throw new RuntimeException("Illegal input: " + splits.get(i));
                }

                node.addChild(Node.of(splits.get(i).substring(1).trim()));
            }
        }

        return node;
    }

    public boolean canBeReduced() {
        if (childNodes.isEmpty()) {
            return false;
        }

        if (childNodes.size() > 1) {
            return true;
        }

        return childNodes.get(0).canBeReduced();
    }

    public long getValue() {
        return getChildNodes().get(0).getValue();
    }

    public void replace(Node leftNode, Node rightNode, Node newNode) {
        int index = childNodes.indexOf(leftNode);

        operators.remove(index);
        childNodes.remove(leftNode);
        childNodes.remove(rightNode);

        childNodes.add(index, newNode);
    }

    @Override
    public String toString() {
        if (childNodes.isEmpty()) {
            return Long.toString(getValue());
        }
        else {
            String s = "";
            for (int i = 0; i < operators.size(); i++) {
                s += "(" + childNodes.get(i).toString() + ") " + operators.get(i).toString() + " ";
            }
            s += "(" + childNodes.get(childNodes.size() - 1).toString() + ")";
            return s;
        }
    }
}
