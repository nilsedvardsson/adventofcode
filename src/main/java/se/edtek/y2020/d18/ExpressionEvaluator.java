package se.edtek.y2020.d18;

import static se.edtek.y2020.d18.Operator.ADD;

public abstract class ExpressionEvaluator {

    public long evaluate(Node node) {
        while (node.canBeReduced()) {
            reduce(node);
        }

        return node.getValue();
    }

    private void reduce(Node node) {
        int leftIndex = findIndex(node);

        Node leftNode = node.getChildNodes().get(leftIndex);
        Node rightNode = node.getChildNodes().get(leftIndex + 1);

        Operator operator = node.getOperators().get(leftIndex);

        long leftValue = evaluate(leftNode);
        long rightValue = evaluate(rightNode);

        long value = operator == ADD ?
                leftValue + rightValue :
                leftValue * rightValue;

        Node newNode = new SimpleNode(value);

        node.replace(leftNode, rightNode, newNode);
    }

    public abstract int findIndex(Node node);

}
