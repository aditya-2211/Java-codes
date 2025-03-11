import java.util.*;



public class LibraryManagementSystem
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter how many users: ");
		int size = sc.nextInt();
		User u[] = new User[size];
		System.out.println("Enter "+size+" user details: ");
		for(int i=0;i<u.length;i++)
		{
			u[i] = new User();
			System.out.print("Enter user id: ");
			int userId = sc.nextInt();
			u[i].setUserID(userId);
			
			System.out.print("Enter user name: ");
			sc.nextLine();
			String userName = sc.nextLine();
			u[i].setUserName(userName);
			
			System.out.print("Enter user email: ");
			String userEmail = sc.nextLine();
			u[i].setUserEmail(userEmail);
			
			System.out.print("Enter user contact: ");
			String userContact = sc.nextLine();
			u[i].setUserContact(userContact);
			
			
			System.out.println("\t1. Libraian");
			System.out.println("\t2. Student");
			System.out.print("Enter user type:" );
			int userType = sc.nextInt();
			switch(userType)
			{
				case 1: //Libraian
						String librarian = "librarian";
						u[i].setUserType(librarian);
				break;
				case 2: //Student
						String student = "student";
						u[i].setUserType(student);
				break;
			}			
			
			System.out.println();
		}
		
		do
		{
			System.out.println("1. Librarian");
			System.out.println("2. Student");
			System.out.println("3. Exit");
			System.out.print("Enter your choice: ");
			int choiceLibStud = sc.nextInt();
			
			switch(choiceLibStud)
			{
				case 1: //Librarian
						System.out.print("Enter username(email): ");
						sc.nextLine();
						String username = sc.nextLine();
						
						System.out.print("Enter password(contact):" );
						String password = sc.nextLine();
						
						String userType = "librarian";
						UserValidate uv1 = new UserValidate(username, password, userType, u);
						boolean validate = uv1.validateUser();
						if(validate)
						{
							System.out.println("Valid user");
							
							System.out.print("Enter student count:" );
							int student_count = sc.nextInt();
							Student s[] = new Student[student_count];
							
							System.out.print("Enter Book count: ");
							int bookCount = sc.nextInt();
							Book b[] = new Book[bookCount];
							
							do
							{
								System.out.println("1. Add new student list");
								System.out.println("2. Add new books");
								System.out.println("3. View all Student");
								System.out.println("4. Search student by name or email");
								System.out.println("5. View all books");
								System.out.println("6. Search book by name");
								System.out.println("7. View issued book by student");
								System.out.println("8. View student who issue minimim single book");
								System.out.println("9. Show the total number of book count");
								System.out.println("10. Show tital available books");
								System.out.println("11. Show issued book count");
								System.out.println("12. Exit");
								System.out.println("Enter your choice: ");
								int ch = sc.nextInt();
								switch(ch)
								{
									case 1: //students
											for(int i=0;i<s.length;i++)
											{
												s[i] = new Student();
												
												System.out.print("Enter Department name: ");
												String deptName = sc.nextLine();
												s[i].setDeptName(deptName);
												
												System.out.print("Enter year:" );
												int year = sc.nextInt();
												s[i].setYear(year);
												
												s[i].setBooks(b);
												System.out.println(); //blank line
											}
									break;
									case 2: //Add books
											
											for(int i=0;i<b.length;i++)
											{
												b[i] = new Book();
												System.out.print("Enter book id:" );
												int bid = sc.nextInt();
												b[i].setBookId(bid);
												
												System.out.print("Enter name: ");
												sc.nextLine();
												String bookName = sc.nextLine();
												b[i].setBookName(bookName);
												
												System.out.print("Enter book author name: ");
												String author = sc.nextLine();
												b[i].setBookAuthor(author);
												
												System.out.print("Enter book subject: ");
												String bookSubject = sc.nextLine();
												b[i].setBookSubject(bookSubject);
												
												System.out.print("Enter book isbn: ");
												int isbn = sc.nextInt();
												b[i].setBookIsbn(isbn);
												
												System.out.print("Enter status(true/false): ");
												boolean status = sc.nextBoolean();
												b[i].setBookStatus(status);
												
												System.out.println(); //blank line
											}
									break;
									case 3: //view all students
											for(int i=0;i<s.length;i++)
											{
												System.out.println(s[i].getDeptName()+" "+s[i].getYear());
												System.out.print("Book details");
												for(int j=0;j<s[i].getBooks().length;j++)
													System.out.println(b[j].getBoohId());
											}
									break;
									case 4: //student search by name or email
											System.out.print("Enter name or email: ");
											sc.nextLine();
											String studentSearch = sc.nextLine();
											
											for(int i=0;i<u.length;i++)
											{
												if(u[i].getUserType().equals(studentSearch))
												{
													System.out.println(u[i].getUserId()+"\t"+u[i].getUserName()+"\t"+u[i].getUserEmail()+"\t"+u[i].getUserContact());
												}
											}
											
									break;
									case 5:
											System.out.println("All books details");
											for(int i=0;i<b.length;i++)
												System.out.println(b[i].getBoohId()+"\t"+b[i].getBookName()+"\t"+b[i].getBookAuthor()+"\t"+b[i].getBookSubject()+"\t"+b[i].getBookIsbn());
									break;
									case 6: //searcch book by name
											System.out.print("Enter book name: ");
											String bookname = sc.nextLine();
											
											for(int i=0;i<b.length;i++)
											{
												if(b[i].getBookName().equals(bookname))
													System.out.println(b[i].getBoohId()+"\t"+b[i].getBookName()+"\t"+b[i].getBookAuthor()+"\t"+b[i].getBookSubject()+"\t"+b[i].getBookIsbn());
											}
									break;
									case 7:
									break;
									case 8:
									break;
									case 9:
											for(int i=0;i<b.length;i++)
											{
												if(!b[i].getBookStatus())
													System.out.println(b[i].getBoohId()+"\t"+b[i].getBookName()+"\t"+b[i].getBookAuthor()+"\t"+b[i].getBookSubject()+"\t"+b[i].getBookIsbn());
											}
									break;
									case 10:
											int count = 0;
											for(int i=0;i<b.length;i++)
											{
												if(!b[i].getBookStatus())
													count++;
												
											}
											System.out.print("Books available in library: "+count);
									break;
									case 11:
									break;
									case 12: System.exit(0);
									
								}
							}while(true);
						}
						else
						{
							System.out.println("User not found");
						}
				break;
				
				
				case 2: //Student
						System.out.print("Enter username(email): ");
						sc.nextLine();
						username = sc.nextLine();
						
						System.out.print("Enter password(contact):" );
						password = sc.nextLine();
						
						userType = "student";
						UserValidate uv2 = new UserValidate(username, password, userType, u);
						validate = uv2.validateUser();
						if(validate)
						{
							System.out.println("Valid user");
							
							
						}
						else
						{
							System.out.println("User not found");
						}
				break;
				
				case 3: //exit from whole prject
						System.exit(0);
			}
		}while(true);
	}
}