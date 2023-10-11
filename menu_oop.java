package little_money_oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class menu_oop {

    //定义属性
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    String key = "";  //输入值
    String name = "";  //消费商品名称
    double money_add = 0;  //收入
    double money_los = 0;  //支出
    Date date = new Date(System.currentTimeMillis());
    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");  //显示时间
    double all_money = 0;  //总钱数
    String choose = "";
    String detail = "==========明细===========";

    //显示菜单
    public void menu(){
        System.out.println("显示菜单");
        do{
            System.out.println("==========菜单===========");
            System.out.println("\t\t1.明细");
            System.out.println("\t\t2.收入");
            System.out.println("\t\t3.消费");
            System.out.println("\t\t4.退出");
            System.out.println("请选择（1-4）：");
            key = scanner.next();

//            if(key =="1"){                                    //错误！！！不能用key =="1"，因为==比较的是地址，equals比较的才是内容
//                System.out.println("1.明细");                 //如果是==，最后一定会输出错误，因为比较的是地址
//            }
            if(key.equals("1")){
                this.details();
            } else if (key.equals("2")) {
                this.income();
            } else if (key.equals("3")) {
                this.outcome();
            }else if (key.equals("4")) {
               this.out();
            }else{
                System.out.println("错误");
            }


        }while(loop);
    }


    //完成明细
    public void details(){
        System.out.println("显示明细");
        System.out.println(detail + "\n" +formatter.format(date));
    }
    //完成收入
    public void income(){
        System.out.println("输入收入：");
        money_add = scanner.nextDouble();
        if(money_add < 3000000){
            all_money += money_add;
            detail += "\n收益入账\t"+money_add +"\t"+ formatter.format(date) +"\t"+ "余额" + all_money;
            System.out.println(detail);
        }else{
            System.out.println("错误，重新输入");
        }
    }
    //完成支出
    public void outcome(){
        System.out.println("输入名字：");
        scanner.nextLine(); // 消耗换行符         //输入两个东西的时候会有消耗换行符这个东西
        name = scanner.next();
        System.out.println("输入金额：");
        money_los = scanner.nextDouble();
        if(money_los < 3000000){
            all_money -= money_los;
            detail += "\n"+ name +"\t"+money_los +"\t"+ formatter.format(date) +"\t"+ "余额" + all_money;
            System.out.println(detail);
        }else{
            System.out.println("错误，重新输入");
        }
    }

    //完成退出
    public void out(){
        System.out.println("确定退出吗？确定（Y）返回（F）");
        choose = scanner.next();
        if(choose.equals("Y")){
            System.out.println("欢迎下次使用");
            loop = false;
        }else{
            System.out.println("返回主界面");
        }
    }
}
