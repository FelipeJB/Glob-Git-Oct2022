import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int option;
        System.out.println("Hi Sis, tell me: Which animal do you like to know?");
        System.out.println("1. Lion \n2. Cricket \n3. Panther \n4. Platypus \n5. Otter \n6. Jellyfish");
        option = scan.nextInt();

        switch(option)
        {
            case 1:
                System.out.println("Name: Lion \nSpecie: Panthera Leo \nFeatures: Big, carnivorous, mammal");
                System.out.println("What she liked most about it: It's like a kitty");
                break;

            case 2:
                System.out.println("Name: Cricket \nSpecie: Stipnochlora Couloniana \nFeatures: Green, small, Jump very high");
                System.out.println("What she liked most about it: It seems like Mulan's cricket");
                break;

            case 3:
                System.out.println("Name: Panther \nSpecie: Panthera Pardus \nFeatures: Black, strong, big eyes");
                System.out.println("What she liked most about it: Another kitty, but black and cute.");
                break;

            case 4:
                System.out.println("Name: Platypus \nSpecie: Ornithorhynchus Anatinus \nFeatures: Poisonous, can swim, mammal");
                System.out.println("What she liked most about it: It's quite interesting, like Perry");
                break;

            case 5:
                System.out.println("Name: Otter \nSpecie: Lutra Lutra \nFeatures: Large, big claws, they always be with their partner");
                System.out.println("What she liked most about it: They are very cute.");
                break;

            case 6:
                System.out.println("Name: Jellyfish \nSpecie: Rhizostoma pulmo \nFeatures: Filmy, large tentacles, small");
                System.out.println("What she liked most about it: They seems very delicate");
                break;

            default:
                System.out.println("Sorry Sis, I don't have any information about that animal");
                break;
        }

    }
}