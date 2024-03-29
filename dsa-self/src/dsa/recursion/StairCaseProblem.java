package dsa.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

// There are n stairs, a person standing at the top wants to reach the bottom.
// The person can come down either 1 stair or 2 stairs or 3 stair at a time.
// Count the number of ways, the person can reach the bottom.
public class StairCaseProblem {
    @Test
    public void test(){
        StairCaseProblem algorithm = new StairCaseProblem();
        // total = 4 , Possible Move = 1,2,3
        List<String> basicPathResult = algorithm.getStairCasePathBasic(4);

        // total = 4 , Possible Move = 1,2,3 - Dynamic Solution
        int[] possibleAllowedMoves = new int[]{1,2,3};
        List<String> advancedPathResult = algorithm.getStairCasePathAdvanced(possibleAllowedMoves,4);

        Assertions.assertEquals(advancedPathResult, basicPathResult);
        System.out.println("4 Steps - Move 1,2,3");
        advancedPathResult.forEach(x-> System.out.println(x.substring(0,x.length()-1)));

        // total = 5 , Possible Move = 1,3,7
        possibleAllowedMoves = new int[]{1,3,7};
        advancedPathResult = algorithm.getStairCasePathAdvanced(possibleAllowedMoves,5);
        System.out.println("5 Steps - Move 1,3,7");
        advancedPathResult.forEach(x-> System.out.println(x.substring(0,x.length()-1)));

        System.out.println("Print : 4 Steps - Move 1,3,7");
        algorithm.printStairCase(4, "");
    }

    List<String> getStairCasePathBasic(int steps){
        if(steps == 0){
            List<String> blankStepList = new ArrayList<>();
            blankStepList.add("");
            return blankStepList;
        }else if(steps <= 0){
            return new ArrayList<>();
        }

        List<String> finalPath = new ArrayList<>();
        List<String> path1 = getStairCasePathBasic(steps - 1);
        appendPathsToFinalPath(finalPath, path1, "1");
        List<String> path2 = getStairCasePathBasic(steps - 2);
        appendPathsToFinalPath(finalPath, path2, "2");
        List<String> path3 = getStairCasePathBasic(steps - 3);
        appendPathsToFinalPath(finalPath, path3, "3");

        return finalPath;
    }

    List<String> getStairCasePathAdvanced(int[] possibleAllowedMoves,int steps){
        if(steps == 0){
            List<String> blankStepList = new ArrayList<>();
            blankStepList.add("");
            return blankStepList;
        }else if(steps <= 0){
            return new ArrayList<>();
        }

        List<String> finalPath = new ArrayList<>();
        for(int allowedMove : possibleAllowedMoves){
            List<String> path = getStairCasePathAdvanced(possibleAllowedMoves,steps - allowedMove);
            appendPathsToFinalPath(finalPath, path, String.valueOf(allowedMove));
        }

        return finalPath;
    }

    void appendPathsToFinalPath(List<String> finalPath, List<String> path, String step){
        for(String move : path){
            finalPath.add(step + "." + move);
        }
    }

    void printStairCase(int stepsLeft, String path){
        if(stepsLeft == 0){
            System.out.println("Print Path : " + path);
            return;
        }else if(stepsLeft < 0){
            //System.out.println("Ignored path : "+ path);
            return;
        }

        printStairCase(stepsLeft -1, "1"+path);
        printStairCase(stepsLeft -2, "2"+path);
        printStairCase(stepsLeft -3, "3"+path);
    }
}
