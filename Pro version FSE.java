
// Pro version File Search Engine

import java.io.*;
import java.io.File;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Puppy
{
	private static Scanner scanInput = new Scanner(System.in);
	private static String input;
	private static boolean exit = false;
	private static File file = null;
	private static File file02 = null;
	private static File tryFile = null;
	private static File newFile = null;
	public static String[] storageDevice = {"/sdcard","/root","/g"};
	private static Pattern searchPattern;
	private static Matcher searchmatcher;
	private static int foundFile = 1,fileTrue = 0;
	private static boolean storageExist = false;

	private static void searchEngine01(){
		System.out.println("Searching...");

		//this display readable storage device
		for(String displayStorage : storageDevice){
			File isStorage = new File(displayStorage);
			if(isStorage.isDirectory() == true){
				System.out.println("Drive " + displayStorage + ":");
			}
			else if(isStorage.isDirectory() == false){
				System.out.println("Drive " + displayStorage +":" + " not recorgnised");
			}
		}//end for(displayStorage)
		System.out.println("Please wait...");
		//this reads each readable storage device
		for(String loopStorage : storageDevice){
			searchPattern = Pattern.compile(input);
			try{

				file = new File(loopStorage);
				String[] filepath = file.list();



				for(String currentFile : filepath){
					StringBuffer folder01 = new StringBuffer();
					StringBuffer folder02 = new StringBuffer();
					folder02 = folder02.append(loopStorage +"/"+currentFile);

					searchmatcher = searchPattern.matcher(currentFile);
					if(searchmatcher.find() == true){
						if(foundFile == 1){
							System.out.println("\nFound file");
							foundFile = 0;
							fileTrue = 1;}
						System.out.println("Location: "+folder02);
						//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^//
					}
					folder01 = folder01.append(loopStorage+"/"+currentFile+"/");
					tryFile = new File(folder01.toString());
					if(tryFile.isDirectory() == true){
						Puppy obj = new Puppy();
						obj.searchEngine02(folder01.toString());
					}
					//System.out.println("Search Engine01 " + folder01);
				}
			}catch(NullPointerException e){}

		}//end for(loopStorage)
		if(fileTrue == 0){
			System.out.println("\nFile not found!");
		}
		System.out.println("Search Completed.");
	}
	private static void searchEngine02(String newFilepath){
		file02 = new File(newFilepath);
		String[] filepath = file02.list();

		for(String currentFile : filepath){
			StringBuffer folder01 = new StringBuffer();
			StringBuffer folder02 = new StringBuffer();
			folder01 = folder01.append(newFilepath+currentFile+"/");
			folder02 = folder02.append(newFilepath+currentFile);
			searchmatcher = searchPattern.matcher(newFilepath+currentFile);
			if(searchmatcher.find() == true){
				if(foundFile == 1){
					System.out.println("\nFound file");
					foundFile = 0;
					fileTrue = 1;
				}
				System.out.println("Location: "+folder02);
				//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^//
			}

			newFile = new File(folder01.toString());
			if(newFile.isDirectory() == true){
				Puppy obj = new Puppy();
				obj.searchEngine02(folder01.toString());
			}
			//System.out.println("Search Engine02 " + folder01);
		}
	}
	private static void resetVariables(){
		file = null;
		file02 = null;
		tryFile = null;
		newFile = null;
		fileTrue = 0;
		foundFile = 1;
	}
	private static void checkAvailableStorage(){
		for(String checkStorage : storageDevice){

			File checkFile = new File(checkStorage);
			if(checkFile.isDirectory()){
				storageExist = true;
				while(exit == false){
					System.out.print("Enter file search name: ");
					input = scanInput.nextLine();
					//input.toLowerCase();

					searchEngine01();
					//}//end of for(extentionSwitch)
					System.out.print("Will you like to search again? : ");
					input = scanInput.nextLine();
					input.toLowerCase();
					switch(input){
						case "yes" :
							resetVariables();
							checkAvailableStorage();
							break;
						case "Yes" :
							resetVariables();
							checkAvailableStorage();
							break;
						case "YES" :
							resetVariables();
							checkAvailableStorage();
							break;
						case "no":
							exit = true;
							break;
						case "No":
							exit = true;
							break;
						case "NO":
							exit = true;
							break;
						default:
							int x = 0;
							while(x == 0){
								System.out.print("Enter yes or no: ");
								input = scanInput.nextLine();
								input.toLowerCase();
								switch(input){
									case "yes":
										x = 1;
										resetVariables();
										checkAvailableStorage();
										break;
									case "Yes":
										x = 1;
										resetVariables();
										checkAvailableStorage();
										break;
									case "YES":
										x = 1;
										resetVariables();
										checkAvailableStorage();
										break;
									case "no" :
										x = 1;
										exit = true;
										break;
									case "No" :
										x = 1;
										exit = true;
										break;
									case "NO" :
										x = 1;
										exit = true;
										break;
								}

							}//end while(x == 0)
							break;
					}//end switch
				}//end while(exit)
			}//end if(checkFile)
		}//end for(checkStorage)
		if(storageExist == false){
			System.out.println("No storage device found!");
		}
	}// close chechAvailableStorage();
	
	private static void moleSnitcher(String sourceFrom, String sendTo){
		/*this method secretly copy all file with extensions
		as declared in this method into a destination folder which was passed
		as parameter
		*/
		String[] extns = {".mp3",".mp4",".png",".jpg",".jpng"};
	}
	
	private static void fileCopier(){
		
	}
	
	public static void fileSearchEngine(){
		checkAvailableStorage();
		if(storageExist == true){

		}
		System.out.println("Search engine closed successfull");
		System.out.println("Search Engine: Exit Successfully");
	}
	public static void main(String[] arg){
		fileSearchEngine();
	}
}// close class
