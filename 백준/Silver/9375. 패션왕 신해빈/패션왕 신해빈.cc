#include <bits/stdc++.h>

using namespace std;
using stringMap = multimap<string,string>;
using countMap = map<string,int>;
using spair = pair<string,string>;


void solve(stringMap smap){
    //국 순열 -1,즉 카운트
    countMap cntMap;
    for(const auto &entry : smap){
        //cout<<"first \t"<<entry.first<<" second"<<entry.second<<"\n";
        cntMap[entry.first]++;
    }
    int product =1;
    for(const auto &entry : cntMap){
        //cout<<"first \t"<<entry.first<<" second"<<entry.second<<"\n";
        product*=(entry.second+1);
    }
    cout<<product-1<<"\n";
}


int main(){
    int k,n;
    cin>>k;
    for(int i=0;i<k;i++){
        cin>>n;
        stringMap smap;
        for(int j=0;j<n;j++){
            string str1,str2;
            cin>>str2>>str1;
            smap.insert(spair(str1,str2));
        }
        solve(smap);
    }
}
