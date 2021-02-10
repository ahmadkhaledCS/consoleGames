import java.io.File;
import java.util.Scanner;
public class myMain {
    public static void main(String[] args) throws Exception {
        String text;
        Scanner con= new Scanner(System.in);
        System.out.println("use w a s d for movement");
        System.out.println("chose level\n1)easy\n2)medium\n3)also medium lol");
        switch (con.nextInt())
        {
            case 1:text="lvl1.txt";break;
            case 2:text="lvl2.txt";break;
            case 3:text="lvl3.txt";break;
            default:
                System.out.println("wrong level entered so play easy because you cant read");
                text="lvl1.txt";
                break;
        }
        File lvl=new File(text);
        Scanner inp= new Scanner(lvl);
        int []pos={inp.nextInt(), inp.nextInt()};
        int []winPos={inp.nextInt(), inp.nextInt()};
        inp.nextLine();
        String [][]arr=new String[6][];
        for(int i=0;i<6;i++)
            arr[i]=inp.nextLine().split("");
        arr[pos[0]][pos[1]]="X";
        String dir;
        while(true)
        {
            dir=con.nextLine();
            play(arr,pos,dir);
            if(pos[0]==winPos[0]&&pos[1]==winPos[1])
            {
                System.out.println("you win");
                break;
            }
        }
    }
    public static void play(String[][]arr,int[]pos,String dir)
    {
        arr[pos[0]][pos[1]]=" ";
        switch (dir) {
            case "w":
                while (pos[0] > 0 && arr[pos[0] - 1][pos[1]].matches(" ")) {
                    if (arr[pos[0]][pos[1]].matches("#")) {
                        pos[0]++;
                        break;
                    }
                    pos[0]--;
                }
                break;
            case "s":
                while (pos[0] < arr.length - 1 && arr[pos[0] + 1][pos[1]].matches(" ")) {
                    if (arr[pos[0]][pos[1]].matches("#")) {
                        pos[0]--;
                        break;
                    }
                    pos[0]++;
                }
                break;
            case "d":
                while (pos[1] < arr[0].length) {
                    if (arr[pos[0]][pos[1]].matches("#")) {
                        pos[1]--;
                        break;
                    }
                    pos[1]++;
                }
                break;
            case "a":
                while (pos[1] < arr[0].length) {
                    if (arr[pos[0]][pos[1]].matches("#")) {
                        pos[1]++;
                        break;
                    }
                    pos[1]--;
                }
                break;
        }
        arr[pos[0]][pos[1]]="X";
        print(arr);
    }
    public static void print(String [][]arr)
    {
        for (String[] strings : arr) {
            for (int j = 0; j < arr[0].length; j++)
                System.out.print(strings[j]);
            System.out.println();
        }
    }
}