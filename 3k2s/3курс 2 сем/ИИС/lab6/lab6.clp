(deftemplate statement
	(field speaker (type SYMBOL))
	(multifield claim (type SYMBOL))
	(multifield reason (type INTEGER) (default 0))
	(field tag (type INTEGER) (default 1))
)


(deftemplate claim
	(multifield content (type SYMBOL))
	(multifield reason (type INTEGER) (default 0))
	(field scope (type SYMBOL))
)


(deftemplate world
	(field tag (type INTEGER) (default 1))
	(field scope (type SYMBOL) (default truth))
)

(deffacts the-facts
	(world)
	(statement (speaker A) (claim F A))
)

(defrule unwrap-true
	(world (tag ?N) (scope truth))
	(statement (speaker ?X) (claim $?Y) (tag ?N))
	=>
	(assert (claim (content T ?X) (reason ?N) (scope truth)))
	(assert (claim (content $?Y) (reason ?N) (scope truth)))
)
(defrule unwrap-false
	(world (tag ?N) (scope falsity))
	(statement (speaker ?X) (claim $?Y) (tag ?N))
	=>
	(assert (claim (content F ?X) (reason ?N) (scope falsity)))
	(assert (claim (content NOT $?Y) (reason ?N) (scope falsity)))
)

(defrule not1
	?F <- (claim (content NOT T ?P))
	=>
	(modify ?F (content F ?P))
)

(defrule not2
	?F <- (claim (content NOT F ?P))
	=>
	(modify ?F (content T ?P))
)

(defrule contra-truth
	(declare (salience 10))
	?W <- (world (tag ?N) (scope truth))
	?S <- (statement (speaker ?Y) (tag ?N))
	?P <- (claim (content T ?X) (reason ?N) (scope truth))
	?Q <- (claim (content F ?X) (reason ?N) (scope truth))
	=>
	(printout t crlf "Statement is inconsistent if " ?Y " is a knight." crlf)
	(retract ?Q)
	(retract ?P)
	(modify ?W (scope falsity))
)

(defrule contra-falsity
	(declare (salience 10))
	?W <- (world (tag ?N) (scope falsity))
	?S <- (statement (speaker ?Y) (tag ?N))
	?P <- (claim (content F ?X) (reason ?N) (scope falsity))
	?Q <- (claim (content T ?X) (reason ?N) (scope falsity))
	=>
	(printout t crlf "Statement is inconsistent if " ?Y " is a knave." crlf)
	(modify ?W (scope contra))
)

(defrule sweep
	(declare (salience 20))
	(world (tag ?N) (scope falsity))
	?F <- (claim (reason ?N) (scope truth))
	=>
	(retract ?F)
)