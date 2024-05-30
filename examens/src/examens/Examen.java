package examens;

import java.util.HashSet;
import java.util.Set;
import logicalcollections.LogicalSet;
/**
 * @invar | getLokalen() != null
 * @invar | getLokalen().stream().allMatch(l -> l != null && l.getExamens().contains(this))
 */
public class Examen {
	/**
	 * @peerObjects
	 * @representationObject
	 * @invar | lokalen != null
     * @invar | lokalen.stream().allMatch(l -> l != null && l.getExamensInternal().contains(this))
	 */
	 private Set<Lokaal> lokalen = new HashSet<>();
	
	Set<Lokaal> getLokalenInternal(){
		return Set.copyOf(lokalen);
	}
	/**
     * @post | getLokalen().isEmpty()
     */
	public Examen() {}
	/**
	 * @peerObjects
	 * @creates | result
	 */
	public Set<Lokaal> getLokalen() {return Set.copyOf(lokalen);}
	/**
	 * @pre | lok != null
	 * 
	 * @mutates_properties | getLokalen(), lok.getExamens()
	 * 
	 * @post | getLokalen().equals(LogicalSet.plus(old(getLokalen()),lok))
	 * @post | lok.getExamens().equals(LogicalSet.plus(old(lok.getExamens()),this))
	 */
	public void addLokaal(Lokaal lok) {
		lokalen.add(lok);
		lok.addExamen(this);
	}
	/**
	 * @pre | lok != null
	 * @pre | getLokalen().contains(this)
	 * 
	 * @mutates_properties | getLokalen(), lok.getExamens()
	 * 
	 * @post | getLokalen().equals(LogicalSet.minus(old(getLokalen()),lok))
	 * @post | lok.getExamens().equals(LogicalSet.minus(old(lok.getExamens()),this))
	 */
	public void deleteLokaal(Lokaal lok) {
		lok.deleteExamen(this);
		lokalen.remove(lok);
	}

}
