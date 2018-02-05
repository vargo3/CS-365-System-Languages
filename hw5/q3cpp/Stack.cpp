//Jacob Vargo

#include <vector>
using namespace std;

template<class T, int size>
Stack<T, size>::Stack(int maxsize){
	vec.reserve(maxsize);
}

template<class T, int size>
bool Stack<T, size>::push(T value){
	if (vec.size() == size) return false;
	vec.push_back(value);
	return true;
}

template<class T, int size>
T Stack<T, size>::pop(){
	T rv = vec.back();
	vec.pop_back();
	return rv;
}

template<class T, int size>
bool Stack<T, size>::isEmpty(){
	if (vec.empty()) return true;
	return false;
}
