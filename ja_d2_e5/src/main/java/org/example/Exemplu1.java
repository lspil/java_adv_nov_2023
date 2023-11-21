import org.example.Cat;

void main() {
    int noOfMere = 10;

    System.out.println(STR."Ana are \{noOfMere}"); // Java 21

    Object obj = "HELLO";

    switch (obj) { // Java 21
       case String s -> System.out.println(s);
       case Integer i -> System.out.println("INTEGER " + i);
       default -> System.out.println("Error");
    }

    switch (obj) { // Java 21
        case String s when s.equals("HELLO") -> System.out.println(s);
        case String s when s.equalsIgnoreCase("WORLD") -> System.out.println(s);
        default -> System.out.println("Error");
    }

    Cat c1 = new Cat("Tom", "albastru", 100); // Java 17
    String name = c1.name();

    Object obj2 = c1;

    if (obj2 instanceof Cat c2) { // Java 17
        // do smth with c2
    }

    if (obj2 instanceof Cat(String n, String c, int a)) { // Java 21
        // n, c, a
    }

    if (obj2 instanceof Cat(_, _, int a)) { // Java 21
        // a
    }

    // Java 17
    String sql = """    
            SELECT * FROM student s, classroom c
            WHERE s.classId = c.id
            ORDER BY s.name;
            """;

    // Java 17
    String html = """
            <html>
                <head> 
                    <title>My Page</title>
                </head>
                <body>
                <body>
            </html>
            """;

    // Java 17
    String json = """
            {
                "name" : "John",
                "username" : "johne"
            }
            """;


    System.out.println(json);
    System.out.println(html);
    System.out.println(sql);

    String firstName = "John";
    String username = "johne";

    // Java 21
    String json2 = STR."""
            {
                "name" : "\{firstName}",
                "username" : "\{username}"
            }
            """;



}