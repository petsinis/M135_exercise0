#include <iostream>
#include <fstream>
#include <string>
#include <map>
#include <queue>
using namespace std;
struct pairs {
    int key;
    int value;
} ;
int main(int argc, char** argv)
{
    string str;
    queue<pairs> input_data;
    map<int, int> map_key;
    map<int, map<int,int> >  main_map;
    while (getline(cin, str))
    {
        string token1 = (str.substr(0, str.find("|")));
        string token2 = (str.substr(str.find("|")+1,str.length()));


        int my_key=stoi(token1);
        int my_value=stoi(token2);

        pairs my_pair;
        my_pair.key=my_key;
        my_pair.value=my_value;

        input_data.push(my_pair);

        map<int, int> temp_map_value;

        if (map_key.find(my_key) != map_key.end()){
            temp_map_value=main_map[my_key];
            if(temp_map_value.find(my_value)!=temp_map_value.end()){
                continue;
            }else{
                map_key[my_key]=map_key[my_key]+1;
                (main_map[my_key])[my_value]=map_key[my_key];
            }
        }else{
            map_key[my_key]=1;
            (main_map[my_key])[my_value]=map_key[my_key];
        }
    }
    while(!(input_data.empty())){
        pairs my_pair=input_data.front();
        input_data.pop();
        string message1,message2;
        message1=(to_string (my_pair.key)+"|"+to_string (my_pair.value));
        message2=message2+"["+to_string((main_map[my_pair.key])[my_pair.value])+" of "+to_string(map_key[my_pair.key])+"]";
        cout<<message1+message2<<endl;
    }
    return 0;
}
