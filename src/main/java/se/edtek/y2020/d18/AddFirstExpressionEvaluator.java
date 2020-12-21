package se.edtek.y2020.d18;

import static se.edtek.y2020.d18.Operator.ADD;

public class AddFirstExpressionEvaluator extends ExpressionEvaluator {


    @Override
    public int findIndex(Node node) {
        if (node.getChildNodes().size() == 1) {
            return 0;
        }
        else {

            for (int i = 0; i < node.getOperators().size(); i++) {
                if (node.getOperators().get(i) == ADD) {
                    return i;
                }
            }

            return 0;
        }
    }
}
