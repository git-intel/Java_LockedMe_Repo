package app.lockedme;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LockedMe {

	static boolean optionsAvaiable;
	static boolean fileoptionsAvaiable;
	public LockedMe() {

	}

	public static void main(String[] args) throws IOException {
		optionsAvaiable = true;
		fileoptionsAvaiable = true;
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
					LockedMe lm = new LockedMe();
					switch (choice) {
					case 1:
						System.out.println("Files in directory");
						optionsAvaiable = false;
						lm.listFiles();
						break;
					case 2:
						System.out.println("File handling tools");
						optionsAvaiable = false;
						fileoptionsAvaiable = true;
						LockedMe.showFileHandlingOptions();
						break;
					case 3:
						System.out.println("Exiting LockedMe");
						optionsAvaiable = false;
						System.exit(0);
						break;
					default:
						System.out.println("Please select the given options");
						optionsAvaiable = true;
						LockedMe.showUserOptions();
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

	public static void showFileHandlingOptions() {
		Scanner userIn = new Scanner(System.in);
		try {
			if (fileoptionsAvaiable == false) {
				System.out.println("Press enter to continue");
				try {
					String keyPress = userIn.nextLine();
					fileoptionsAvaiable = (keyPress != null) ? true : false;
				} catch (Exception e) {
					System.out.println(e);
				}
			}
			if (fileoptionsAvaiable == true) {
				System.out.println("**************File Handling Tools***************");
				System.out.println("1.Add a file to the existing directory list");
				System.out.println("2.Delete a user specified file from the existing directory list");
				System.out.println("3.Search a user specified file from the main directory");
				System.out.println("4.Go back to the main menu" + "\n");
				System.out.print("Enter your choice: ");
				try {
					int choice;
					choice = userIn.nextInt();

					switch (choice) {
					case 1:
						System.out.println("Add a file to the existing directory list");
						fileoptionsAvaiable = false;
						break;
					case 2:
						System.out.println("Delete a user specified file from the existing directory list");
						fileoptionsAvaiable = false;

						break;
					case 3:
						System.out.println("Search a user specified file from the main directory");
						fileoptionsAvaiable = false;
						break;
					case 4:
						System.out.println("back to the main menu");
						optionsAvaiable = true;
						LockedMe.showUserOptions();
					default:
						System.out.println("Please select the given options");
						fileoptionsAvaiable = true;
						LockedMe.showFileHandlingOptions();
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

}
