import java.util.Scanner;

public class arrayoperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter size of array: ");
        int size = sc.nextInt();
        int[] arr = new int[100]; 

        System.out.println("Please enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int choice; 
        do {
            
            System.out.println("\n============================");
            System.out.println("     ARRAY OPERATIONS MENU  ");
            System.out.println("============================");
            System.out.println("1. Display Elements");
            System.out.println("2. Insert Element");
            System.out.println("3. Delete Element");
            System.out.println("4. Search Element");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: 
                    if (size == 0) {
                        System.out.println("Array is empty!");
                    } else {
                        System.out.print("Array elements: ");
                        for (int i = 0; i < size; i++) {
                            System.out.print(arr[i] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 2: 
                    System.out.println("Where do you want to insert?");
                    System.out.println("1. At Beginning\n2. At Given Position\n3. At End");
                    int insertChoice = sc.nextInt();
                    System.out.print("Enter number to insert: ");
                    int element = sc.nextInt();

                    if (insertChoice == 1) { 
                        for (int i = size; i > 0; i--) {
                            arr[i] = arr[i - 1];
                        }
                        arr[0] = element;
                        size++;
                    } else if (insertChoice == 2) { 
                        System.out.print("Enter position (1 to " + (size + 1) + "): ");
                        int pos = sc.nextInt();
                        if (pos < 1 || pos > size + 1) {
                            System.out.println("Invalid position!");
                        } else {
                            for (int i = size; i >= pos; i--) {
                                arr[i] = arr[i - 1];
                            }
                            arr[pos - 1] = element;
                            size++;
                        }
                    } else if (insertChoice == 3) { 
                        arr[size] = element;
                        size++;
                    } else {
                        System.out.println("Invalid choice!");
                    }
                    break;

                case 3: 
                    if (size == 0) {
                        System.out.println("Array is empty, nothing to delete!");
                        break;
                    }

                    System.out.println("Where do you want to delete?");
                    System.out.println("1. From Beginning\n2. From Given Position\n3. From End");
                    int deleteChoice = sc.nextInt();

                    if (deleteChoice == 1) { 
                        for (int i = 0; i < size - 1; i++) {
                            arr[i] = arr[i + 1];
                        }
                        size--;
                    } 
                    else if (deleteChoice == 2) { 
                        System.out.print("Enter position (1 to " + size + "): ");
                        int pos = sc.nextInt();
                        if (pos < 1 || pos > size) {
                            System.out.println("Invalid position!");
                        } else {
                            for (int i = pos - 1; i < size - 1; i++) {
                                arr[i] = arr[i + 1];
                            }
                            size--;
                        }
                    } else if (deleteChoice == 3) { 
                        size--;
                    } else {
                        System.out.println("Invalid choice!");
                    }
                    break;

                case 4:
                    
                    if (size == 0) {
                        System.out.println("Array is empty!");
                        break;
                    }

                    System.out.print("Enter number to search: ");
                    int key = sc.nextInt();
                    boolean found = false;
                    for (int i = 0; i < size; i++) {
                        if (arr[i] == key) {
                            System.out.println("Number found at position: " + (i + 1));
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Number not found!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting program... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
