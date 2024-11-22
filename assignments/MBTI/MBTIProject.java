import java.util.Scanner;
import java.util.Arrays;

public class MBTIProject {
  static int question = 0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String personality = "";
		String personalityA = "";
		
		int[] responseA = new int[4];
		int[] responseB = new int[4];
		
		String[] answer = new String[4];
		String[] storage = new String[20];
		
		

		String[][] questions = {
		  {"A. Expend energy, enjoy groups", "\tB. conserve energy, enjoy one on one\n"},

		  {"A. Interpret literally", "\tB. look for meaning and possibilities\n"},

		  {"A. Logical, thinking, questioning", "\tB. emphathetic, feeling, accomodating\n"},

		  {"A. organize, orderly", "\tB. flexible, adaptable\n"},

		  {"A. more outgoing, think out loud", "\tB. more reserved, think to yourself\n"},

		  {"A. Practical, realistic, experimental", "\tB. imaginative, innovative, theoretical"},

		  {"A. candid, straight forward, frank", "\tB. tactful, kind, encouraging"},

		  {"A. Plan, schedule", "\tB. unplanned, spontaneous"},

		  {"A. seek many tasks, public activities, interaction with others", "\tB. seek private, solitary activities with quiet to concentrate"},

		  {"A. standard, usual, conventional", "\tB. different, novel, unique"},

		  {"A. firm, tend to criticize, hold the line", "\tB. gentle, tend to appreciate, conciliate"},

		  {"A. regulated, structured", "\tB. easygoing, \" live \" and \"let live\""},

		  {"A. external, communicative, express yourself", "\tB. internal, reticent, keep to yourself"},

		  {"A. focus on here-and-now", "\tB. look to the future, global perspective, \"big pivyure\""},

		  {"A. tough-minded, just", "\tB. tender-hearted, merciful"},

		  {"A. preparation, plan ahead", "\tB. go with the flow, adapt as you go"},

		  {"A. active, initiate", "\tB. reflective, deliberate"},

		  {"A. facts, things, \"what is\"", "\tB. ideas, dreams, \"what could be,\" philosophical"},

		  {"A. matter of fact, issue oriented", "\tB. sensitive, people oriented, compassionate"},

		  {"A. control, govern", "\tB. latitude, freedom"}

		};


		
		System.out.print("\033[H\033[2J"); 
    System.out.flush();
    
		System.out.print("What is your name:\n> ");
		String username = scan.nextLine();
		
		System.out.print("\033[H\033[2J"); 
    System.out.flush();
    
		for (int section = 0; section < 4; section++) {

			 for (question = section; question < questions.length; question += 4) {

   		 	System.out.print(questions[question][0]);
   		 	System.out.print(questions[question][1]);

      	System.out.print("\nSelect A/B \n> ");
        String response = scan.nextLine();
        
        System.out.print("\033[H\033[2J"); 
        System.out.flush();

        checkResponse(response);
			        
			  System.out.println();
			}
		}


		answer[0] = getResponseEI(responseA[0], responseB[0]);
		answer[1] = getResponseSN(responseA[1], responseB[1]);
		answer[2] = getResponseTF(responseA[2], responseB[2]);
		answer[3] = getResponseJP(responseA[3], responseB[3]);


		System.out.print("Test results successfully recorded. Do you want to see results? y/n:\n> ");
		String reply = scan.nextLine();
		
		if (reply.equalsIgnoreCase("y")) {
			System.out.printf("Hello %s, Your selections are: \n", username);

			for (String quest : storage) {
				if (quest != null) {
					System.out.printf("\t%s%n",quest.trim());
				}
			}
			for (String characters : answer) {
				personality += characters + " ";
				personalityA += characters;
			}
			System.out.printf("\nYour personality type: %s%n", personality);
			
			getPersonalityResult(personalityA);
		}

		else if (reply.equalsIgnoreCase("n")) {
			System.out.println("\nExiting program... Bye 😊");
		}
		
