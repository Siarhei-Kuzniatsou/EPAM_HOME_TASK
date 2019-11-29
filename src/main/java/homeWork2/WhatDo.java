package homeWork2;

public class WhatDo {
    private int[] args;

    WhatDo(String[] args) {
        this.args = parseArray(args);
    }

    private int[] parseArray(String[] args) {
        if (args.length == 0) args = new String[]{"1", "1", "1"};
        int[] resultArray = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            resultArray[i] = Integer.parseInt(args[i]);
        }
        return resultArray;
    }

    public void run() {
        switch (this.args[0]) {
            case 1:
                new HowFibonacci().howFibonacci(this.args[1], this.args[2]);
                break;
            case 2:
                new HowFactorial().howFactorial(this.args[1], this.args[2]);
                break;
        }
    }
}
