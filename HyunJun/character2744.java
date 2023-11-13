package HyunJun.character;

import java.util.Scanner;

public class character2744 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

//        String result =
//                    Arrays.stream(input.split("\\s+"))
//                            .map(st -> Character.isUpperCase(st.charAt(0)) ? st.toLowerCase() : st.toUpperCase())
//                            .collect(Collectors.joining());

        StringBuilder result = new StringBuilder();

        input.chars()
                .map(i -> Character.isLowerCase(i) ? i - 32 :  i + 32 )
                .forEach(i -> result.append((char)i));

        System.out.println(result.toString());
        sc.close();

    }


}

