package app.lockedme;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LockedMe {

	static boolean optionsAvaiable;

	public LockedMe() {

	}

	public static void main(String[] args) throws IOException {
		optionsAvaiable = true;
		showUserOptions();
	}

	public static void showUserOptions() {
		Scanner userIn = new Scanner(System.in);
		try {
			if (optionsAvaiable == false) {
				System.out.println("Press enter to continue");
				try {
					String keyPress = userIn.nextLine();
					optionsAvaiable = (keyPress != null) ? true : false;
				} catch (Exception e) {
					System.out.println(e);
				}
			}
			if (optionsAvaiable == true) {
				System.out.println("**************************************");
				System.out.println("**************Locked Me***************");
				System.out.println("**************************************" + "\n");
				System.out.println("1.List files in directory");
				System.out.println("2.File handling tools");
				System.out.println("3.Exit" + "\n");
				System.out.print("Enter your choice: ");
				try {
					int choice;
					choice = userIn.nextInt();

					switch (choice) {
					case 1:
						System.out.println("Files in directory");
						optionsAvaiable = false;
						LockedMe lm = new LockedMe();
						lm.listFiles();
						break;
					case 2:
						System.out.println("File handling tools");
						optionsAvaiable = false;
						break;
					case 3:
						System.out.println("Exiting LockedMe");
						optionsAvaiable = false;
						break;
					default:
						System.out.println("Please select the given options");

					}
				} catch (Exception e) {
					System.out.println(e);
				}

			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			userIn.close();
		}
	}

	public void listFiles() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the file path: ");
		try {
			String directoryPath = scanner.nextLine();

			File folder = new File(directoryPath);

			if (folder.isDirectory()) {

				File[] fileList = folder.listFiles(File::isFile);
//				File[] fileList = folder.listFiles(File::isDirectory); // directories
				Arrays.sort(fileList);

				System.out.println("\nTotal number of files present in the directory: " + fileList.length);

				for (File file : fileList) {
					System.out.println(file.getName());
				}

			}
			showUserOptions();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			scanner.close();
		}

	}

}
