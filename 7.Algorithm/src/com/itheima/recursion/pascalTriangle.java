package com.itheima.recursion;
/**
 直接递归（未优化）
 Params:i-行坐标
        j-列坐标
 Return:该坐标元素值

 */
public class pascalTriangle {
//    private static int element(int i,int j){
//        if(j == 0 || i ==j){
//            return 1;
//        }
//        return element(i-1,j-1)+element(i-1,j);
//    }
//    public static void printSpace(int n,int i){
//        int num = (n-i-1)*3; //这里乘几是根据格式化加的空格定的，若是"%-6d",则乘3
//        for (int j = 0; j < num; j++) {
//            System.out.print(" ");
//        }
//    }
//    public static void print(int n){ //n为三角形高度
//        for (int i = 0; i < n; i++) {
//            printSpace(n,i);
//            for (int j = 0; j <= i; j++) {
//                System.out.printf("%-6d",element(i,j));
//            }
//            System.out.println();
//        }
//    }

    //优化1：使用备忘录优化(运用二维数组)：

//    private static int element(int[][] triangle,int i,int j){
//        if(triangle[i][j] > 0){
//            return triangle[i][j];
//        }
//        if(j == 0 || i ==j){
//            triangle[i][j] = 1;
//            return 1;
//        }
//        triangle[i][j] = element(triangle,i-1,j-1)+element(triangle,i-1,j);
//        return triangle[i][j];
//    }
//    public static void printSpace(int n,int i){
//        int num = (n-i-1)*3; //这里乘几是根据格式化加的空格定的，若是"%-6d",则乘3
//        for (int j = 0; j < num; j++) {
//            System.out.print(" ");
//        }
//    }
//    public static void print(int n){ //n为三角形高度
//        int[][] triangle = new int[n][]; //使用第三种二维数组初始化方法：第二维的长度动态申请
//        for (int i = 0; i < n; i++) { //行
//            triangle[i] = new int[i+1];
//            printSpace(n,i);
//            for (int j = 0; j <= i; j++) {
//                System.out.printf("%-6d",element(triangle,i,j));
//            }
//            System.out.println();
//        }
//    }

    //优化2：使用一维数组记忆法
    /**
     0  0  0  0  0  0  初始状态
     1  0  0  0  0  0   i=0
     1  1  0  0  0  0   i=1
     1  2  1  0  0  0   i=2
     1  3  3  1  0  0   i=3
     1  4  6  4  1  0   i=4
     */
    private static void createRow(int[] row,int i){ //生成每一行的数据并储存到一维数组里
        if(i==0){
            row[0] = 1;
            return;
        }
        for (int j = i; j > 0 ; j--) {
            row[j] = row[j] + row[j-1];
        }
        /**
         i=0,第1行[1,0,0,0,0,,,,,,,],row[0]=1,row[1]=0,row[2]=0
         i=1,row[1]=raw[1]+row[0]=0+1=1;row[0]=1第2行[1,1,0,0,0,,,,,,,],row[0]=1,row[1]=1,row[2]=0
         i=2,row[2]=raw[2]+row[0]=0+1=1;row[1]=raw[1]+row[0]=1+1=2;row[0]=1第2行[1,2,1,0,0,,,,,,,],row[0]=1,row[1]=2,row[2]=1
         */
    }
        public static void printSpace(int n,int i){
        int num = (n-i-1)*3; //这里乘几是根据格式化加的空格定的，若是"%-6d",则乘3
        for (int j = 0; j < num; j++) {
            System.out.print(" ");
        }
    }
    public static void print(int n){ //n为三角形高度
        int[] row = new int[n];  //[0,0,0,0....]
        for (int i = 0; i < n; i++) { //行
            createRow(row,i);
            printSpace(n,i);
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-6d",row[j]);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        //System.out.println(element(4,2));
        print(20);
    }
}
