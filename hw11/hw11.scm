; Jacob Vargo
; hw 11



; Question 1
; return the least of the two values
(define swap
  (lambda (a b)
	(if (> a b) (cons b a) (cons a b))))



; Question 2
; return the average value of the list
(define avg 
  (lambda (lis)
	(if (null? lis)
	  0.0
	  (/
		(letrec ((sum (lambda (lis tot) ; get the sum of the list
						(if (null? lis)
						  tot
						  (sum (cdr lis) (+ tot (car lis)))))))
		  (sum lis 0.0))
		(letrec ((num (lambda (lis tot) ; get the number of elements in the list
						(if (null? lis)
						  tot     
						  (num (cdr lis) (+ tot 1.0))))))
		  (num lis 0.0))))))



; Question 3
; return the least element in the list
(define min
  (lambda (l)
	(if (null? l) '()
	  (letrec ((least
				 (lambda (lis prev)
				   (if (null? lis)
					 prev
					 (least (cdr lis) (if (< prev (car lis)) prev (car lis)))))))
		(least (cdr l) (car l))))))

; Question 4
; given l = '(), and l1 and l2 are sorted
; return a sorted list composed of l1 and l2
(define merger
  (lambda (l l1 l2)
	(cond
	  ((and (null? l1) (null? l2)) l)
	  ((null? l1) (append l l2))
	  ((null? l2) (append l l1))
	  (else (if (< (car l1) (car l2))
			  (merger (append l (cons (car l1) '() )) (cdr l1) l2)
			  (merger (append l (cons (car l2) '() )) l1 (cdr l2)))))))

; split l into equally into l1 and l2
; when l1 and l2 is either empty or has one element, call merger on l1 and l2
(define splitter
  (lambda (l l1 l2 switch)
	(if (null? l)
	  (if (and (or (null? l1) (null? (cdr l1)))
			   (or (null? l2) (null? (cdr l2))))
		(merger '() l1 l2)
		(merger '() (splitter l1 '() '() #f) (splitter l2 '() '() #f)))
	  (if switch
		(splitter (cdr l) (append l1 (cons (car l) '() )) l2 #f)
		(splitter (cdr l) l1 (append l2 (cons (car l) '() )) #t)))))

; takes a list l
; return the list in sorted order using merge sort
(define mergesort
  (lambda (l)
	(splitter l '() '() #f)))



; Question 5
; takes a predicate func and a list l
; returns a list containing all elements of l that satisy the given predicate
(define filter
  (lambda (func l)
	(if (null? l)
	  '()
	  (if (func (car l))
		(append (cons (car l) '() ) (filter func (cdr l)))
		(filter func (cdr l))))))



; Question 6
; takes a list representation of a tree
; returns a list of all the tree leaves in left-to-right order
(define fringe
  (lambda (l)
	(if (or (null? l) (null? (cdr l)))
	  l
	  (letrec ((find
				 (lambda (l ret)
				   (if (null? l)
					 ret
					 (if (null? (cdr (car l)))
					   (find (cdr l) (append ret (car l)))
					   (find (cdr l) (append ret (fringe (car l)))))))))
		(find (cdr l) '() )))))



; Question 7
(define fib
  (letrec ((next
			 (lambda (a b)
			   (cons a (delay (next b (+ a b)))))))
	(next 0 1)))

; print the first n Fibonacci numbers
(define printFib
  (lambda (stream n)
	(letrec ((printNext
			   (lambda (val i)
				 (let ()
				   (display (car val))
				   (display " "))
				 (if (< i n)
				   (printNext (force (cdr val)) (+ i 1))
				   (let () (newline))))))
	  (printNext stream 1))))
