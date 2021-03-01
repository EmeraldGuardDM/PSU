(deffunction ch (?a)
	(if (<> ?a 0) then
		(ch(div ?a 2))
		(printout t (mod ?a 2))
	else
	(printout t crlf)
)
)