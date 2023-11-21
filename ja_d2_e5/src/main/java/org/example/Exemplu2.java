void main() {

    int x = 10;

    switch (x) {
        case 10: System.out.println(10); break;

        case 20:
        case 30:
        case 40:
            System.out.println(40); break;
    }

    // Java 17

    switch (x) {
        case 10: System.out.println(10); break;

        case 20, 30, 40:
            System.out.println(40); break;
    }

    switch (x) {
        case 10 -> System.out.println(10);

        case 20, 30, 40 ->
            System.out.println(40);
    }

    int y1 = switch (x) {
        case 10 -> 100;
        case 20, 30, 40 -> 200;
        default -> 0;
    };

    int y2 = switch (x) {
        case 10 -> 100;
        case 20, 30, 40 -> 200;
        default -> throw new RuntimeException();
    };
}
