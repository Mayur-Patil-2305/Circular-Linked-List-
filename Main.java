//Circular linked list (hard code) in java for creation deletion and display basic operations

package mayurRpatil;
import java.util.Scanner;
public class Main {
    private static Scanner scan=new Scanner(System.in);
    public static void main(String [] args){
        int choice=0,data=0,position=0;
        CLL obj=new CLL();        //linked list object
        do{
            System.out.print("\nMenu\n1.Insert\n2.Delete\n3.Display\n4.Exit\nEnter Your Choice : ");
            choice=scan.nextInt();
            scan.nextLine();
            switch(choice){
                case 1:
                    System.out.print("Enter data : ");
                    data=scan.nextInt();
                    System.out.print("Enter Position : ");
                    position=scan.nextInt();
                    obj.insert(data,position);
                    break;
                case 2 :
                    System.out.println("Enter Data");
                    data=scan.nextInt();
                    obj.delete(data);
                    break;
                case 3:
                    System.out.print("List is \n - > ");
                    obj.display();
                    break;
                case 4:
                    System.out.println("Program ends");
                    break;
            }
        }while(choice!=4);
    }
}
