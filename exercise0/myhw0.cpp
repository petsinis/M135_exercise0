#include <iostream>
#include <fstream>
#include <string>
#include <unordered_map>
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
    unordered_map<int, int> map_key;
    unordered_map<int, unordered_map<int,int> >  main_map;
	pairs my_pair;
	unordered_map<int, int> temp_map_value;
    while (cin>>str)
    {
		size_t pos=str.find("|");

        int my_key=stoi((str.substr(0,pos)));
        int my_value=stoi((str.substr(pos+1)));
        
        my_pair.key=my_key;
        my_pair.value=my_value;

        input_data.push(my_pair);
        
        if (map_key.count(my_key)){

            if(main_map[my_key].count(my_value)){
                continue;
            }else{
                map_key[my_key]=map_key[my_key]+1;
                (main_map[my_key])[my_value]=map_key[my_key];
            }
        }else{
            map_key[my_key]=1;
            (main_map[my_key])[my_value]=1;
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