		else {
			System.out.println("\nNothing selected, Bye 😡");
		}
		
	}

	public static void checkResponse(String response){	  
	  
	  if (response.equalsIgnoreCase("A") || response.equalsIgnoreCase("B")) {
      if (response.equalsIgnoreCase("A")) {
        storage[question] = questions[question][0];
        responseA[section]++;
      } else {
        storage[question] = questions[question][1];
        responseB[section]++;
      }
				
		} else {
        System.out.println("Error: Expected A or B as response, please try again.");
        question -= 4;
	  }
	}
	
	public static String getResponseEI(int a, int b) {
		return (a > b) ? "E" : "I";		

	}


	public static String getResponseSN(int a, int b) {
		return (a > b) ? "S" : "N";
		
	}


	public static String getResponseTF(int a, int b) {
		return (a > b) ? "T" : "F";
	}


	public static String getResponseJP(int a, int b) {
		return (a > b) ? "J" : "P";
	}

	public static void getPersonalityResult(String personality) {
		switch (personality) {
			case "ISTJ"-> { 
			System.out.println("""
			ISTJ (Introverted, Sensing, Thinking, Judging)
			  Individuals with ISTJ personality types are known for their practicality organization, and reliability. They value tradition and order, and are often drawn to careers in law enforcement, finance, and government. ISTJs are detail-oriented and analytical, making them excellent problem-solvers. They are also loyal and committed to their loved ones, and value long-term relationships. However, ISTJs may struggle with adaptability and spontaneity, preferring routine and structure""");
			}


			case "ISFJ" -> {
			System.out.println("""
			ISFJ (Introverted, Sensing, Feeling, Judging)
			  ISFJs are compassionate and supportive individuals who prioritize the needs of others. They are meticulous and organized, with a strong attention to detail. ISFJs excel in careers that involve helping others, such as teaching, nursing, and social work. They value harmony and stability, and are often peacemakers in their personal and professional lives. However, ISFJs may struggle with assertiveness and 							boundary-setting, and may need to work on expressing their own needs and desires.
			""");
			}


			case "INFJ" -> {
			System.out.println("""
			
			INFJ (Introverted, Intuitive, Feeling, Judging)
			  INFJs are visionary and empathetic individuals who are driven to make a positive difference in the world. They are creative and innovative, with a strong connection to their intuition. INFJs excel in careers that involve helping others, such as counseling, teaching, and social justice. They value authenticity and integrity, and are often drawn to artistic or humanitarian pursuits. However, INFJs may struggle with burnout and self-				care, and may need to prioritize their own needs.
			""");
		        }

			case "INTJ" -> {
			System.out.println("""
			INTJ (Introverted, Intuitive, Thinking, Judging)
			  INTJs are strategic and analytical individuals who are driven to achieve greatness. They are independent and self-motivated, with a strong desire for knowledge and understanding. INTJs excel in careers that involve innovation and problem-solving, such as science, technology, and entrepreneurship. They value efficiency and effectiveness, and are often drawn to leadership roles. However, INTJs may struggle with interpersonal 			relationships and emotional intelligence.
			""");
			}


			case "ISTP" -> {
			System.out.println("""
			ISTP (Introverted, Sensing, Thinking, Perceiving)
			  ISTPs are resourceful and adaptable individuals who thrive in dynamic environments. They are practical and hands-on, with a strong connection to 			the physical world. ISTPs excel in careers that involve troubleshooting and problem-solving, such as engineering, technology, and emergency 				response. They value freedom and flexibility, and are often drawn to unconventional lifestyles.
			""");
		        }


			case "ISFP" -> {
			System.out.println("""
			ISFP (Introverted, Sensing, Feeling, Perceiving)
			  ISFPs are artistic and compassionate individuals who value creativity and self-expression. They are gentle and empathetic, with a strong 				connection to the emotional realm. ISFPs excel in careers that involve art, music, and performance. They value authenticity and individuality, and 			are often drawn to alternative lifestyles
			""");
			}


			case "INFP" -> {
			System.out.println("""
			INFP (Introverted, Intuitive, Feeling, Perceiving)
			  INFPs are idealistic and creative individuals who are driven to make a positive difference in the world. They are empathetic and compassionate, 			with a strong connection to their intuition. INFPs excel in careers that involve writing, teaching, and social justice. They value authenticity 			and integrity, and are often drawn to artistic or humanitarian pursuits.
			""");
			}


			case "INTP" -> {
			System.out.println("""
			INTP (Introverted, Intuitive, Thinking, Perceiving)
			  INTPs are innovative and analytical individuals who are driven to understand the world around them. They are independent and self-motivated, with 			a strong desire for knowledge and understanding. INTPs excel in careers that involve science, technology, and philosophy. They value intellectual 			freedom and curiosity.
			""");
			}


			case "ESTP" -> {
			System.out.println("""
			ESTP (Extraverted, Sensing, Thinking, Perceiving)
			  ESTPs are adventurous and action-oriented individuals who thrive in dynamic environments. They are practical and hands-on, with a strong 				connection to the physical world. ESTPs excel in careers that involve sales, marketing, and entrepreneurship. They value freedom and flexibility
			""");
			}


			case "ESFP" -> {
			System.out.println("""
			ESFP (Extraverted, Sensing, Feeling, Perceiving)
			  ESFPs are spontaneous and enthusiastic individuals who value creativity and self-expression. They are social and outgoing, with a strong 				connection to the emotional realm. ESFPs excel in careers that involve entertainment, teaching, and event planning.
			""");
			}


			case "ENFP" -> {
			System.out.println("""
			  ENFPs are charismatic and imaginative individuals who inspire others with their creativity and passion. They are empathetic and compassionate, 				with a strong connection to their intuition. ENFPs excel in careers that involve writing, teaching, and social justice.
			""");
			}


			case "ENTP" -> {
			System.out.println("""
			ENTP (Extraverted, Intuitive, Thinking, Perceiving)
			  ENTPs are entrepreneurial and innovative individuals who are driven to revolutionize the status quo. They are independent and self-motivated, with 			a strong desire for knowledge and understanding. ENTPs excel in careers
			""");
			}


			case "ESTJ" -> {
			System.out.println("""
			ESTJ (Extraverted, Sensing, Thinking, Judging)
			  As an ESTJ, you possess a unique blend of assertive leadership and practical expertise, making you a respected authority in your field. Your 				ability to bring order and stability to any organization is unparalleled, and your decisiveness and confidence inspire others to follow your lead.
			Your strong sense of responsibility and duty drives you to take charge and ensure that tasks are completed efficiently. You value tradition and 			structure, and your attention to detail is exceptional. With your natural charisma and leadership abilities, you excel in roles that require 				strategic planning and execution.
			""");
			}


			case "ESFJ" -> {
			System.out.println("""
			ESFJ (Extraverted, Sensing, Feeling, Judging)
			  As an ESFJ, you are a beloved community builder, renowned for your warmth and exceptional organizational skills. Your talent for bringing people 			together and fostering meaningful connections creates a positive impact on those around you.
			Your empathy and support nurture growth, and your dedication to helping others is unwavering. You excel in roles that involve teamwork, mediation, 			and conflict resolution. Your attention to detail and ability to multitask make you an invaluable asset in any organization.
			""");
			}


			case "ENFJ" -> {
			System.out.println("""
			ENFJ (Extraverted, Intuitive, Feeling, Judging)
			  As an ENFJ, you possess a rare combination of charismatic leadership and empathetic understanding. Your ability to inspire others to grow and 				develop is unparalleled, and your strategic vision motivates and guides those around you.
			Your unique blend of intuition and compassion enables you to navigate complex emotional landscapes with ease. You excel in roles that require 				coaching, mentoring, or counseling, and your natural charisma makes you a compelling public speaker.
			Value your exceptional interpersonal skills, and continue to harness your transformative power to make a positive impact.
			""");
			}


			case "ENTJ" -> {
			System.out.println("""
			ENTJ (Extraverted, Intuitive, Thinking, Judging)
			  As an ENTJ, you embody the spirit of confident leadership and strategic vision. Your entrepreneurial drive and innovative thinking propel you 				toward greatness, and your logical analysis uncovers innovative solutions.
			Your trailblazing nature and willingness to take calculated risks inspire others to follow your lead. You thrive in challenging environments, 				where your quick thinking and adaptability enable you to stay ahead of the curve.
			""");
			}

			default -> {
			System.out.println("Error: Invalid input.");
			}

			
		}
	}

	
}


