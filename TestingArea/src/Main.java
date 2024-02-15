
public class Main {
    public static void main(String[] args) {
        int count=0;
        for(int i=0;i<1000;i++){
            System.out.print(((int)(Math.random())+1)+" ");
            count++;
            if(count%40==0){
                System.out.println();
            }
        }
    }
}