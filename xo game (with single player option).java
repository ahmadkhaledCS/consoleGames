import java.util.Scanner;
public class test {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("1)two players\n2)single player");
        switch (inp.nextInt())
        {
            case 1: game(false);break;
            case 2: game(true);break;
            default: System.out.println("wrong input");break;
        }
    }
    public static boolean cpu(String [][]arr,String ch)
    {
        System.out.println("player 0 turn");
        String []temp={arr[0][0],arr[1][1],arr[2][2]};
        if(canWin(temp,ch)&&notFull(temp))
        {temp=osPlay(temp,"0");
        arr[0][0]=temp[0];
        arr[1][1]=temp[1];
        arr[2][2]=temp[2];
        return false;}
        temp= new String[]{arr[0][2], arr[1][1], arr[2][0]};
        if(canWin(temp,ch)&&notFull(temp))
        {temp=osPlay(temp,"0");
            arr[0][2]=temp[0];
            arr[1][1]=temp[1];
            arr[2][0]=temp[2];
            return false; }
        for(int i=0;i<3;i++)
        {
            if(canWin(arr[i],ch)&&notFull(arr[i]))
            {osPlay(arr[i],"0");return false;}
            temp= new String[]{arr[0][i], arr[1][i], arr[2][i]};
            if(canWin(temp,ch)&&notFull(temp))
            {osPlay(temp,"0");
            arr[0][i] =temp[0];
            arr[1][i]=temp[1];
            arr[2][i]=temp[2];
            return false;}
        }
        int rand1,rand2;
        if(ch.matches("x")){
            do{
            rand1=(int)(Math.random()*3);
            rand2=(int)(Math.random()*3);
        }
        while(!arr[rand1][rand2].matches(" "));
        arr[rand1][rand2]="0";
        return false;
        }
        return true;
    }
    public static boolean notFull(String []arr)
    {
        for(int i=0;i<3;i++)
            if(arr[i].matches(" "))
                return true;
            return false;
    }
    public static String [] osPlay(String []arr,String ch)
    {
        for(int i=0;i<3;i++)
            if(arr[i].matches(" "))
            {arr[i]=ch;}
        return arr;
    }
    public static boolean canWin(String []arr,String ch) {
        if(arr[0].matches(ch)&&arr[0].matches(arr[1]))
            return true;
        if(arr[0].matches(ch)&&arr[0].matches(arr[2]))
            return true;
        if(arr[1].matches(ch)&&arr[1].matches(arr[2]))
            return true;
        return false;
    }
    public static void game(boolean flag)
    {
        String [][]arr={{" "," "," "},{" "," "," "},{" "," "," "}};
        print(arr);
        while(true)
        {
            play(arr,"x");
            print(arr);
            if(tie(arr))
            {System.out.println("tie!"); break;}
            if(win(arr,"x"))
            {System.out.println("player x wins"); break;}
            if(flag)
            {if(cpu(arr,"0"))cpu(arr,"x");}
            else
                play(arr,"0");
            print(arr);
            if(tie(arr))
            {System.out.println("tie!"); break;}
            if(win(arr,"0"))
            {System.out.println("player 0 wins"); break;}
        }
    }
    public static boolean win(String [][]arr,String ch)
    {
        for(int i=0;i<3;i++)
        {
            if(arr[i][0].matches(ch)&&arr[i][1].matches(ch)&&arr[i][2].matches(ch))
                return true;
            if(arr[0][i].matches(ch)&&arr[1][i].matches(ch)&&arr[2][i].matches(ch))
                return true;
        }
        if(arr[0][0].matches(ch)&&arr[1][1].matches(ch)&&arr[2][2].matches(ch))
            return true;
        if(arr[0][2].matches(ch)&&arr[1][1].matches(ch)&&arr[2][0].matches(ch))
            return true;
        return false;
    }
    public static void print(String [][]arr)
    {
        for(int i=0;i<3;i++)
            System.out.println(arr[i][0]+"|"+arr[i][1]+"|"+arr[i][2]);
    }
    public static String [][] play(String [][]arr,String ch)
    {
        Scanner inp = new Scanner(System.in);
        System.out.println("player "+ch+" turn");
        int num=inp.nextInt();
        if(num>=1&&num<=3&&arr[0][num-1].matches(" "))
            arr[0][num-1]=ch;
        else if(num>=4&&num<=6&&arr[1][num-4].matches(" "))
            arr[1][num-4]=ch;
        else if(num>=7&&num<=9&&arr[2][num-7].matches(" "))
            arr[2][num-7]=ch;
        else{
            System.out.println("wrong input");
            play(arr,ch);
        }
        return arr;
    }
    public static boolean tie(String [][]arr)
    {
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(arr[i][j].matches(" "))
                    return false;
        return true;
    }
}