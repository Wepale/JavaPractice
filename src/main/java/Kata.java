import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Kata {
    /*  In this little assignment you are given a string of space separated numbers,
    and have to return the highest and lowest number
    Example:
    HighAndLow("1 2 3 4 5")  // return "5 1"
    HighAndLow("1 2 -3 4 5") // return "5 -3"
    HighAndLow("1 9 3 4 -5") // return "9 -5"
    Notes:
    - All numbers are valid Int32, no need to validate them.
    - There will always be at least one number in the input string.
    - Output string must be two numbers separated by a single space, and highest number is first.
 */
    public static String HighAndLow(String numbers) {
        Supplier<IntStream> suplier = () -> Stream.of(numbers.split(" ")).mapToInt(Integer::valueOf);
        Integer lowest = suplier.get().min().orElse(0);
        Integer higuest = suplier.get().max().orElse(0);
        return String.valueOf(higuest) + " " + String.valueOf(lowest);
    }

    /*
            Define a function that takes an integer argument and returns logical value true or false depending
            if the integer is a prime.
            Per Wikipedia, a prime number (or a prime) is a natural number greater than 1
            that has no positive divisors other than 1 and itself.
            Example:
            is_prime(1)  //false
            is_prime(2)  //true
            is_prime(-1) // false
            Assumptions
            -You can assume you will be given an integer input.
            -You can not assume that the integer will be only positive. You may be given negative numbers as well (or 0).
            -There are no fancy optimizations required, but still the most trivial solutions might time out.
                Try to find a solution which does not loop all the way up to n.
     */
    public static boolean isPrime(int num) {
        if (num % 2 == 0 && num != 2) return false;
        Integer i = 3;
        while (i <= num/2) {
            if(num % i == 0) return false;
            i = i + 2;
        }
        return !(num <= 1);
    }
    /*
    An isogram is a word that has no repeating letters, consecutive or non-consecutive.
    Implement a function that determines whether a string that contains only letters is an isogram.
     Assume the empty string is an isogram. Ignore letter case.
    Example:
    isIsogram "Dermatoglyphics" == true
    isIsogram "moose" == false
    isIsogram "aba" == false
     */
    public static boolean  isIsogram(String str) {
        int[] x = str.toLowerCase().chars().sorted().toArray();
        for(int i = 1; i < x.length; i++) {
            if(x[i] == x[i-1]){
                return false;
            }
        }
        return true;
    }

    public static boolean  isIsogram2(String str) {
        return str.length() == str.toLowerCase().chars().distinct().count();
    }

    /*
    Enough is enough!
Alice and Bob were on a holiday. Both of them took many pictures of the places they've been, and now
they want to show Charlie their entire collection. However, Charlie doesn't like this sessions,
since the motive usually repeats. He isn't fond of seeing the Eiffel tower 40 times.
He tells them that he will only sit during the session if they show the same motive at most N times.
Luckily, Alice and Bob are able to encode the motive as a number. Can you help them to remove numbers such
that their list contains each number only up to N times, without changing the order?
Task:
Given a list lst and a number N, create a new list that contains each number of lst at most N times without reordering.
For example if N = 2, and the input is [1,2,3,1,2,1,2,3], you take [1,2,3,1,2], drop the next [1,2] since this would
lead to 1 and 2 being in the result 3 times, and then take 3, which leads to [1,2,3,1,2,3].
Example:
EnoughIsEnough.deleteNth(new int[] {20,37,20,21}, 1) // return [20,37,21]
EnoughIsEnough.deleteNth(new int[] {1,1,3,3,7,2,2,2,2}, 3) // return [1, 1, 3, 3, 7, 2, 2, 2]
     */

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        List<Integer> result = new LinkedList<>();
        Arrays.stream(elements).forEach(number -> {
            if(result.stream().filter(num -> num == number).count() < maxOccurrences){
                result.add(number);
            }
        });
        return result.stream().mapToInt(num -> num).toArray();
    }

    /*
    The new "Avengers" movie has just been released! There are a lot of people at the cinema box office standing in a huge line.
    Each of them has a single 100, 50 or 25 dollars bill. An "Avengers" ticket costs 25 dollars.
    Vasya is currently working as a clerk. He wants to sell a ticket to every single person in this line.
    Can Vasya sell a ticket to each person and give the change if he initially has no money and sells the tickets strictly in the
    order people follow in the line?
    Return YES, if Vasya can sell a ticket to each person and give the change with the bills he has at hand at that moment.
    Otherwise return NO.
Examples:
Line.Tickets(new int[] {25, 25, 50}) // => YES
Line.Tickets(new int[]{25, 100}) // => NO. Vasya will not have enough money to give change to 100 dollars
Line.Tickets(new int[] {25, 25, 50, 50, 100}) // => NO. Vasya will not have the right bills to give 75 dollars of change (you can't make two bills of 25 from one of 50)
     */
    public static String Tickets(int[] peopleInLine)
    {
        Map<Integer, Integer> bills = new LinkedHashMap<Integer, Integer>(){{
            put(25, 0);
            put(50, 0);
            put(100, 0);
        }};

        return Arrays.stream(peopleInLine).filter(bill -> {
            if (bill == 25) {
                bills.replace(25, bills.get(25) + 1);
                return true;
            } else if (bill == 50 && bills.get(25) > 0) {
                bills.replace(25, bills.get(25) - 1);
                bills.replace(50, bills.get(50) + 1);
                return true;
            } else if (bill == 100 && bills.get(25) > 0 && bills.get(50) > 0) {
                bills.replace(25, bills.get(25) - 1);
                bills.replace(50, bills.get(50) - 1);
                bills.replace(100, bills.get(100) + 1);
                return true;
            } else {
                return false;
            }
        }).count() == peopleInLine.length ? "Yes" : "NO";

    }

    /*
        We recibe an array of number. Each number represent a shock. We need a pair of shock to be able to sell it.
        ¿How many socks we can sell?
     */

    public static Integer sockMerchant(int[]ar){
        Map<Integer, Integer> results = new HashMap<>();
        Arrays.stream(ar).forEach(sock -> {
            if(results.containsKey(sock)){
                results.replace(sock, results.get(sock) + 1);
            } else {
                results.put(sock, 1);
            }
        });
        return results.values()
                .stream()
                .filter(value -> value > 1)
                .map(val -> val/2)
                .reduce((a,b) -> a + b)
                .orElse(0);
    }

    /*
    In this kata, you must create a digital root function.
A digital root is the recursive sum of all the digits in a number.
Given n, take the sum of the digits of n. If that value has more than one digit,
continue reducing in this way until a single-digit number is produced.
This is only applicable to the natural numbers.
Here's how it works:
digital_root(16)
=> 1 + 6
=> 7
digital_root(942)
=> 9 + 4 + 2
=> 15 ...
=> 1 + 5
=> 6
digital_root(132189)
=> 1 + 3 + 2 + 1 + 8 + 9
=> 24 ...
=> 2 + 4
=> 6
digital_root(493193)
=> 4 + 9 + 3 + 1 + 9 + 3
=> 29 ...
=> 2 + 9
=> 11 ...
=> 1 + 1
=> 2
     */

    public static Integer digitalRoot(Integer num) {
        return num < 10
                ? num
                : digitalRoot(Arrays.stream(String.valueOf(num).split("")).mapToInt(Integer::valueOf).sum());
    }


    public static String[] uniqueNames(String[] names1, String[] names2) {

        String[] both = Stream.concat(Arrays.stream(names1), Arrays.stream(names2))
                .toArray(String[]::new);

        Set<String> mySet = new HashSet<>(Arrays.asList(both));

        return mySet.toArray(new String[0]);
    }
}


