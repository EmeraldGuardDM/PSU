(defglobal ?*counter* = 0)
(deffunction ask-question (?question $?allowed-values)
(printout t ?question)
(bind ?answer (read))
(bind ?count 1)
(if (lexemep ?answer)
then
(bind ?answer (lowcase ?answer)))

(if (eq ?answer rs) then (assert (repair restart)) (return))
(while (not (member ?answer ?allowed-values)) do
(bind ?count (+ ?count 1))
(printout t ?question)
(bind ?answer (read))
(if (= ?count 3) then (printout t "Vvedeno 3 raz neverno" crlf))
(if (= ?count 4) then (assert (repair restart)) (return))
(if (lexemep ?answer)
then
(bind ?answer (lowcase ?answer))
)
)
?answer 
)

(deffunction yes-or-no-p (?question) 
(bind ?response (ask-question ?question yes no y n))
(if (or (eq ?response yes) (eq ?response y))
then 
TRUE 
else 
FALSE) 
)

(defrule determine-engine-state ""
(not (working-state engine ?))  
(not (repair ?))
=> 
(if (yes-or-no-p "Does the engine start (yes/no)? ")
then 
(if (yes-or-no-p "Does the engine run normally (yes/no)? ")
then (assert (working-state engine normal))
else (assert (working-state engine unsatisfactory)))
else (assert (working-state engine does-not-start)))
(bind ?*counter* (+ ?*counter* 1))
)
 

(defrule determine-rotation-state ""
(working-state engine does-not-start)
(not (rotation-state engine ?))
(not (repair ?))
=>
(if (yes-or-no-p "Does the engine rotate (yes/no)?")
then
(assert (rotation-state engine rotates))
(assert (spark-state engine irregular-spark))
else (assert (rotation-state engine does-not-rotate))
(assert (spark-state engine does-not-spark)))
(bind ?*counter* (+ ?*counter* 1))
)
 
(defrule determine-gas-level ""
(working-state engine does-not-start)
(rotation-state engine rotates)
(not (repair ?))
=>
(if (not (yes-or-no-p "Does the tank have any gas in it (yes/no)?"))
then (assert (repair "Add gas/")))
(bind ?*counter* (+ ?*counter* 1))
)

(defrule determine-battery-state ""
(rotation-state engine does-not-rotate)
(not (change-state battery ?))
(not (repair ?))
=>
(if (yes-or-no-p "Is the battery charged (yes/no)? ")
then
(assert (change-state battery charged))
else
(assert (repair "Change the battery/"))
(assert (charge-state battery dead)))
(bind ?*counter* (+ ?*counter* 1))
)
 
(defrule determine-low-output ""
(workling-state engine unsatisfactory)
(not (symptom engine low-output I not-low-output))
(not (repair ?))
=>
(if (yes-or-no-p "Is the output of the engine low (yes/no)?")
then (assert (symptom engine low-output))
else (assert (symptom engine not-low-output)))
(bind ?*counter* (+ ?*counter* 1))
)

(defrule determine-point-surface-state ""
(or (and (working-state engine does-not-stark)
(spark-state engine erregular-spark))
(symptom engine low-output))
(not (repair ?))
=>
(bind ?response (ask-question "What is the surface state of the points (normal/burned/contaminated)?"
normal burned contaminated))
(if (eq ?response burned)
then
(assert (repair "Replace the points."))
else
(if (eq ?response contaminated)
then 
(assert (repair "Clean the points."))))
(bind ?*counter* (+ ?*counter* 1))
)

(defrule determine-conductivity-test ""
(working-state engine does-not-start)
(spark-state engine does-not-spark)
(charge-state battery charged)
(not (repair ?))
=>
(if (yes-or-no-p "Is th conductivity test for the ignition coil positive (yes/no)?")
then (assert (repair "Repair the distributor lead wire."))
else (assert (repair "Replace the ignition coil.")))
(bind ?*counter* (+ ?*counter* 1))
)


(defrule determine-sluggishness ""
(working-state engine unsatisfactory)
(not (repair ?))
=> 
(if (yes-or-no-p "Is the engine sluggish (yes/no)?")
then (assert (repair "Clean the fuel line.")))
(bind ?*counter* (+ ?*counter* 1))
)


(defrule determine-misfiring ""
(working-state engine unsatisfactory)
(not (repair ?))
=> 
(if (yes-or-no-p "Is the engine misfire (yes/no)?")
then (assert (repair "Point qap adjustment."))
(assert (spark-state engine irregular-spark)))
(bind ?*counter* (+ ?*counter* 1))
)

(defrule determine-knocking ""
(working-state engine unsatisfactory)
(not (repair ?))
=> 
(if (yes-or-no-p "Does the engine knock (yes/no)? ")
then (assert (repair "Timing adjustment.")))
(bind ?*counter* (+ ?*counter* 1))
)
 
(defrule no-repairs " "
(declare (salience -10))
(not (repair ?))
=>
(assert (repair "Take your car to a mechanic."))
)

(defrule normal-engine-state-conclusions " "
(declare (salience 10))
(working-state engine normal)
=>
(assert (repair "No repair needed."))
(assert (spark-state engine normal))
(assert (charge-state battery charged))
(assert (rotation-state engine rotates))
(bind ?*counter* (+ ?*counter* 1))
)

(defrule unsatisfactory-engine-state-conclusions " "
(declare (salience 10))
(working-state engine unsatisfactory)
=>
(assert (charge-state battery charged))
(assert (rotation-state engine rotates))
(bind ?*counter* (+ ?*counter* 1))
)

(defrule restarter " "
(repair restart)
=>
(if (yes-or-no-p "Restart?(yes\no) ")
then (reset) 
)
)
 
(defrule system-banner " "
(declare (salience 10))
=>
(printout t crlf crlf)
(printout t "************************************" crlf)
(printout t "*The Engine Diagnosis Expert Sestem*" crlf)
(printout t "************************************" crlf)
(printout t crlf crlf) )

(defrule print-repair " "
(declare (salience 10))
(repair ?item)
(not (repair restart))
=>
(printout t crlf crlf)
(printout t "Suggeted Repair:")
(printout t crlf crlf)
(format t " %s%n%n%n" ?item)
(printout t "col pravil: " ?*counter* crlf)
(assert (repair restart))
)
