val greetStrings = new Array[String](3)
greetStrings(0)= "Hello"
greetStrings(1) = ", "
greetStrings(2) = "world!\n"
for (i <- (-1 + 1).to(2)) // just to show that we can do it more sophisticated
  print(greetStrings(i))