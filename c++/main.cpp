#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;

class info
{
	public:
	string name, notes;
	int qnty;
};
std::vector<info> entry;

void print_find(std::vector<info>::iterator place) { cout <<place->name <<"\n\t" <<place->qnty <<"\n\t" <<place->notes;};
void print_all(info i) {
	cout <<entry.size() <<" entries: \n"
	<<i.name <<"\n\t" <<i.qnty <<"\n\t" <<i.notes <<endl;
};
bool remove(string name)
{
	std::vector<info>::iterator place=find_if(entry.begin(), entry.end(), [name] (info test) {return test.name.compare(name) ==0 ? true: false;});
	if (place != entry.end())
	{
		swap(place, entry.end());
		entry.pop_back();
		return true;
	}
	return false;
}
void enter(string temp_name)
{
	int temp_qnty;
	string temp_notes;
	cout <<"Quantity?\t:";
	cin >>temp_qnty;
	cout <<"Notes?\t:";
	cin.ignore(100, '\n');
	getline(cin, temp_notes);
	std::vector<info>::iterator found=find_if(entry.begin(), entry.end(), [temp_name] (info temp) {return temp.name.compare(temp_name) ==0 ? true : false;});
	if (found == entry.end())
	{
		info temp;
		cout <<"No entry found. Updating\n";
		temp.name=temp_name;
		temp.qnty=temp_qnty;
		temp.notes=temp_notes;
		entry.push_back(temp);
	}
	else found->qnty=temp_qnty;
	return;
}

void readIn(string fname)
{
	info temp;
	ifstream in;
	in.open(fname);
	in >>temp.name >>temp.qnty;
	do
	{
		getline(in, temp.notes);
		entry.push_back(temp);
		in >>temp.name >>temp.qnty;	
	}while (in);
	in.close();
}

void write(string fname)
{
	ofstream out;
	out.open(fname);
	for (int i=0; i < entry.size(); ++i)
	{
		out <<entry[i].name <<" " <<entry[i].qnty <<" " <<entry[i].notes <<endl;
	}	
	out.close();
}

int main()
{
	string file, descriptor;
	char command;
	cout <<"What's the database file?\n>";
	cin >>file;
	readIn(file);
	cout <<"command: ";
	cin >>command;
	for(;;)
	{
		switch (command)
		{
			case 'e': 
			{
				cin >>descriptor;
				enter(descriptor);
			}
				break;
			case 'f':
			{
				cin >>descriptor;
				print_find(find_if(entry.begin(), entry.end(), [descriptor] (info test) {return test.name.compare(descriptor) == 0 ? true :false;}));
			}	
				break;
			case 'l': for_each(entry.begin(), entry.end(), print_all);
				break;
			case 'r':
			{
				cin >>descriptor;
				cout <<remove(descriptor)? "entry removed\n" : "could not find\n";
			}
			case 'q':
			default: goto out;
		}
		cout <<"command: ";
		cin >>command;
	}
	out:
	write(file);
	cout <<"Thanks for using Will's database!\n";
		return 0;
}
