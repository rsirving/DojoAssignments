using System;

namespace fundamentals_i
{
    class Program
    {
        static void Main(string[] args)
        {
            // 1.
            // for (int i = 1; i < 256; i++){
            //     Console.WriteLine(i);
            // }
            // 2.
            // for (int x = 1; x < 101; x++){
            //     if (x % 3 == 0 ^ x % 5 == 0){
            //         Console.WriteLine(x);
            //     }
            // }
            // 3. 
            // for (int y = 1; y < 101; y++){
            //     if (y % 3 == 0 && y % 5 == 0){
            //         Console.WriteLine("FizzBuzz");
            //     } else if (y % 3 == 0) {
            //         Console.WriteLine("Fizz");
            //     } else if (y % 5 == 0) {
            //         Console.WriteLine("Buzz");
            //     }
            // }
            // 5.
            Random rand = new Random();
            for (int y1 = 0; y1 < 10; y1++){
                int input = rand.Next(1, 100);
                if (input % 3 == 0 && input % 5 == 0){
                    Console.WriteLine("FizzBuzz");
                } else if (input % 3 == 0) {
                    Console.WriteLine("Fizz");
                } else if (input % 5 == 0) {
                    Console.WriteLine("Buzz");
                }
                Console.WriteLine(input);
            }
        }
    }
}
