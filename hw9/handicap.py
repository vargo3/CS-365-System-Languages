#Jacob Vargo

import sys
import operator
import golfer

score_filename = sys.argv[1]
course_filename = sys.argv[2]

golfers = {}
with open(score_filename, 'r') as f:
	temp_g = golfer.Golfer()
	for line in f:
		words = line.split()
		if golfers.has_key(words[3]):
			temp_g = golfers[words[3]]
		else:
			temp_g = golfer.Golfer()
			temp_g.name = words[3]
			golfers.update({temp_g.name : temp_g})
		temp_g.scores.append(words)

courses = {}
with open(course_filename, 'r') as f:
	temp_c = golfer.Course()
	for line in f:
		words = line.split()
		if len(words) != 0:
			if words[0] == 'Course':
				if temp_c.name != "":
					courses.update({temp_c.name : temp_c})
				temp_c = golfer.Course()
				temp_c.name = " ".join(words[1:])
			elif words[0] == 'Rating':
				temp_c.rating = float(words[1])
				temp_c.slope = float(words[3])

for g in golfers.values():
	g.computeHandicap(courses)

for g in sorted(golfers.values(), key = operator.attrgetter('handicap')):
	print g.handicap, g.name
