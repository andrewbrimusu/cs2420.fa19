public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> cities = new LinkedList<>();

        cities.add("Logan");
        cities.add("Nibley");
        cities.add("Paradise");
        cities.add("Newton");

        cities.display();

        LinkedList<String> cities2 = new LinkedList<>();

        cities2.insert("Logan");
        cities2.insert("Nibley");
        cities2.insert("Paradise");
        cities2.insert("Newton");

        cities2.display();

        cities2.insertRec(cities2.getHead(),"Hyde Park");
        cities2.display();
        
        cities2.remove("Logan");
        cities2.display();

        if (cities2.find("Newton")) {
            System.out.println("found it");
        }
        else {
            System.out.println("did not find it");
        }

        if (cities2.findRecur(cities2.getHead(), "Newton")) {
            System.out.println("found it");
        }
        else {
            System.out.println("did not find it");
        }
        
        cities2.add("abc");
        cities2.display();
    }
}
