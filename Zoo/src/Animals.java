public class Animals {

    String name;
    int age;
    int heightInFeet;
    String food;
    String color;

    public void animalCharacteristics (int species){
      switch (species){
          case 1:
              name = "Cris";
              age = 36;
              heightInFeet = 5;
              food = "Watermelon";
              color = "Grey";
              System.out.println("The name of the Hippopotamus is: " + name
                      + "\n His age is: " + age
                      + "\n His height is: " + heightInFeet
                      + "\n He eats: " + food
                      + "\n He is: " + color );
              break;
              case 2:
              name = "Melman";
              age = 15;
              heightInFeet = 12;
              food = "Tree leaves";
              color = "Yellow with brown spots";
                  System.out.println("The name of the Giraffe is: " + name
                          + "\n His age is: " + age
                          + "\n His height is: " + heightInFeet
                          + "\n He eats: " + food
                          + "\n He is: " + color );
              break;
              case 3:
              name = "Jewels";
              age = 4;
              heightInFeet = 3;
              food = "Meat";
              color = "Orange with black stripes";
                  System.out.println("The name of the Tiger is: " + name
                          + "\n Her age is: " + age
                          + "\n Her height is: " + heightInFeet
                          + "\n She eats: " + food
                          + "\n She is: " + color );
              break;
              case 4:
              name = "Raya";
              age = 1;
              heightInFeet = 2;
              food = "Bamboo Sticks";
              color = "Black and White";
                  System.out.println("The name of the Panda is: " + name
                          + "\n Her age is: " + age
                          + "\n Her height is: " + heightInFeet
                          + "\n She eats: " + food
                          + "\n She is: " + color );
              break;
      }
          }
        }
