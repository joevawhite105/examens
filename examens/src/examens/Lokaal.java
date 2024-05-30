package examens;

import java.util.HashSet;
import java.util.Set;
import logicalcollections.LogicalSet;
/**
 * @invar | getExamens() != null
 * @invar | getExamens().stream().allMatch(e -> e != null && e.getLokalen().contains(this))
 */
public class Lokaal {
	/**
	 * @representationObject
	 * @peerObjects
	 * @invar | examens != null
	 * @invar | examens.stream().allMatch(e -> e != null && e.getLokalenInternal().contains(this))
	 */
	 private Set<Examen> examens = new HashSet<>(); 
    /**
     * @post | getExamens().isEmpty()
     */
	
	Set<Examen> getExamensInternal(){
		return Set.copyOf(examens);
	}
	public Lokaal() {}
	/**
	 * @peerObjects
	 * @creates | result
	 */
	public Set<Examen> getExamens() {return Set.copyOf(examens);}
	/**
	 * @pre | exam != null
	 * @pre | !getExamens().contains(this)
	 * 
	 * @mutates_properties | getExamens(), exam.getLokalen()
	 * 
	 * @post | getExamens().equals(LogicalSet.plus(old(getExamens()),exam))
	 * @post | exam.getLokalen().equals(LogicalSet.plus(old(exam.getLokalen()),this))
	 */
	void addExamen(Examen exam) {
		examens.add(exam);
		
		
	}
	/**
	 * @pre | exam != null
	 * @pre | getExamens().contains(this)
	 * 
	 * @mutates_properties | getExamens(), exam.getLokalen()
	 * 
	 * @post | getExamens().equals(LogicalSet.minus(old(getExamens()),exam))
	 * @post | exam.getLokalen().equals(LogicalSet.minus(old(exam.getLokalen()),this))
	 */
	 void deleteExamen(Examen exam) {
		 examens.remove(exam);
	 }

}
