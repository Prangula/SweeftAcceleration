package com.example.sweeftacceleration.sweeft

import android.annotation.SuppressLint

fun main(){

   /*

   1. გვაქვს მთელი რიცხვების ჩამონათვალი სადაც ერთის გარდა ყველა რიცხვი მეორდება,
   იპოვეთ ის რიცხვი რომელიც არ მეორდება.int singleNumber(int[] nums)

   */

    val nums = intArrayOf(10,15,15,10,9,22,9)
    println("#1 არ მეორდება ციფრი : ${singleNumber(nums)}")

    /*

    2. გვაქვს 1,5,10,20 და 50 თეთრიანი მონეტები. დაწერეთ ფუნქცია,
    რომელსაც გადაეცემა თანხა (თეთრებში) და აბრუნებს მონეტების მინიმალურ რაოდენობას,
    რომლითაც შეგვიძლია ეს თანხა დავახურდაოთ.
       Int minSplit(Int amount);

     */

    val amount = 1
    println("#2 მინიმალური მონეტების რაოდენობაა : ${minSplit(amount)}")


   /*

   3. მოცემულია მასივი, რომელიც შედგება სიტყვებისგან(string).
   დაწერეთ ფუნქცია რომელსაც გადაეცემა ეს მასივი და აბრუნებს ყველაზე გრძელ თავსართს(prefix) რომელიც მეორდება ამ სიტყვებში.
   თუ არცერთი არ მეორდება აბრუნებს ცარიელ სტრინგს.მაგ:[“extract”,”exhale”, “excavate”] , პასუხი იქნება “ex”
    String longestPrefix(String[] array);

    */

    val array = arrayOf("exhale", "excavate", "extract")
    println("#3 ყველაზე გრძელი თავსართია : ${longestPrefix(array)}")



    /*

    4.მოცემულია ორი binary string a და b, დააბრუნეთ მათი ჯამი, როგორც binary string.
      მაგ: a = "1010" b = "1011" , მათი ჯამი იქნება "10101"

     */

    val a = "1010"
    val b = "1011"
    println("#4 ჯამი : ${addBinary(a,b)}")



    /*

    5. გვაქვს n სართულიანი კიბე, ერთ მოქმედებაში შეგვიძლია ავიდეთ 1 ან 2 საფეხურით.
    დაწერეთ ფუნქცია რომელიც დაითვლის n სართულზე ასვლის ვარიანტების რაოდენობას.
       Int countVariants(Int stearsCount);

     */

    val stairsCount = 4
    println("#5 $stairsCount კიბეზე ასასვლელად გვაქვს : ${countVariants(stairsCount)} ვარიანტი")


    /*

    6. დაწერეთ საკუთარი მონაცემთა სტრუქტურა, რომელიც საშუალებას მოგვცემს O(1) დროში წავშალოთ ელემენტი.

     */

    val dataStructure = DataStructureClass()

    dataStructure.insert(1)
    dataStructure.insert(22)
    dataStructure.insert(31)
    dataStructure.insert(17)
    dataStructure.insert(552)
    dataStructure.insert(32)




    println("#6 ელემენტები : ${dataStructure.list}")





}




// #1
fun singleNumber(nums:IntArray):Int{
   // ფუნქციაში ვიყენებთ XOR ოპერაციას, რათა დავაწყვილოთ ის რიცხვები, რომლებიც მეორდება მასივში და
   // დავაბრუნოთ მხოლოდ ისეთი რიცხვი, რომელიც უნიკალურია.

    var uniqueNumber = 0

    for(num in nums){

        uniqueNumber  =  uniqueNumber xor num
    }

    return  uniqueNumber

}

// #2
fun minSplit(amount: Int): Int {

    val coins = intArrayOf(50, 20, 10, 5, 1)

    // დარჩენილი თანხა
    var remainingAmount = amount

    // თვლის რამდენჯერ გამოვიყენეთ მონეტები
    var count = 0

    for (coin in coins) {

        //რამდენჯერ შეიძლება გამოვიყენოთ მონეტა
        val coinCount = remainingAmount / coin

        // დავუმატოტთ მთვლელს გამოყენებულ მონეტათა ჯამი
        count += coinCount

        remainingAmount = remainingAmount % coin
    }

    return count
}

// #3
fun longestPrefix(array: Array<String>): String {


    // ვიპოვოთ პირველი და ბოლო სიტყვა მასივში
    val firstWord = array[0]
    val lastWord = array[array.size - 1]

    // გავიგოთ პირველ და ბოლო სიტყვას შორის, რომელს აქვს უფრო პატარა სიგრძე
    val minLength = minOf(firstWord.length, lastWord.length)

    // შემოვიტანოთ ინდექსი, რათა დავთვალოთ რამდენი ასო გამეორდება
    var index = 0

    // დავითვალოთ ასოთა რაოდენობა, რომლებიც ემთხვევა ერთმანეთს
    while (index<minLength && firstWord[index] == lastWord[index]) {
        index++
    }

    // სტრინგად ვაბრუნებთ გამეორებულ ასოებს, ამ შემთხვევაში ex
    return firstWord.substring(0,index)

}

// #4
@SuppressLint("SuspiciousIndentation")
fun addBinary(a:String, b:String):String{

  // შემოგვაქვს ცვლადი sum, რომელსაც ვუტოლებთ a+b მნიშვნელობას ორობით სისტემაში.
  val sum = Integer.parseInt(a,2) + Integer.parseInt(b,2)

    // ვაბრუნებთ sum-ის მნიშვნელობას, ორობითი სისტემისთვის.
    return Integer.toBinaryString(sum)


}

// #5
fun countVariants(stepsCount:Int):Int{

    when(stepsCount){

        0 -> return 1

        1-> return 1

        // 0-ის და 1-ის გარდა ნებისმიერი სხვა რიცხვის შემთხვევაში ვიყენებთ რეკურსიას, რომელიც გამოითვლის ყველა ვარიანტს,
        // რომელიც n კიბეზე ასასვლელად არის საჭირო
        else -> return countVariants(stepsCount - 1) + countVariants(stepsCount - 2)

    }




}

//#6
//DataStructureClass ->












