#include <iostream>
#include <map>
#include <string.h>
#include <fstream>
#include <stdio.h>
#include <stdlib.h>
using namespace std;

int main(int argc,char* argv[]){
    if (argc < 3||argc>4){
        cout<<"---------------------------------------------\n";
        cout<<"help:usage ./a.out yourresult expected_result [flag]|optional\n";
		cout<<"------[flag] 0 show the missing words\n------[flag] 1 show the over cont words\n------[flag] 2 show both\n";
		return 1;
    }
    long size;int bug=0;
    
    char * buffer;
    map<string,bool> out,in;
	ifstream infile;
	
	infile.open(argv[2]);
	infile.seekg (0,ios::end);
    size = infile.tellg();
    infile.seekg(0,ios::beg);
    string tmp;
    
    // 分配内存空间
    buffer=new char[size];
    infile.read (buffer,size);
    
    char* pch;
	pch = strtok (buffer,"\n");
	tmp = (string)pch;
	out[tmp] = false;
    while(pch!=NULL){
        pch = strtok(NULL,"\n");
        if(pch!=NULL){
			tmp = (string)pch;
			
			out[tmp] = false;
        }
        
    }
    
    int mis = 0, not_miss = 0;
    int errfound = 0;
    delete[] buffer;
    infile.close();
    //-------------------------------------------------
    infile.open(argv[1]);
    infile.seekg (0,ios::end);
    size = infile.tellg();
    infile.seekg(0,ios::beg);
    buffer=new char[size];
    infile.read (buffer,size);
 	
	pch = strtok (buffer,"\n");
	tmp = (string)pch;
	
	if(out.find(tmp) != out.end()){
		out[tmp] = true;
		in[tmp] = true;
		not_miss++;
	}else
    {in[tmp] = false;errfound++;}
    
    while(pch!=NULL){
        pch = strtok(NULL,"\n");
        if(pch!=NULL){
			tmp = (string)pch;
			if(out.find(tmp) != out.end()){
				out[tmp] = true;in[tmp] = true;not_miss++;
			}else
			{in[tmp] = false;errfound++;}
        }
        
    }
    delete[] buffer;
    infile.close();
    //checking finished, calculate result;
    double missing;
    double overcont = 1.0*errfound/in.size();
    missing = 1.0*(out.size() - not_miss)/out.size();
	map<string,bool> ::iterator it;
	cout<<"accuray:"<<1-missing<<" recall:"<<1-overcont<<endl;
	cout<<"F-Meaures: "<<((2-missing-overcont)/2)<<endl;
	int flag = -1;
    if(argc ==4 ){
	 	flag = atoi(argv[3]);
    }
	if(flag==0||flag==2){
		cout<<"what we are missing"<<endl;
		for(it=out.begin();it!=out.end();it++){
			if(!it->second){
				cout<<it->first<<endl;
			}
		}
	}
	if(flag==1||flag==2){
		cout<<"what we should not count"<<endl;
		for(it=in.begin();it!=in.end();it++){
			if(!it->second){
				cout<<it->first<<endl;
			}
		}
	}
    
    
}

