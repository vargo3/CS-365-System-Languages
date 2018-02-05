#Jacob Vargo

import sys
import operator

file_name = sys.argv[1]
words_dict = {}
with open(file_name, 'r') as f:
	myfile = f.read()
	for word in myfile.split():
		if words_dict.has_key(word):
			words_dict[word] += 1
		else:
			words_dict.update({word : 1})
words_list = sorted(words_dict.items(), key=operator.itemgetter(0));
words_list = sorted(words_list, key=operator.itemgetter(1));
for word in words_list:
	print word[0], word[1]
