import java.util.Scanner;

import com.te.design.service.ServiceImpl;

public class MainDriver {
	public static void main(String[] args) {
		ServiceImpl impl = new ServiceImpl();
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("enter one option :");
			System.out.println("1. insert");
			System.out.println("2. update");
			System.out.println("3. readById");
			System.out.println("4. readAll");
			System.out.println("5. delete");
			System.out.println("6. exit");
			int key = scanner.nextInt();
			switch (key) {
			case 1:
				impl.insert();
				break;
			case 2:
				impl.update();
				break;
			case 3:
				impl.readById();
				break;
			case 4:
				impl.readAll();
				break;
			case 5:
				impl.delete();
				break;
			case 6:
				System.exit(0);
			default:
				break;
			}
		}
	}
}
