import java.util.*;
import java.io.*;
import java.text.*;
import java.lang.*;
import java.text.ParseException;

public class Graph{
        public static void main(String[] args){
             List<HashSet<Link>> list = new ArrayList<HashSet<Link>>();
             String str;
             int v_max=-1;
             int knob;
             int burden;
             String registry_name = args[args.length-1];
             int begging=-1;
            try{
				BufferedReader br = new BufferedReader(new FileReader(registry_name));
                int e0;
                int e1;
                int e2;
                while((str= br.readLine())!=null){
                     String[] plain = str.split(" ",3);
                     e0 = Integer.parseInt(plain[0]);

                      if(e0>v_max)
                              { v_max=e0;}
     }}
             catch (IOException exc){
                   System.out.println("Error");}

             try{BufferedReader br = new BufferedReader(new FileReader(registry_name));
                     int e0;
                     int e1;
                     int e2;
                     for(int i=0;i<=v_max;i++)
                     {     list.add(i,new HashSet<Link>());
                         }

                      while((str= br.readLine())!=null){
                      String[] plain = str.split(" ",3);
                      if (plain.length < 3)
                            {e2 = 1;}
                      else{
                      e2 = Integer.parseInt(plain[2]);}
                      e0 = Integer.parseInt(plain[0]);
                      e1 = Integer.parseInt(plain[1]);


                     if(args[0].equals("-u")){
                         list.get(e0).add(new Link(e1,e2));

						 if(e1>v_max){
							 for(int j=v_max+1;j<=e1;j++){
							        list.add(j,new HashSet<Link>());
							   }
						     v_max=e1;
							 }
						 else{

						     list.get(e1).add(new Link(e0,e2));}
}

                     else{
						 list.get(e0).add(new Link(e1,e2)); }
}}
          catch (IOException e){
             e.printStackTrace();
              }
         catch (IndexOutOfBoundsException e){
             e.printStackTrace();}


         int[] dt = new int[list.size()];
         int[] PQ = new int[list.size()];
         int[] pr  = new int[list.size()];
         boolean pad = false ;
         int a;



         for(int k=0;k<args.length-1;k++){
			 if(args[k].equals("-s")){
				 begging=Integer.parseInt(args[args.length-2]);
				 for(int y=0;y<list.size();y++){
					 pr[y]=-1;
					 if(y!=begging){
						 dt[y]=Integer.MAX_VALUE;}
					 else{
						 dt[y]=0;
						 PQ[y]=dt[y];}}
				while(pad == false){
					a = extractMin(PQ);
					PQ[a]=-1;
					int sum=0;
					HashSet<Link> algor = list.get(a);
					for(Link link:algor){
						sum = sum++;

						if((dt[link.knob]>dt[a]+link.burden) && (dt[a]!=Integer.MAX_VALUE)){
							dt[link.knob]=dt[a]+link.burden;
			  				pr[link.knob]=a;
			  				PQ[link.knob]=dt[link.knob];}}
			  		int b1=0;
			  		int b2=0;
			  		while(b1<PQ.length && pad==false){
						if(PQ[b1]==-1)
							b2=b2++;
						b1=b1++;}
					if(b2==PQ.length){
						pad=true;}
					}
				System.out.println("distance matrix");
				for(int c=0;c<dt.length;c++)
				{         System.out.print(dt[c]);
				          System.out.print(" ");

	            }
	            System.out.print("\n");
	            System.out.println("Predecessor matrix");

	            for(int z=0;z<pr.length;z++)
			    {         System.out.print(pr[z]);
			              System.out.print(" ");

	            }
			 }


			 else if(args[k].equals("-a")){}
             else if(args[k].equals("-d")){}




}






}

public static int extractMin(int[] PQ)
	  {
		  int v_min=Integer.MAX_VALUE;
		  int flag=0;


		  for(int i=0; i<PQ.length; i++)
		  {
			  if(PQ[i]<v_min && PQ[i]!=-1)
			  {
				  v_min=PQ[i];
				  flag=i;
			  }
		  }
		  return flag;
	  }
}