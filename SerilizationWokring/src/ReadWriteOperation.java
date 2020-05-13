import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ReadWriteOperation {

	public static void main(String[] args) throws IOException, IOException {

		boolean isExit = false;

		do {
			System.out.println(
					"Please choose your category:\nPress 1\t For add student information.\nPress 2\t For see the student record.\nPress 3\t For Quit!");

			Scanner scanner = new Scanner(System.in);
			int code = scanner.nextInt();
			switch (code) {

			case 1:

				try (FileOutputStream stream = new FileOutputStream("File.txt");
						ObjectOutputStream stream2 = new ObjectOutputStream(stream)) {

					Scanner scan = new Scanner(System.in);
					System.out.println("\t\tPlease enter your information\t\t\n");
					System.out.println("Name: ");
					String name = scan.nextLine();
					System.out.println("Age: ");
					int age = scan.nextInt();
					System.out.println("ID: ");
					int iD = scan.nextInt();
					System.out.println("\n\t\tThank you!!\n ");

					StudentInfo info = new StudentInfo(name, age, iD);
					stream2.writeObject(info);

					stream2.flush();
					stream2.close();

				} catch (IOException e) {
					e.printStackTrace();

				}
				break;

			case 2:

				try (FileInputStream inputStream = new FileInputStream("File.txt");
						ObjectInputStream inputStream2 = new ObjectInputStream(inputStream)) {

					System.out.println("\t\tStudent record\n");

					StudentInfo info = (StudentInfo) inputStream2.readObject();
					System.out.println(info.toString());

					inputStream2.close();

				} catch (IOException | ClassNotFoundException e) {
					e.printStackTrace();
				}
				break;

			case 3:

				isExit = true;
				break;

			default:
			}

		} while (!isExit);

	}

}
