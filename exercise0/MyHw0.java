import java.util.HashMap; 
import java.util.LinkedList; 
import java.util.Queue;
import  javafx.util.Pair;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
public class MyHw0 {
 public static void main(String[] args) throws FileNotFoundException, IOException {
   Queue<Pair> id=new LinkedList<>();
   HashMap<Integer, Integer> mapk=new HashMap<Integer, Integer>();
   HashMap<Integer, HashMap<Integer, Integer>> map=new HashMap<Integer, HashMap<Integer, Integer>>();
   try (BufferedReader br=new BufferedReader(new InputStreamReader(System.in))) {
    String l;
    while ((l=br.readLine())!=null){
      String t[]=l.split("\\|");
      int k=Integer.parseInt(t[0]);
      int v=Integer.parseInt(t[1]);
      Pair<Integer, Integer> mp;
      mp=new Pair<>(k,v);
      id.add(mp);
      HashMap<Integer, Integer> temp=new HashMap<Integer, Integer>();         
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
    Pair mp=id.remove();
    int k=(int)mp.getKey();
    int v=(int)mp.getValue();
    System.out.println(mp.getKey()+"|"+mp.getValue()+"["+map.get(k).get(v)+" of "+mapk.get(k)+"]");
  }
 }
}
