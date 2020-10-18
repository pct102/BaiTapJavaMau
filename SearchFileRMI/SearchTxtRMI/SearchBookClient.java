import java.util.Scanner;

public class SearchBookClient {
    public static void main(String[] args) {
        boolean isExit = false;
        while(!isExit){
            DisplayOptions();
            Scanner sc = new Scanner(System.in);
            int option = Integer.parseInt(sc.nextLine());
            sc.close();
            switch (option) {
                case 0:
                    System.out.println("Thank you! See you next time!");
                    isExit = true;
                    break;
                case 1:
                    System.out.println("Thank you! See you next time!");
                    break;
                case 2:
                    System.out.println("Thank you! See you next time!");
                    break;
                case 3:
                    System.out.println("Thank you! See you next time!");
                    break;
                case 4:
                    System.out.println("Thank you! See you next time!");
                    break;
                case 5:
                    System.out.println("Thank you! See you next time!");
                    break;
                default:
                    break;
            }
        }
        
    }
    
    private static void DisplayOptions(){
        System.out.println("Wellcome to Book Store!");
        System.out.println("You can choose any option below:");
        System.out.println("1: Insert a book");
        System.out.println("2: Insert many books");
        System.out.println("3: Search book");
        System.out.println("4: Update book");
        System.out.println("5: Delete book");
        System.out.println("0: Exit");

    }

    private static void SearchOption(){
        System.out.println("Wellcome to Book Search!");
        System.out.println("You can choose any option below:");
        System.out.println("1: Search By BookID");
        System.out.println("2: Search By Name");
        System.out.println("3: Search By Author");
        System.out.println("4: Search By ReleaseDate");
        System.out.println("5: Search By Type");
        System.out.println("0: Exit");
    }
}
