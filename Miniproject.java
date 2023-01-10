import java.util.Scanner;

import javax.print.attribute.standard.MediaSize.NA;

public class Miniproject {
    public static void main(String[] args){
        
        //กำหนด variable
        String gender;
        int age;
        double height;
        double weight;
        double BMR;
        double calorie_total = 0; 
        String[] menu_name = {"","ข้าวมันไก่","ข้าวผัดหมูใส่ไข่","ข้าวเหนียวหมูปิ้ง","ก๋วยเตี๋ยว","ข้าวไข่เจียว","ขนมจีนน้ำยา","ข้าวผัดกะเพราไก่","บะหมี่กึ่งสำเร็จรูป","ข้าวต้มทรงเครื่อง","ไข่ดาว"} ;
        double[] menu_cal = {0,596,557,585.7,320,445,332,554,253,230,165} ;
        int food_input = -1;

        //รับ input เพื่อคำนวน BMR
        Scanner sc = new Scanner(System.in) ; 
        System.out.println("Enter your gender (male / female) : ");
        gender = sc.nextLine();
        System.out.println("Enter your age (years) : ");
        age = sc.nextInt();
        System.out.println("Enter your height (cm) : ");
        height = sc.nextDouble();
        System.out.println("Enter your weight (kg) : ");
        weight = sc.nextDouble();

        //คำนวน BRM
        switch (gender){
            case("male"):
                BMR = 66 + (6.23 * weight) + (12.7 * height) - (6.8 * age);
                System.out.println("Your BMR is " + BMR);
                break;
            case ("female"):
                BMR = 665 + (4.35 * weight) + (4.7 * height) - (4.7 * age);
                System.out.println("Your BMR is " + BMR);
                break;
            default:
                System.out.println("Please enter a valid gender");
                sc.close();
                return;
        }
        
        // แสดงเมนู
        for(int i = 1; i < 11; i++) {
            System.out.println(i + " " + menu_name[i]);           
        }

        // รับ input อาหาร
        while (food_input != 0){
            System.out.print("Enter your menu list (enter 0 to finish) : ");
            food_input = sc.nextInt();
            if (food_input > 10 || food_input < 0){
                System.out.println("Please enter number between 1 and 10 ");
                continue;
            }
            calorie_total += menu_cal[food_input];
        }

        //แสดงผล
        System.out.println();
        System.out.println("--------------------------------------------");
        System.out.println("Your BMR is " + BMR);
        System.out.println("You ate " + calorie_total + " calories");

        if (BMR > calorie_total) {
            System.out.println("* You ate less than your BMR *");
        }
        else if (BMR < calorie_total) {
            System.out.println("* You ate more than your BMR *");
        }
        System.out.println("--------------------------------------------");
        System.out.println();
        sc.close();
    }
        
}