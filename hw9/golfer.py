#Jacob Vargo

import sys
import operator

class Golfer:
	name = ""
	scores = []
	handicap = 0.0

	def __init__(self):
		self.scores = []
		self.name = ""
		self.handicap = 0.0

	def computeHandicap(self, courses):
		if len(self.scores) >= 20:
			#sort self.scores by date, most recent first
			self.scores.sort(key = lambda day: float(day[1]), reverse = True)
			self.scores.sort(key = lambda month: float(month[0]), reverse = True)
			self.scores.sort(key = lambda year: float(year[2]), reverse = True)
			diffs = [] 
			for score in self.scores[:20]:
				course = courses[" ".join(score[5:])]
				differential = (float(score[4]) - course.rating) * 113 / course.slope
				diffs.append(differential)
			avg = 0.0
			#sort diffs lowest first
			for d in sorted(diffs)[:10]:
				avg += d
			self.handicap = .96 * avg / 10.0
		else:
			self.handicap = 0.0

class Course:
	name = ""
	slope = 0.0
	rating = 0.0
