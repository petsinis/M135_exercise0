import java.util.HashMap; 
import java.util.LinkedList; 
import java.util.Queue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
public class MyHw0 {
 public static void main(String[] args) throws FileNotFoundException, IOException {
   Queue<LinkedList<Integer>> id=new LinkedList<>();
   HashMap<Integer, Integer> mapk=new HashMap<>();
   HashMap<Integer, HashMap<Integer, Integer>> map=new HashMap<>();
   try (BufferedReader br=new BufferedReader(new InputStreamReader(System.in))) {
    String l;
    while ((l=br.readLine())!=null){
      String t[]=l.split("\\|");
      int k=Integer.parseInt(t[0]);
      int v=Integer.parseInt(t[1]);
      LinkedList<Integer> mp=new LinkedList<>();
      mp.add(k);
      mp.add(v);
      id.add(mp);
      HashMap<Integer, Integer> temp=new HashMap<>();         
      if(mapk.containsKey(k)){
        temp=map.get(k);
        if(temp.containsKey(v)){
          continue;
        }else{
          int n=mapk.get(k)+1;
          mapk.put(k,n);
          temp=map.get(k);
          temp.put(v,n);
          map.put(k,temp);
        }
     }else{
        mapk.put(k,1);
        temp.put(v,1);
        map.put(k,temp);
     }
   }
  }
  while(!(id.isEmpty())){
    LinkedList mp=id.remove();
    int k=(int) mp.remove();
    int v=(int) mp.remove();
    System.out.println(""+k+"|"+v+"["+map.get(k).get(v)+" of "+mapk.get(k)+"]");
  }
 }
}
