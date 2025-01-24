//2303. Calculate the Amount paid in Taxes - https://leetcode.com/problems/calculate-amount-paid-in-taxes/description/

//Brute Force:
//Constant Space and Time Complexities
class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0;
        int idx = 0;
        int lower = 0; //default lower

        while(income > 0){
            int[] br = brackets[idx];
            idx++;
            //for [(10000, 10),(20000, 20),(30000, 30),(50000, 40)]
            int upper = br[0]; //(10000, 10): upper = br[0]
            int percent = br[1]; //br[1]

            int taxable = Math.min(income, upper-lower);

            tax += taxable * (percent/100.00);

            lower = upper;
            income = income - taxable;
        }
        return tax;
    }
}

//Recursive
//Constant Space and Time Complexities
class Solution {
    public double calculateTax(int[][] brackets, int income) {
        return helper(brackets, income, 0, 0);
    }

    private double helper(int[][] brackets, int income, int lower, int idx){
        //base case
        if(income <= 0) return 0;

        //logic
        double tax = 0;
        int[] br = brackets[idx];
        int upper = br[0];
        int percent = br[1];

        int taxable = Math.min(income, upper-lower);

        tax += taxable * (percent/100.00) +
                helper(brackets, income-taxable, upper, idx+1);

        return tax;

    }
}